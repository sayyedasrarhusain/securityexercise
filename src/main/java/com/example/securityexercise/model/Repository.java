package com.example.securityexercise.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Repository {
    private Long id;
    private String name;
    private String full_name;
    private String html_url;
    private String git_url;
    private String url;
}
