package com.needle.fsofso.member;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.Map;

@Component
public class ClientResponseConverter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> MultiValueMap<String, String> convertHttpBody(T body) {
        final LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        final Map<String, String> bodyMap = objectMapper.convertValue(body, new TypeReference<>() {
        });
        params.setAll(bodyMap);
        return params;
    }

    public String extractDataAsString(String json, String dataKey) {
        try {
            return objectMapper.readTree(json).get(dataKey).asText();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
