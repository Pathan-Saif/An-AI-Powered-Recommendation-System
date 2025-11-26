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
            @PathVariable Long userId, @RequestParam(defaultValue = "10") int k) {
        var recs = recommendationService.getRecommendations(userId, k);
        return ResponseEntity.ok(recs);
    }
}
