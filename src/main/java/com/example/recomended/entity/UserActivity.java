package com.example.recomended.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "user_activities")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserActivity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private Long userId;

    @Column(nullable=false)
    private Long itemId;

    @Column(nullable=false)
    private String eventType; // view, click, like, purchase

    private Double value = 1.0;

    private Instant createdAt;

    @PrePersist
    public void prePersist() { createdAt = Instant.now(); }
}
