package com.codecool.spingboot_tasks.request_counter.controller;

import com.codecool.spingboot_tasks.request_counter.service.RequestCountStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    private final RequestCountStatsService service;
    private String method;


    @Autowired
    public TestController(RequestCountStatsService service) {
        this.service = service;
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/api/request")
    public void get() {

    }

    @PostMapping("/api/request")
    public void post() {
        this.method = "POST";
        service.increaseCounter(this.method);
    }

    @DeleteMapping("/api/request")
    public void delete() {
        service.increaseCounter("DELETE");
    }

    @PutMapping("/api/request")
    public void put() {
        service.increaseCounter("PUT");
    }
}
