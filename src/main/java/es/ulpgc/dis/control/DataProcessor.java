package es.ulpgc.dis.control;

import es.ulpgc.dis.model.Movie;

import java.util.List;
import java.util.Map;

public interface DataProcessor {
    Map<String, Integer> process(List<Movie> movies);
}
