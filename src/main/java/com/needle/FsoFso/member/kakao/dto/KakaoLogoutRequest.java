package com.needle.FsoFso.member.kakao.dto;

public class KakaoLogoutRequest {

    private String target_id_type;
    private Long target_id;

    public KakaoLogoutRequest() {
    }

    public KakaoLogoutRequest(String target_id_type, Long target_id) {
        this.target_id_type = target_id_type;
        this.target_id = target_id;
    }

    public String getTarget_id_type() {
        return target_id_type;
    }

    public Long getTarget_id() {
        return target_id;
    }
}
