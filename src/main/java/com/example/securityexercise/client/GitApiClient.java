package com.example.securityexercise.client;

import com.example.securityexercise.model.IssuePayload;
import com.example.securityexercise.model.ProtectionPayload;
import com.example.securityexercise.model.ReadmePayload;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.net.URI;

@FeignClient(name="git" , url="http://github.com")
public interface GitApiClient {
    
    @PutMapping( "/README.md")
    public void createReadme(URI baseUrl , @RequestHeader("Authorization") String auth,
                             @RequestBody ReadmePayload payload ) ;

    @PutMapping("/protection")
    public void protectBranch(URI baseUrl, @RequestHeader("Authorization") String auth,
                              @RequestBody ProtectionPayload payload);

    @PostMapping("/issues")
    void createIssue(URI baseUrl, @RequestHeader("Authorization") String auth,
                     @RequestBody IssuePayload payload);
}
