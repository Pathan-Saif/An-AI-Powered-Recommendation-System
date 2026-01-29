package com.example.recomended.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
public class PingController {

    @GetMapping("/ping")
    public ResponseEntity<Map<String, Object>> ping() {
        return ResponseEntity.ok(
                Map.of(
                        "status", "UP",
                        "service", "recommendation-backend",
                        "timestamp", Instant.now().toString()
                )
        );
    }
}

