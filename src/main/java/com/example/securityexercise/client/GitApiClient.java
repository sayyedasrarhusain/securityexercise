package com.example.securityexercise.client;

import com.example.securityexercise.model.ReadmePayload;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import java.net.URI;

@FeignClient(name="git" , url="http://github.com")
public interface GitApiClient {
    
    @PutMapping( "/README.md")
    @Headers({"Content-Type: application/vnd.github.v3+json"})
    public void createReadme(URI baseUrl , ReadmePayload payload ) ;
}
