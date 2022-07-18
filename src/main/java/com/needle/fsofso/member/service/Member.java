package com.needle.fsofso.member.service;

import java.time.Instant;

public class Member {

    private Long id;
    private Long providerId;
    private String nickname;
    private String ageRange;
    private Instant createdAt;
    private Instant updatedAt;

    public Member() {
    }

    public Member(Long id, Long providerId, String nickname, String ageRange, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.providerId = providerId;
        this.nickname = nickname;
        this.ageRange = ageRange;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Member(Long providerId, String nickname, String ageRange) {
        this.providerId = providerId;
        this.nickname = nickname;
        this.ageRange = ageRange;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public Long getId() {
        return id;
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
