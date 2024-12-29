package es.ulpgc.dis;

import es.ulpgc.dis.control.DatabaseInitializer;
import es.ulpgc.dis.control.SQLiteMovieLoader;
import es.ulpgc.dis.model.Movie;
import es.ulpgc.dis.view.MainFrame;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String databaseUrl = "jdbc:sqlite:movies.db";

        DatabaseInitializer initializer = new DatabaseInitializer(databaseUrl);
        initializer.initialize();

        SQLiteMovieLoader movieLoader = new SQLiteMovieLoader(databaseUrl);
        List<Movie> movies = movieLoader.loadMovies();

        MainFrame frame = new MainFrame(movies);
    }
}
