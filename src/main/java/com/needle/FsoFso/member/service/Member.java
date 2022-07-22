package com.needle.FsoFso.member.service;

import java.time.Instant;
import java.util.Optional;

public class Member {

    private Long id;
    private Long providerId;
    private String nickname;
    private String gender;
    private String ageRange;
    private Instant createdAt;
    private Instant updatedAt;

    public Member() {
    }

    public Member(Long id, Long providerId, String nickname, String gender, String ageRange,
            Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.providerId = providerId;
        this.nickname = nickname;
        this.gender = gender;
        this.ageRange = ageRange;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Member(Long providerId, String nickname, String gender, String ageRange) {
        this.providerId = providerId;
        this.nickname = nickname;
        this.gender = gender;
        this.ageRange = ageRange;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public Member(Member member, String nickname) {
        this(
                member.getId(),
                member.getProviderId(),
                nickname,
                Optional.ofNullable(member.getGender()).orElseGet(() -> null),
                Optional.ofNullable(member.getAgeRange()).orElseGet(() -> null),
                member.getCreatedAt(),
                Instant.now()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
