package com.example.recomended.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RecommendationDto {
    private String externalId;
    private Double score;
}
