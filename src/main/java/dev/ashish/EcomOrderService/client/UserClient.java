package dev.ashish.EcomOrderService.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class UserClient {
    @Autowired
    private RestTemplateBuilder builder;

    private String userClientApiBaseUrl;
    private String userClientApiCheckUserPath;

    public boolean doesUserExists(UUID userId) {
        String url = userClientApiBaseUrl.concat(userClientApiCheckUserPath);

        RestTemplate restTemplate = builder.build();
        ResponseEntity<Boolean> isUser = restTemplate.getForEntity(url, Boolean.class);
        return isUser.getBody();
    }
}
