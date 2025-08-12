package kg.attractor.movie_review_java_25.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "director")
public class Director {
    @Id
    private Long id;

    @Column(name = "fullname")
    private String fullName;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies;
}
