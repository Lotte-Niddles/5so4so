package com.needle.fsofso.member;

import org.slf4j.LoggerFactory;

import java.time.Instant;

public class Member {

    private Long providerId;
    private String nickname;
    private String ageRange;
    private Instant createdAt;
    private Instant updatedAt;

    public Member() {
    }

    public Member(Long providerId, String nickname, String ageRange) {
        this.providerId = providerId;
        this.nickname = nickname;
        this.ageRange = ageRange;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public Long getProviderId() {
        return providerId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
