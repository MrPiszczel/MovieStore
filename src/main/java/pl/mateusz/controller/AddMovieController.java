package pl.mateusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mateusz.model.Movie;
import pl.mateusz.service.MovieServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AddMovieController {

    @Autowired
    private MovieServiceImpl movieServiceImpl;

    @PostMapping("/saveMovie")
    public String handlePostRequest(@Valid Movie movie, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "addMovie";
        }
        return "index";
    }

    @GetMapping(value="/saveMovie")
    public String addMovie(Model model, HttpServletRequest request, Movie movie){

       String name = request.getParameter("name");
       String rate =  request.getParameter("rate");
       String status = request.getParameter("status");

       int rateInt = Integer.parseInt(rate);
       movieServiceImpl.save(name, rateInt, status);

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

//    @PostMapping("/")
////    public String checkAddMovie(@Valid Movie movie, BindingResult bindingResult){
////        if(bindingResult.hasErrors()){
////            return "index";
////        }
////        return "redirect:/completeAdd";
////    }

}
