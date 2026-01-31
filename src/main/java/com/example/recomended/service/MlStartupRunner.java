package com.example.recomended.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MlStartupRunner {
    private final MlService mlService;

    @EventListener(ApplicationReadyEvent.class)
    public void trainModelOnStartup() {
        try {
            mlService.trainModel();
            log.info("ML model trained successfully on startup.");
        } catch (Exception e) {
            log.warn("ML service unavailable during startup training.", e);
        }
    }
}
