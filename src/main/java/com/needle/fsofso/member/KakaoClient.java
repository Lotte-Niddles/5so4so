package com.needle.fsofso.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
    private final ClientResponseConverter converter;
    private final KakaoOauthInfo kakaoOauthInfo;

    public KakaoClient(ClientResponseConverter converter, KakaoOauthInfo kakaoOauthInfo) {
        this.converter = converter;
        this.kakaoOauthInfo = kakaoOauthInfo;
    }

    public void kakaoInfo(String code) {
        final String accessToken = accessToken(code);
//        log.info(TOKEN);


//        unlink(TOKEN);

        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION, String.format(BEARER_FORM, accessToken));
        final RestTemplate restTemplate = new RestTemplate();

        final ResponseEntity<String> response = restTemplate.exchange(
                kakaoOauthInfo.getUserProfileUrl(),
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                String.class
        );
        log.info(response.getBody());

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

        RestTemplate restTemplate = new RestTemplate();

        final MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("grant_type", GRANT_TYPE);
        multiValueMap.add("client_id", kakaoOauthInfo.getClientId());
        multiValueMap.add("redirect_uri", kakaoOauthInfo.getRedirectUrl());
        multiValueMap.add("code", code);

        final ResponseEntity<String> response = restTemplate.exchange(
                kakaoOauthInfo.getTokenUrl(),
                HttpMethod.POST,
                new HttpEntity<>(
                        multiValueMap, httpHeaders
                ),
                String.class
        );
        return converter.extractDataAsString(response.getBody(), ACCESS_TOKEN);
    }

}
