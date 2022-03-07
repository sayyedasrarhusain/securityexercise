package com.example.securityexercise.controller;

import com.example.securityexercise.model.Event;
import com.example.securityexercise.model.enums.ActionType;
import com.example.securityexercise.service.GitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GitWebHookController {

    @Autowired
    private GitService readmeService;

    @PostMapping("/")
    public void eventHandler(@RequestBody Event event) {
        log.info("Received event: " + event);
        if (event.getAction() == ActionType.created) {
            readmeService.createReadme(event.getRepository().getUrl(), event.getRepository().getName());
        }

    }
}
