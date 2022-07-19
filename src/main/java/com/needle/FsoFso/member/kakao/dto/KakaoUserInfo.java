package com.needle.FsoFso.member.kakao.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class KakaoUserInfo {

    @JsonProperty(value = "id")
    private Long providerId;
    @JsonProperty(value = "kakao_account")
    private KakaoAccount kakaoAccount;

    public KakaoUserInfo() {
    }

    public KakaoUserInfo(Long providerId, KakaoAccount kakaoAccount) {
        this.providerId = providerId;
        this.kakaoAccount = kakaoAccount;
    }

    public Long getProviderId() {
        return providerId;
    }

    public KakaoAccount getKakaoAccount() {
        return kakaoAccount;
    }

    public String getAgeRange() {
        return getKakaoAccount().getAgeRange();
    }

    public boolean hasAgeRange() {
        return getKakaoAccount().hasAgeRance();
    }

    public boolean hasGender() {
        return getKakaoAccount().hasGender();
    }

    public String getNickname() {
        return getKakaoAccount().getNickname();
    }

    public String getGender() {
        return getKakaoAccount().getGender();
    }

    private static class KakaoAccount {

        @JsonProperty(value = "profile")
        private Profile profile;
        @JsonProperty(value = "has_age_range")
        private Boolean hasAgeRange;
        @JsonProperty(value = "age_range")
        private String ageRange;
        @JsonProperty(value = "has_gender")
        private Boolean hasGender;
        @JsonProperty(value = "gender")
        private String gender;

        public KakaoAccount() {
        }

        public KakaoAccount(Profile profile, Boolean hasAgeRange, String ageRange,
                Boolean hasGender,
                String gender) {
            this.profile = profile;
            this.hasAgeRange = hasAgeRange;
            this.ageRange = ageRange;
            this.hasGender = hasGender;
            this.gender = gender;
        }

        public Profile getProfile() {
            return profile;
        }

        public Boolean getHasAgeRange() {
            return hasAgeRange;
        }

        public String getAgeRange() {
            return ageRange;
        }

        public String getGender() {
            return gender;
        }

        public String getNickname() {
            return getProfile().getNickname();
        }

        public void setProfile(Profile profile) {
            this.profile = profile;
        }

        public void setHasAgeRange(Boolean hasAgeRange) {
            this.hasAgeRange = hasAgeRange;
        }

        public void setAgeRange(String ageRange) {
            this.ageRange = ageRange;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public boolean hasAgeRance() {
            return hasAgeRange;
        }

        public boolean hasGender() {
            return hasGender;
        }
    }

    private static class Profile {

        @JsonProperty(value = "nickname")
        private String nickname;

        public Profile() {
        }

        public Profile(String nickname) {
            this.nickname = nickname;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }

}
