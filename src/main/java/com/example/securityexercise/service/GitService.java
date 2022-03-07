package com.example.securityexercise.service;

import com.example.securityexercise.client.GitApiClient;
import com.example.securityexercise.model.IssuePayload;
import com.example.securityexercise.model.ProtectionPayload;
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
        URI baseUrl = URI.create( repoUrl + "/branches/master");
        ProtectionPayload payload = new ProtectionPayload();
        gitClient.protectBranch(baseUrl, auth, payload);
        log.info("Protections applied to master branch for repo : " + repoUrl);
    }

    public void notify(String repoUrl) {
        IssuePayload payload = IssuePayload.builder()
                .title("Create Restrictions on Master Branch")
                .body("@asrarhusain \n New restrictions added to master branch for repo " +repoUrl)
                .assignee("asrarhusain")
                .build();
        URI baseUrl = URI.create( repoUrl );
        gitClient.createIssue(baseUrl, auth, payload);
        log.info("Created issue in : " + repoUrl);
    }
}
