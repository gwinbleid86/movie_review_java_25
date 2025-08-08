package kg.attractor.movie_review_java_25.exceptions;

import java.util.NoSuchElementException;

public class NotFoundException extends NoSuchElementException {
    public NotFoundException(String prefix) {
        super(prefix + " not found");
    }
}
