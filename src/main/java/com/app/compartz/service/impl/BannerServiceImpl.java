package com.app.compartz.service.impl;

import com.app.compartz.domain.event.converter.BannerDtoConverter;
import com.app.compartz.domain.event.repository.BannerRepository;
import com.app.compartz.dto.event.BannerDto;
import com.app.compartz.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {
    private final BannerRepository bannerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BannerDto> getBanners() {
        return bannerRepository.findAll().stream()
                .map(BannerDtoConverter::new)
                .map(BannerDtoConverter::convert)
                .toList();
    }
}
