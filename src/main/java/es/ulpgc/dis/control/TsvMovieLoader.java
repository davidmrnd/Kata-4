package es.ulpgc.dis.control;

import es.ulpgc.dis.model.Movie;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class TsvMovieLoader implements MovieLoader {

    private final File file;

    public TsvMovieLoader(File file) {
        this.file = file;
    }

    @Override
    public List<Movie> loadMovies() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            return load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Movie> load(BufferedReader reader) throws IOException {
        return reader.lines()
                .skip(1)
                .map(this::toMovie)
                .collect(Collectors.toList());
    }

    private Movie toMovie(String line) {
        String[] parts = line.split("\t");
        return toMovie(parts);
    }

    private Movie toMovie(String[] split) {
        return new Movie(
                split[2],
                parseInt(split[5]),
                split[8].split(",")
        );
    }
}
