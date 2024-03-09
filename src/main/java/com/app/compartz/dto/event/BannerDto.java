package com.app.compartz.dto.event;

import lombok.Builder;

public record BannerDto(Long id,
                        String name,
                        String image) {

    @Builder
    public BannerDto {

    }
}
