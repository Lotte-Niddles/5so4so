package com.needle.FsoFso.member.kakao.dto;

public class KakaoTokenRequest {

    private String grant_type;
    private String client_id;
    private String redirect_uri;
    private String code;

    public KakaoTokenRequest() {
    }

    public KakaoTokenRequest(String grant_type, String client_id, String redirect_uri, String code) {
        this.grant_type = grant_type;
        this.client_id = client_id;
        this.redirect_uri = redirect_uri;
        this.code = code;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public String getCode() {
        return code;
    }
}
