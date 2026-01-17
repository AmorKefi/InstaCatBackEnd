package com.example.instaCatBack.infrastructure.remote;

import java.util.List;

public record CatsApiResponse(List<Cat> images) {

    public record Cat(String id, String url) {}
}
