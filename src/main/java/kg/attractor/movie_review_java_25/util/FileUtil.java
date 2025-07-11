package kg.attractor.movie_review_java_25.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import kg.attractor.movie_review_java_25.model.Movie;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@Service
public class FileUtil {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    ;

//    @Autowired
//    public FileUtil() {
//        gson = new GsonBuilder().setPrettyPrinting().create();
//    }

    public List<Movie> getMovies() {
        Type listType = new TypeToken<Map<String, List<Movie>>>() {
        }.getType();
        try (Reader reader = new FileReader("data/movies.json")) {
            Map<String, List<Movie>> movies = gson.fromJson(reader, listType);
            return movies.get("movies");

        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
