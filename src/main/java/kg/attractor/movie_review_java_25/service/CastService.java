package kg.attractor.movie_review_java_25.service;

import kg.attractor.movie_review_java_25.dto.CastMemberDto;

public interface CastService {
    CastMemberDto getCastMember(long castId, long movieId);
}
