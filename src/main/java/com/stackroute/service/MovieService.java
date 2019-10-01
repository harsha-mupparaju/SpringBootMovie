package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;

import java.util.List;

public interface MovieService {

     public Movie saveMovie(Movie movie);
     public List<Movie> getAllMovies();
     public boolean deleteMovie(int movieId);
 /*    public Movie getMovieById(int movieId);*/
     public Movie updateMovie(Movie movie);
}
