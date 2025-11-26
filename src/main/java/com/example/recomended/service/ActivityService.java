package com.example.recomended.service;

import com.example.recomended.dto.InteractionRequest;
import com.example.recomended.entity.Item;
import com.example.recomended.entity.UserActivity;
import com.example.recomended.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final ItemService itemService;

    public UserActivity recordInteraction(InteractionRequest req) {
        Item item = itemService.findOrCreateByExternalId(req.getExternalItemId());
        UserActivity ua = UserActivity.builder()
                .userId(req.getUserId())
                .itemId(item.getId())
                .eventType(req.getEventType())
                .value(req.getValue())
                .build();
        return activityRepository.save(ua);
    }
}
