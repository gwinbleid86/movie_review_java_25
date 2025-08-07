package kg.attractor.movie_review_java_25.service.impl;

import kg.attractor.movie_review_java_25.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

    @Override
    public Map<String, Object> getIndex() {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "Hello World");
        return result;
    }
}
