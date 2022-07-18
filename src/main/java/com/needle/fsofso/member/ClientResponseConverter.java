package com.needle.fsofso.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ClientResponseConverter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String extractDataAsString(String json, String dataKey) {
        try {
            return objectMapper.readTree(json).get(dataKey).asText();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
