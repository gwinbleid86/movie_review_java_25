package kg.attractor.movie_review_java_25.controller;

import kg.attractor.movie_review_java_25.dto.ImageDto;
import kg.attractor.movie_review_java_25.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping // images/1
    public ResponseEntity<?> getImage(@RequestParam(name = "filename") String filename) {
        return imageService.getById(filename);
    }

    @PostMapping
    public HttpStatus create(ImageDto imageDto) {
        imageService.create(imageDto);
        return HttpStatus.CREATED;
    }
}
