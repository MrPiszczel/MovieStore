package pl.mateusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mateusz.model.Movie;
import pl.mateusz.repository.MovieRepository;
import pl.mateusz.service.MovieServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EditMovieController {

    @Autowired
    private MovieServiceImpl movieServiceImpl;

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value="edit/{id}", method = RequestMethod.GET)
    public String editMovie(@PathVariable("id") int id, Model model){

        Movie selectedMovieById= movieServiceImpl.findById(id);

        model.addAttribute("movie", selectedMovieById);
        return "editMovie";
    }

    @RequestMapping(value="edit/update")
    public String editUpdate(HttpServletRequest request, Model model){

        String newRate = request.getParameter("newRate");
        int parseNewRate = Integer.parseInt(newRate);
        String name = request.getParameter("name");
        String newStatus = request.getParameter("newStatus");


       Movie movie =  movieServiceImpl.findByName(name);
       movie.setRate(parseNewRate);
       movie.setName(name);
       movie.setStatus(newStatus);
       movieRepository.save(movie);

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
}
