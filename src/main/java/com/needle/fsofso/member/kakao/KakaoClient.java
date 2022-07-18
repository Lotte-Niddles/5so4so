package com.needle.fsofso.member.kakao;

import com.needle.fsofso.member.MemberService;
import com.needle.fsofso.member.kakao.dto.KakaoOauthInfo;
import com.needle.fsofso.member.kakao.dto.KakaoTokenRequest;
import com.needle.fsofso.member.kakao.dto.KakaoUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KakaoClient {

    private static final String CONTENT_TYPE = "Content-type";
    private static final String AUTHORIZATION = "Authorization";
    private static final String DEFAULT_CHARSET = "application/x-www-form-urlencoded;charset=utf-8";
    private static final String GRANT_TYPE = "authorization_code";
    private static final String BEARER_FORM = "Bearer %s";
    private static final String ACCESS_TOKEN = "access_token";

    private final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final RestTemplate restTemplate = new RestTemplate();
    private final ClientResponseConverter converter;
    private final KakaoOauthInfo kakaoOauthInfo;

    public KakaoClient(ClientResponseConverter converter, KakaoOauthInfo kakaoOauthInfo) {
        this.converter = converter;
        this.kakaoOauthInfo = kakaoOauthInfo;
    }

    public KakaoUserInfo kakaoInfo(String code) {
        final String accessToken = accessToken(code);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION, String.format(BEARER_FORM, accessToken));

        final ResponseEntity<String> response = restTemplate.exchange(
                kakaoOauthInfo.getUserProfileUrl(),
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                String.class
        );
        return converter.extractDataAsAccount(response.getBody());
    }

    private void unlink(String accessToken) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION, String.format(BEARER_FORM, accessToken));
        restTemplate.exchange(
                kakaoOauthInfo.getUnlinkUrl(),
                HttpMethod.POST,
                new HttpEntity<>(httpHeaders),
                String.class
        );
    }

    private String accessToken(String code) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(CONTENT_TYPE, DEFAULT_CHARSET);

        final ResponseEntity<String> response = restTemplate.exchange(
                kakaoOauthInfo.getTokenUrl(),
                HttpMethod.POST,
                new HttpEntity<>(
                        converter.convertHttpBody(new KakaoTokenRequest(
                                GRANT_TYPE,
                                kakaoOauthInfo.getClientId(),
                                kakaoOauthInfo.getRedirectUrl(),
                                code
                        )),
                        httpHeaders
                ),
                String.class
        );

        return converter.extractDataAsString(response.getBody(), ACCESS_TOKEN);
    }

}
