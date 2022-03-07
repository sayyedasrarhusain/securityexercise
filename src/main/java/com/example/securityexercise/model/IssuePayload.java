package com.example.securityexercise.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class IssuePayload {
    private String title ;
    private String body;
    private String assignee;
}
