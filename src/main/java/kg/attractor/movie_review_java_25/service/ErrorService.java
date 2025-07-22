package kg.attractor.movie_review_java_25.service;

import kg.attractor.movie_review_java_25.exceptions.ErrorResponseBody;
import org.springframework.validation.BindingResult;

public interface ErrorService {
    ErrorResponseBody makeResponse(BindingResult bindingResult);

    ErrorResponseBody makeResponse(Exception e);
}
