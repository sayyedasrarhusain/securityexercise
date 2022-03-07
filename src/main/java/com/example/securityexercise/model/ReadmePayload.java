package com.example.securityexercise.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReadmePayload {
    private String message;
    private String name;
    private String content;
}
