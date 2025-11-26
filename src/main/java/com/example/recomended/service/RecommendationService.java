package com.example.recomended.service;

import com.example.recomended.dto.RecommendationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${app.ml.base-url}")
    private String mlBaseUrl;

    @Value("${app.ml.recommend-endpoint}")
    private String mlRecommendEndpoint;

    public List<RecommendationDto> getRecommendations(Long userId, int k) {
        String url = UriComponentsBuilder.fromHttpUrl(mlBaseUrl)
                .path(mlRecommendEndpoint)
                .queryParam("userId", userId)
                .queryParam("k", k)
                .toUriString();

        // Expect JSON array: [{ "external_id": "id", "score": 0.9}, ...]
        RecommendationDto[] result = restTemplate.getForObject(url, RecommendationDto[].class);
        if (result == null) return List.of();
        return Arrays.asList(result);
    }
}
