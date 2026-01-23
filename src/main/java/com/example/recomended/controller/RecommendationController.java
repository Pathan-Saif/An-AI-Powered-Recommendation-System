package com.example.recomended.controller;

import com.example.recomended.dto.RecommendationDto;
import com.example.recomended.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recommend")
@RequiredArgsConstructor
public class RecommendationController {
    private final RecommendationService recommendationService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<RecommendationDto>> recommend(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "10") int k) {

        if (userId == null || k <= 0) {
            return ResponseEntity.badRequest().build(); // 400 if invalid
        }

        return ResponseEntity.ok(recommendationService.getRecommendations(userId, k));
    }

}
