package kg.attractor.movie_review_java_25.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String prefix) {
        super(prefix + " not found");
    }
}
