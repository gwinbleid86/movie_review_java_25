package kg.attractor.movie_review_java_25.service.impl;

import kg.attractor.movie_review_java_25.dto.CastMemberDto;
import kg.attractor.movie_review_java_25.exceptions.CastNotFoundException;
import kg.attractor.movie_review_java_25.model.Cast;
import kg.attractor.movie_review_java_25.repository.CastRepository;
import kg.attractor.movie_review_java_25.service.CastService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CastServiceImpl implements CastService {
    private final CastRepository castRepository;

    @Override
    public CastMemberDto getCastMember(long castId, long movieId) {
        Cast cast = castRepository.findById(castId)
                .orElseThrow(CastNotFoundException::new);

        return CastMemberDto.builder()
                .id(cast.getId())
                .fullName(cast.getFullName())
                .role(castRepository.findRoleByCast(movieId, castId))
                .build();
    }
}
