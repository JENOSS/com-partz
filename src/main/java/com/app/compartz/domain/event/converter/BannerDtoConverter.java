package com.app.compartz.domain.event.converter;

import com.app.compartz.domain.event.model.Banner;
import com.app.compartz.dto.event.BannerDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BannerDtoConverter {
    private final Banner origin;

    public BannerDto convert() {
        return BannerDto.builder()
                .id(origin.getId())
                .name(origin.getName())
                .image(origin.getImage())
                .build();
    }
}
