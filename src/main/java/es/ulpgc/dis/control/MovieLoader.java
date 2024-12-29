package es.ulpgc.dis.control;

import es.ulpgc.dis.model.Movie;

import java.util.List;

public interface MovieLoader {
    List<Movie> loadMovies();
}
