package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    MovieService movieService=new MovieService();

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie (@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>(movie.getName()+" movie is added to the cinema", HttpStatus.ACCEPTED) ;
    }
    @PostMapping("/add-director")
    public ResponseEntity<String>  addDirector (@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>(director.getName()+" Director is added to the List", HttpStatus.ACCEPTED) ;
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair (@RequestParam String movie,@RequestParam String director){
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>(movie+" added with "+director, HttpStatus.ACCEPTED) ;
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName( @PathVariable String name){
        Movie movie=null;
        movie=movieService.getMovieByName(name);
        return new ResponseEntity<>(movie,HttpStatus.ACCEPTED);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName( @PathVariable String name){
        Director director=null;
        director=movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-movies-by-director-name/{name}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String name){
        List<String >list=movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movieName=movieService.findAllMovies();
        return new ResponseEntity<>(movieName,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<?> deleteDirectorByName(@RequestParam String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>(null,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<?> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>(null,HttpStatus.ACCEPTED);
    }
}