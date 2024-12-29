package es.ulpgc.dis.control;

import es.ulpgc.dis.model.Movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenreFrequencyProcessor implements DataProcessor {

    @Override
    public Map<String, Integer> process(List<Movie> movies) {
        Map<String, Integer> frequencies = new HashMap<>();
        for (Movie movie : movies) {
            for (String genre : movie.genres()) {
                frequencies.put(genre, frequencies.getOrDefault(genre, 0) + 1);
            }
        }
        return frequencies;
    }
}
