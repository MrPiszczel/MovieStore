package pl.mateusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mateusz.model.Movie;
import pl.mateusz.service.MovieServiceImpl;

@Controller
public class DeleteMovieController {

    @Autowired
    private MovieServiceImpl movieServiceImpl;

    private Movie selectedMovieById;

    @RequestMapping(value="delete/{id}")
    public String deleteMovie(@PathVariable("id") int id, Model model) {

         selectedMovieById = movieServiceImpl.findById(id);

        model.addAttribute("movie", selectedMovieById);

        movieServiceImpl.deleteMovieByName(selectedMovieById);

        return "deleteMovie";

    }
}
