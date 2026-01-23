package com.example.recomended.controller;

import com.example.recomended.dto.InteractionRequest;
import com.example.recomended.entity.UserActivity;
import com.example.recomended.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<UserActivity> record(@RequestBody InteractionRequest req) {
        return ResponseEntity.ok(activityService.recordInteraction(req));
    }
}

