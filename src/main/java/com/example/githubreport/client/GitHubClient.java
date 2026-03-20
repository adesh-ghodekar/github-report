package com.example.githubreport.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GitHubClient {

    @Value("${github.token}")
    private String token;

    @Value("${github.org}")
    private String org;

    private final RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        headers.set("Accept", "application/vnd.github.v3+json");
        return headers;
    }

    public List<Map<String, Object>> getRepositories() {
        String url = "https://api.github.com/users/" + org + "/repos?per_page=100";

        HttpEntity<String> entity = new HttpEntity<>(getHeaders());

        ResponseEntity<Map[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                Map[].class
        );

        return Arrays.asList(response.getBody());
    }

    public List<Map<String, Object>> getCollaborators(String repoName) {
        String url = "https://api.github.com/repos/" + org + "/" + repoName + "/collaborators?per_page=100";

        HttpEntity<String> entity = new HttpEntity<>(getHeaders());

        ResponseEntity<Map[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                Map[].class
        );

        return Arrays.asList(response.getBody());
    }
}