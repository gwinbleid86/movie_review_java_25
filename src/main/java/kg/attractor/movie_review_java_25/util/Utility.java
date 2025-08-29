package kg.attractor.movie_review_java_25.util;

import jakarta.servlet.http.HttpServletRequest;

public class Utility {
    private Utility() {
    }

    public static String makeSiteUrl(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        return url.replace(request.getServletPath(), "");
    }
}
