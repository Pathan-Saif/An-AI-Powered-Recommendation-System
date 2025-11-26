package com.example.recomended.service;


import com.example.recomended.entity.Item;
import com.example.recomended.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Item createItem(String externalId, String title, String metadata) {
        if (itemRepository.findByExternalId(externalId).isPresent()) {
            throw new RuntimeException("Item exists");
        }
        Item item = Item.builder().externalId(externalId).title(title).metadata(metadata).build();
        return itemRepository.save(item);
    }

    public List<Item> listRecent() { return itemRepository.findTop50ByOrderByCreatedAtDesc(); }

    public Item findOrCreateByExternalId(String externalId) {
        return itemRepository.findByExternalId(externalId)
                .orElseGet(() -> itemRepository.save(Item.builder().externalId(externalId).title(externalId).build()));
    }
}
