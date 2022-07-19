package com.needle.FsoFso.member.kakao.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:sub-properties/oauth.properties")
public class KakaoOauthInfo {

    @Value("${kakao.client.restAPI}")
    private String clientId;
    @Value("${kakao.url.token}")
    private String tokenUrl;
    @Value("${kakao.url.profile}")
    private String userProfileUrl;
    @Value("${kakao.url.logout}")
    private String logoutUrl;
    @Value("${kakao.url.unlink}")
    private String unlinkUrl;
    @Value("${kakao.redirect}")
    private String redirectUrl;
    @Value("${kakao.client.adminKey}")
    private String adminKey;

    public KakaoOauthInfo() {
    }

    public String getClientId() {
        return clientId;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public String getUserProfileUrl() {
        return userProfileUrl;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public String getUnlinkUrl() {
        return unlinkUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public String getAdminKey() {
        return adminKey;
    }
}
