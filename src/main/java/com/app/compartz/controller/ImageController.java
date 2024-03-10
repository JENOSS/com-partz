package com.app.compartz.controller;

import com.app.compartz.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
public class ImageController {
    private final ImageService imageService;

    @GetMapping("/name")
    private ResponseEntity<Resource> getImage(@PathVariable("name") String name) {
        var image = imageService.getImage(name);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // 이미지 타입에 맞게 변경
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getFilename() + "\"")
                .body(image);
    }
}
