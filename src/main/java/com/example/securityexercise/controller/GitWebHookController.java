package com.example.securityexercise.controller;

import com.example.securityexercise.client.GitApiClient;
import com.example.securityexercise.model.Event;
import com.example.securityexercise.model.ReadmePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;

@RestController
public class GitWebHookController {
    @Autowired
    GitApiClient gitClient;

    @PostMapping("/")
    public void eventHandler(@RequestBody Event event) {
        URI baseUrl = URI.create(event.getRepository().getUrl() + "/contents");
        ReadmePayload payload = ReadmePayload.builder()
                .name("README.md")
                .message("Creating Readme.md")
                .content("Initial readme for " + event.getRepository().getName())
                .build();

        gitClient.createReadme(baseUrl, payload);

    }
}
