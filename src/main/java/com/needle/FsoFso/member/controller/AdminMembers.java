package com.needle.FsoFso.member.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:sub-properties/admin.properties")
public class AdminMembers {

    @Value("#{'${admin-users}'.split(', ')}")
    private List<String> adminUsers;

    public List<String> getAdminUsers() {
        return adminUsers;
    }

    public boolean contains(Long id) {
        return adminUsers.contains(String.valueOf(id));
    }
}
