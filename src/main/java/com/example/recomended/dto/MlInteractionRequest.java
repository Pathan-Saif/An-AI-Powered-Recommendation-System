package com.example.recomended.dto;

import lombok.Data;

@Data
public class MlInteractionRequest {
    private int userId;
    private String externalItemId;
    private String eventType;
}

