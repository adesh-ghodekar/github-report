package com.example.githubreport.service;

import com.example.githubreport.client.GitHubClient;
import org.springframework.stereotype.Service;
import com.example.githubreport.model.UserRepoResponse;

import java.util.*;

@Service
public class ReportService {

    private final GitHubClient gitHubClient;

    public ReportService(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }

    public List<UserRepoResponse> generateReport() {

        Map<String, List<String>> userRepoMap = new HashMap<>();

        List<Map<String, Object>> repos = gitHubClient.getRepositories();

        for (Map<String, Object> repo : repos) {

            String repoName = (String) repo.get("name");

            List<Map<String, Object>> users =
                    gitHubClient.getCollaborators(repoName);

            for (Map<String, Object> user : users) {

                String username = (String) user.get("login");

                userRepoMap
                        .computeIfAbsent(username, k -> new ArrayList<>())
                        .add(repoName);
            }
        }

        List<UserRepoResponse> result = new ArrayList<>();

        for (String user : userRepoMap.keySet()) {
            result.add(new UserRepoResponse(user, userRepoMap.get(user)));
        }

        return result;
    }
}