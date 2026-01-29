package com.example.recomended.service;

import com.example.recomended.dto.InteractionRequest;
import com.example.recomended.dto.RecommendationDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MlService {

    @Value("${app.ml.base-url}")
    private String mlBaseUrl;

    @Autowired
    private  RestTemplate restTemplate;

    public void recordInteraction(InteractionRequest req) {
        try {
            restTemplate.postForObject(mlBaseUrl + "/interaction", req, Void.class);
        } catch (Exception e) {
            log.error("ML interaction call failed", e);
        }
    }

    @Data
    public static class RecommendationResponse {
        private List<RecommendationDto> recommendations;
    }

    public List<RecommendationDto> getRecommendations(Long userId, int k) {

        RecommendationResponse response =
                restTemplate.getForObject(
                        mlBaseUrl + "/recommend/" + userId + "?k=" + k,
                        RecommendationResponse.class
                );

        return response != null
                ? response.getRecommendations()
                : List.of();
    }


    public void trainModel() {
        try {
            restTemplate.postForObject(mlBaseUrl + "/train", null, Void.class);
        } catch (Exception e) {
            log.error("ML train call failed", e);
        }
    }
}

