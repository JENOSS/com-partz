package com.app.compartz.controller;

import com.app.compartz.dto.event.BannerDto;
import com.app.compartz.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/banners")
public class BannerController {
    private final BannerService bannerService;

    @GetMapping
    public ResponseEntity<List<BannerDto>> getBanners() {
        return ResponseEntity.ok(bannerService.getBanners());
    }
}
