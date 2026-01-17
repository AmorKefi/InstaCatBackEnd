package com.example.instaCatBack.bootstrap;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.instaCatBack.application.CatService;

@Component
public class CatDataInitializer {

    private final CatService catService;

    public CatDataInitializer(CatService catService) {
        this.catService = catService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initCats() {
        catService.loadCatsFromRemoteIfEmpty();
    }
}

