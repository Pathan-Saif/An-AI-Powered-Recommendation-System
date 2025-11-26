package com.example.recomended.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "items")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String externalId; // e.g., sku or movie id

    @Column(nullable=false)
    private String title;

    @Column(columnDefinition = "text")
    private String metadata; // JSON string if needed

    private Instant createdAt;

    @PrePersist
    public void prePersist() { createdAt = Instant.now(); }
}
