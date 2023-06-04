package com.driver;

import org.springframework.http.ResponseEntity;

import java.util.List;

public class MovieService {

    MovieRepository movieRepository=new MovieRepository();
    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movie, String director) {
        movieRepository.addMovieDirectorPair(movie,director);
    }

    public Movie getMovieByName(String name) {

        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {

        return movieRepository.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String name)
    {
        return movieRepository.getMoviesByDirectorName(name);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorByName(String name) {
        movieRepository.deleteDirectorByName(name);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }
}