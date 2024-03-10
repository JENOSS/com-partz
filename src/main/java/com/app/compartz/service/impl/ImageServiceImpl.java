package com.app.compartz.service.impl;

import com.app.compartz.component.exception.CustomException;
import com.app.compartz.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
    private static final String IMAGE_DIRECTORY = "src/main/resources/static/images";

    public Resource getImage(String name) {
        try {
            var image = "/" + name;
            var imagePath = Paths.get(IMAGE_DIRECTORY).resolve(image);
            var resource = new UrlResource(imagePath.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new CustomException(HttpStatus.BAD_REQUEST, "존재하지 않는 이미지 아이디 입니다. ");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, "이미지를 가져오는데 문제가 발생했습니다: ");
        }

    }
}
