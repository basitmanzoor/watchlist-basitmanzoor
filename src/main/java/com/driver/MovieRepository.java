package com.driver;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class MovieRepository {

    private List<Movie> movieList=new ArrayList<>();
    private   List<Director> directorList=new ArrayList<>();

    private HashMap<Director,List<Movie>> movieDirectorPair= new HashMap<>();

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public void addDirector(Director director) {
        directorList.add(director);
    }

    public void addMovieDirectorPair(String movie, String director) {
        Director director1=getDirectorByName(director);
        Movie movie1=getMovieByName(movie);

        List<Movie>tempList=movieDirectorPair.getOrDefault(director1,new ArrayList<Movie>());
        tempList.add(movie1);
        movieDirectorPair.put(director1,tempList);
    }

    public Movie getMovieByName(String name) {
        for(Movie movie:movieList){
            if(movie.getName().equals(name)) return movie;
        }
        return null;
    }

    public Director getDirectorByName(String name) {
        for(Director director:directorList){
            if(director.getName().equals(name)) return director;
        }
        return null;
    }

    public List<String> getMoviesByDirectorName(String name) {
        Director director=getDirectorByName(name);
        List<String> movieName=new ArrayList<>();
        List<Movie> list=movieDirectorPair.getOrDefault(director,new ArrayList<>());
        for(Movie movie:list){
            movieName.add(movie.getName());
        }
        return movieName;
    }

    public List<String> findAllMovies() {
        List<String> movieName=new ArrayList<>();
        for(Movie movie:movieList){
            movieName.add(movie.getName());
        }
        return movieName;
    }

    public void deleteDirectorByName(String name) {
        Director director=getDirectorByName(name);
        List<Movie> deletedMovie=movieDirectorPair.get(director);

        for(Movie movie:deletedMovie){
            movieList.remove(movie);
        }
        movieDirectorPair.remove(director);
        directorList.remove(director);
    }

    public void deleteAllDirectors() {
        for (Director director:directorList) {
            List<Movie> deletedMovie=movieDirectorPair.get(director);

            for(Movie movie:deletedMovie){
                movieList.remove(movie);
            }
            movieDirectorPair.remove(director);
        }
        directorList.clear();

    }
}