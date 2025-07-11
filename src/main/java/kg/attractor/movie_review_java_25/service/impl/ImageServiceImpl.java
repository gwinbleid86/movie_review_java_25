package kg.attractor.movie_review_java_25.service.impl;

import kg.attractor.movie_review_java_25.dto.ImageDto;
import kg.attractor.movie_review_java_25.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @Override
    public ResponseEntity<?> getById(String filename) {
        return downloadFile(filename, "images", MediaType.IMAGE_JPEG);
    }

    @Override
    public void create(ImageDto imageDto) {
        String filename = saveUploadedFile(imageDto.getFile(), "images");
        System.out.println(filename);
    }
}
