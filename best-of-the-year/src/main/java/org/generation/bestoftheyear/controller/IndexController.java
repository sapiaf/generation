package org.generation.bestoftheyear.controller;

import org.generation.bestoftheyear.model.Movie;
import org.generation.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String index(Model model){
        model.addAttribute("name", "Francesco");
        return "index";
    }
    @GetMapping("/movies")
    public String movies(Model model){
        List<Movie> bestMovies = getBestMovies();
        model.addAttribute("bestMovies", bestMovies);
        return "movies";
    }
    @GetMapping("/songs")
    public String songs(Model model){
        List<Song> bestSongs = getBestSongs();
        model.addAttribute("bestSongs", bestSongs);
        return "songs";
    }
    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Talk to Me"));
        return movies;
    }
    private List<Song> getBestSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Butoh baby"));
        return songs;
    }
}


