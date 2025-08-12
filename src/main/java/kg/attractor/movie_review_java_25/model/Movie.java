package kg.attractor.movie_review_java_25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    private int id;

    private String name;
    private int releaseYear;
    private String description;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    @OneToMany
    @JoinColumn(name = "movie_id")
    private List<Image> images;

    @OneToMany
    @JoinColumn(name = "movie_id")
    private Collection<MovieCastMember> movieCastMemberList = new HashSet<>();
}
