package es.ulpgc.dis.control;

import es.ulpgc.dis.model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteMovieLoader implements MovieLoader {

    private final String databaseUrl;

    public SQLiteMovieLoader(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    @Override
    public List<Movie> loadMovies() {
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT title, year, genres FROM movies";

        try (Connection connection = DriverManager.getConnection(databaseUrl);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                int year = resultSet.getInt("year");
                String[] genres = resultSet.getString("genres").split(",");

                movies.add(new Movie(title, year, genres));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error loading movies from SQLite", e);
        }

        return movies;
    }
}
