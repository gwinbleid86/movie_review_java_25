package kg.attractor.movie_review_java_25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movie_images")
public class Image {
    @Id
    private Long id;
    private String fileName;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
