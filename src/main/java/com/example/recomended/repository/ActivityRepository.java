package com.example.recomended.repository;

import com.example.recomended.entity.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActivityRepository extends JpaRepository<UserActivity, Long> {
    List<UserActivity> findByUserIdOrderByCreatedAtDesc(Long userId);
}
