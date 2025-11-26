package com.example.recomended.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class InteractionRequest {
    private Long userId;
    private String externalItemId;
    private String eventType;
    private Double value = 1.0;
}
