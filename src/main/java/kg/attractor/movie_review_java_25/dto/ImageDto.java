package kg.attractor.movie_review_java_25.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class ImageDto {
    private MultipartFile file;
    private long movieId;
}
