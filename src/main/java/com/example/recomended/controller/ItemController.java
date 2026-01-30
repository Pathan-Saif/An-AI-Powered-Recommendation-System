package com.example.recomended.controller;

import com.example.recomended.entity.Item;
import com.example.recomended.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item req) {
        return ResponseEntity.ok(itemService.createItem(req.getExternalId(), req.getTitle(), req.getMetadata()));
    }

    @GetMapping
    public ResponseEntity<List<Item>> list() {
        List<Item> items = itemService.listRecent();
        items.forEach(i -> System.out.println(i.getExternalId()));
        return ResponseEntity.ok(items);
    }
}
