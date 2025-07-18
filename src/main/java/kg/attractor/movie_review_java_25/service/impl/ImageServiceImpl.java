package kg.attractor.movie_review_java_25.service.impl;

import kg.attractor.movie_review_java_25.dao.ImageDao;
import kg.attractor.movie_review_java_25.dao.MovieDao;
import kg.attractor.movie_review_java_25.dto.ImageDto;
import kg.attractor.movie_review_java_25.exceptions.ImageNotFoundException;
import kg.attractor.movie_review_java_25.exceptions.MovieNotFoundException;
import kg.attractor.movie_review_java_25.model.Image;
import kg.attractor.movie_review_java_25.model.Movie;
import kg.attractor.movie_review_java_25.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageDao imageDao;
    private final MovieDao movieDao;

    @Override
    public ResponseEntity<?> getByMovieId(long movieId) {
        Movie movie = movieDao.getMovieById(movieId)
                .orElseThrow(() -> {
                    log.error("No movie found for id: " + movieId);
                    throw new MovieNotFoundException();
                });
        Image image = imageDao.findByMovieId(movie.getId())
                .orElseThrow(ImageNotFoundException::new);
        return downloadFile(image.getFileName(), "images", MediaType.IMAGE_JPEG);
    }

    @Override
    public void create(ImageDto imageDto) {
        String filename = saveUploadedFile(imageDto.getFile(), "images");
        imageDao.save(filename, imageDto.getMovieId());
    }
}
