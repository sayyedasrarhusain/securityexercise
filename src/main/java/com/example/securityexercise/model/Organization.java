package com.example.securityexercise.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Organization {
    private Long id;
    private String name;
    private String description;
    private String url;
}
