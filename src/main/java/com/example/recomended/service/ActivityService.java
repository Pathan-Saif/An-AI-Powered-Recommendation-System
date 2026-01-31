package com.example.recomended.service;

import com.example.recomended.dto.InteractionRequest;
import com.example.recomended.entity.Item;
import com.example.recomended.entity.UserActivity;
import com.example.recomended.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final ItemService itemService;
    private final MlService mlService;

    public UserActivity recordInteraction(InteractionRequest req) {
        Item item = itemService.findOrCreateByExternalId(req.getExternalItemId());
        UserActivity ua = UserActivity.builder()
                .userId(req.getUserId())
                .itemId(item.getId())
                .eventType(req.getEventType())
                .value(req.getValue())
                .build();
        UserActivity saved = activityRepository.save(ua);

        try {
            mlService.recordInteraction(req);
        } catch (Exception e) {
            log.warn("ML service unavailable, interaction saved only in DB", e);
        }

        return saved;
    }
}
