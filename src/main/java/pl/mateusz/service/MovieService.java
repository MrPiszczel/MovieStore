package pl.mateusz.service;

import pl.mateusz.model.Movie;

import java.util.List;

public interface MovieService {

    void save(String name, int rate, String status);

    void save2(Movie movie);

    List<Movie> findAllMovies();

    Movie findById(int id);

    Movie findByName(String name);

    void deleteMovieByName(Movie movie);
}
