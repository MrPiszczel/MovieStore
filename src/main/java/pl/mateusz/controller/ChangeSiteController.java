package pl.mateusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mateusz.model.Movie;
import pl.mateusz.service.MovieServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChangeSiteController {

    @Autowired
    private MovieServiceImpl movieServiceImpl;

    @RequestMapping(value = "/watchingMovie")
    public String watchingMovie(Model model) {

        List<Movie> allMovie = movieServiceImpl.findAllMovies();

        List<Movie> watchingMovie = new ArrayList<>();

        for(Movie checkMovie: allMovie){
            if(checkMovie.getStatus().equals("Watching")) {
                watchingMovie.add(checkMovie);
            }
        }
        model.addAttribute("watchingMovie", watchingMovie);

        return "watchingMovie";
    }

    @RequestMapping(value="/watchedMovie")
    public String watchedMovie(Model model){

        List<Movie> allMovie = movieServiceImpl.findAllMovies();

        List<Movie> watchedMovie = new ArrayList<>();

        for(Movie checkMovie: allMovie){
            if(checkMovie.getStatus().equals("Watched")) {
                watchedMovie.add(checkMovie);
            }
        }
        model.addAttribute("watchedMovie", watchedMovie);

        return "watchedMovie";
    }


}
