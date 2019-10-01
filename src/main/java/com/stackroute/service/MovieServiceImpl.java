package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;


  @Autowired
    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }
    @Override
    public Movie saveMovie(Movie movie) {
        Movie savedMovie=movieRepository.save(movie);
        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }


    @Override
    public boolean deleteMovie(int movieId){
      if(movieRepository.existsById(movieId)){
       movieRepository.deleteById(movieId);
       return true;}
      return false;
    }

/*
    @Override
    public Movie getMovieById(int movieId) {
   */
/*   if(movieRepository.existsById(movieId)){
         Movie movie=new Movie();*//*

        Optional<Movie> movie1 = movieRepository.findById(movieId);
        Movie movie=new Movie();
        if (movie1.isPresent()) {
            movie = movie1.get();
        }
         else{
             return null;}
         return movie;
    }
*/


    @Override
    public Movie updateMovie(Movie movie) {
        Movie movie1=new Movie();
        if(movieRepository.existsById(movie.getId())){
             movie1=movieRepository.save(movie);
      }
        return movie1;
    }
}
