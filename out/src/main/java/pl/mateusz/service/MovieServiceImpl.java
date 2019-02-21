package pl.mateusz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mateusz.model.Movie;
import pl.mateusz.repository.MovieRepository;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;


    public void save(String name, int rate, String status) {
        Movie movie = new Movie();
        movie.setName(name);
        movie.setRate(rate);
        movie.setStatus(status);

        movieRepository.save(movie);
    }

    @Override
    public void save2(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAllMovies() {
       List<Movie> allMovies = movieRepository.findAllMovies();

        return allMovies;
    }

    @Override
    public Movie findById(int id) {
       List<Movie> allMovie = movieRepository.findAllMovies();

       for(Movie selectMovie: allMovie){
           if(selectMovie.getId() == id )
               return selectMovie;
       }
        return null;
    }

    @Override
    public Movie findByName(String name) {
        List<Movie> allMovie = movieRepository.findAllMovies();

        for(Movie selectMovie: allMovie){
            if(selectMovie.getName().equals(name))
                return selectMovie;
        }
        return null;
    }


}
