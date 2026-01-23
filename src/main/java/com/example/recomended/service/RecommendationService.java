package com.example.recomended.service;

import com.example.recomended.dto.RecommendationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${app.ml.base-url}")
    private String mlBaseUrl;

    @Value("${app.ml.recommend-endpoint}")
    private String mlRecommendEndpoint;

    public List<RecommendationDto> getRecommendations(Long userId, int k) {
        String url = mlBaseUrl + mlRecommendEndpoint.replace("{user_id}", userId.toString()) + "?k=" + k;

        ResponseEntity<Map> resp = restTemplate.getForEntity(url, Map.class);
        if (!resp.getStatusCode().is2xxSuccessful() || resp.getBody() == null) return List.of();

        Object recsObj = resp.getBody().get("recommendations");
        if (!(recsObj instanceof List)) return List.of();

        List<Map<String, Object>> recList = (List<Map<String, Object>>) recsObj;
        return recList.stream().map(r -> {
            RecommendationDto dto = new RecommendationDto();
            dto.setExternalId((String) r.get("externalId"));
            dto.setScore(Double.parseDouble(r.get("score").toString()));
            return dto;
        }).toList();
    }


}
