package com.example.securityexercise.service;

import com.example.securityexercise.client.GitApiClient;
import com.example.securityexercise.model.ReadmePayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Base64;

@Service
@Slf4j
public class GitService {

    @Autowired
    GitApiClient gitClient;

    @Value("${githook.auth}")
    private String auth;

    public void createReadme(String repoUrl, String name) {
        URI baseUrl = URI.create( repoUrl + "/contents");
        ReadmePayload payload = ReadmePayload.builder()
                .name("README.md")
                .message("Creating Readme.md")
                .content(
                        Base64.getEncoder().encodeToString(
                                ("Initial readme for " + name).getBytes()
                        )
                )
                .build();

        gitClient.createReadme(baseUrl, auth,  payload);
        log.info("Created Readme.md file in repo" + name);
    }

    public void protectMasterBranch(String repoUrl) {

    }

    public void notify(String repoUrl) {

    }
}
