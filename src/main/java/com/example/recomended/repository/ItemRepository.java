package com.example.recomended.repository;

import com.example.recomended.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByExternalId(String externalId);
    List<Item> findTop50ByOrderByCreatedAtDesc();
}
