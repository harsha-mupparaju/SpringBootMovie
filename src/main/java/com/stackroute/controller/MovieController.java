package com.stackroute.controller;


import com.stackroute.domain.Movie;
import com.stackroute.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/api")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
        ResponseEntity responseEntity;
        try {
            movieService.saveMovie(movie);
            responseEntity = new ResponseEntity("Succesfully Created", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("movie")
    public ResponseEntity<?> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }


    @DeleteMapping("movie")
    public ResponseEntity<?> deleteMovie(@RequestBody int movieId){
          ResponseEntity responseEntity;
          try{
              movieService.deleteMovie(movieId);
              return new ResponseEntity("Succesfully deleted", HttpStatus.OK);
          }catch(Exception ex){
              return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
          }
    }

    @PutMapping("movie")
    public ResponseEntity<?> updateMovie(Movie movie){
        ResponseEntity responseEntity;
            movieService.updateMovie(movie);
            return new ResponseEntity("Succesfully updated",HttpStatus.OK);
        }
    }

