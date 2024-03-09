package com.app.compartz.service.impl;

import com.app.compartz.service.ImageService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService {
    private static final String IMAGE_DIRECTORY = "src/main/resources/static/images";

    public Resource getImage(Long id) {
        try {
            var image = id.toString() + ".jpg";
            var imagePath = Paths.get(IMAGE_DIRECTORY).resolve(image);
            var resource = new UrlResource(imagePath.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new RuntimeException("Could not read the image!");

        }

    }
}
