package es.ulpgc.dis.control;

import es.ulpgc.dis.model.Histogram;
import es.ulpgc.dis.model.Movie;

import java.util.List;
import java.util.Map;

public class HistogramTsvGenerator implements Histogram {

    private final List<Movie> movies;
    private final GenreFrequencyProcessor processor;

    public HistogramTsvGenerator(List<Movie> movies) {
        this.movies = movies;
        this.processor = new GenreFrequencyProcessor();
    }

    @Override
    public Map<String, Integer> generateHistogram() {
        return processor.process(movies);
    }
}
