package pl.mateusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mateusz.model.Movie;
import pl.mateusz.service.MovieServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private MovieServiceImpl movieServiceImpl;

    @RequestMapping(value="/")
    public String index(Model model){

        List<Movie> allMovie = movieServiceImpl.findAllMovies();

        List<Movie> planToWatchMovie = new ArrayList<>();

        List<Movie> watchingMovie = new ArrayList<>();

        List<Movie> droppedMovie = new ArrayList<>();

        List<Movie> watchedMovie = new ArrayList<>();


        for(Movie checkMovie: allMovie){
            if(checkMovie.getStatus().equals("PlanToWatch")){
                planToWatchMovie.add(checkMovie);
            }else if(checkMovie.getStatus().equals("Watching")){
                watchingMovie.add(checkMovie);
            }else if(checkMovie.getStatus().equals("Dropped")){
                droppedMovie.add(checkMovie);
            }else if(checkMovie.getStatus().equals("Watched")){
                watchedMovie.add(checkMovie);
            }
        }

        model.addAttribute("planToWatchMovie", planToWatchMovie);
        model.addAttribute("watchingMovie", watchingMovie);
        model.addAttribute("droppedMovie", droppedMovie);
        model.addAttribute("watchedMovie", watchedMovie);

        return "index";
    }

    @RequestMapping(value="addMovie")
    public String addMovie(){
        return "addMovie";
    }
}
