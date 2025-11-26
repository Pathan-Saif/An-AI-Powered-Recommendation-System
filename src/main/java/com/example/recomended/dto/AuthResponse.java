package com.example.recomended.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AuthResponse {
    private String token;
    private Long userId;
    private String email;
    private String name;
}
