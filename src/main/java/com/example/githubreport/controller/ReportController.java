package com.example.githubreport.controller;

import com.example.githubreport.service.ReportService;
import org.springframework.web.bind.annotation.*;
import com.example.githubreport.model.UserRepoResponse;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping("/access-report")
    public List<UserRepoResponse> getReport() {
        return service.generateReport();
    }
}