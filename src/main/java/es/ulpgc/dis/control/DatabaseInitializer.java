package es.ulpgc.dis.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    private final String databaseUrl;

    public DatabaseInitializer(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public void initialize() {
        try (Connection connection = DriverManager.getConnection(databaseUrl);
             Statement statement = connection.createStatement()) {

            // Crear tabla movies
            String createTableSQL = """
                    CREATE TABLE IF NOT EXISTS movies (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        title TEXT NOT NULL,
                        year INTEGER NOT NULL,
                        genres TEXT NOT NULL
                    );
                    """;
            statement.execute(createTableSQL);

            // Poblar la tabla con datos iniciales
            String populateTableSQL = """
                    INSERT INTO movies (title, year, genres) VALUES
                    ('The Shawshank Redemption', 1994, 'Drama'),
                    ('The Godfather', 1972, 'Crime,Drama'),
                    ('The Dark Knight', 2008, 'Action,Crime,Drama'),
                    ('Schindler''s List', 1993, 'Biography,Drama,History'),
                    ('Pulp Fiction', 1994, 'Crime,Drama'),
                    ('The Lord of the Rings: The Return of the King', 2003, 'Action,Adventure,Drama'),
                    ('Forrest Gump', 1994, 'Drama,Romance'),
                    ('Inception', 2010, 'Action,Adventure,Sci-Fi'),
                    ('The Matrix', 1999, 'Action,Sci-Fi'),
                    ('Goodfellas', 1990, 'Biography,Crime,Drama');
                    """;
            statement.execute(populateTableSQL);

        } catch (SQLException e) {
            throw new RuntimeException("Error initializing the database", e);
        }
    }
}
