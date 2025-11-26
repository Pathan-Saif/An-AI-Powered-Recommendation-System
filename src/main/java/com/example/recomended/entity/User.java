package com.example.recomended.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String email;

    private String name;

    @Column(nullable=false)
    private String passwordHash;

    private String role; // e.g., "USER" or "ADMIN"

    private Instant createdAt;

    @PrePersist
    public void prePersist() { createdAt = Instant.now(); }
}
