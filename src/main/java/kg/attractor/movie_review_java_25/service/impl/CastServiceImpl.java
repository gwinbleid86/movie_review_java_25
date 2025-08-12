package kg.attractor.movie_review_java_25.service.impl;

import kg.attractor.movie_review_java_25.dto.CastMemberDto;
import kg.attractor.movie_review_java_25.exceptions.CastNotFoundException;
import kg.attractor.movie_review_java_25.exceptions.MovieNotFoundException;
import kg.attractor.movie_review_java_25.exceptions.RoleNotFoundException;
import kg.attractor.movie_review_java_25.model.Cast;
import kg.attractor.movie_review_java_25.model.Movie;
import kg.attractor.movie_review_java_25.model.MovieCastMember;
import kg.attractor.movie_review_java_25.repository.CastRepository;
import kg.attractor.movie_review_java_25.repository.MovieCastMemberRepository;
import kg.attractor.movie_review_java_25.repository.MovieRepository;
import kg.attractor.movie_review_java_25.service.CastService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CastServiceImpl implements CastService {
    private final CastRepository castRepository;
    private final MovieCastMemberRepository mcmRepository;
    private final MovieRepository movieRepository;

    @Override
    public CastMemberDto getCastMember(long castId, long movieId) {
        Cast cast = castRepository.findById(castId)
                .orElseThrow(CastNotFoundException::new);
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(MovieNotFoundException::new);

        String role = mcmRepository.findById(new MovieCastMember.MovieCastMemberCompositeId(movie, cast))
                .orElseThrow(RoleNotFoundException::new).getRole();

        return CastMemberDto.builder()
                .id(cast.getId())
                .fullName(cast.getFullName())
                .role(role)
                .build();
    }
}
