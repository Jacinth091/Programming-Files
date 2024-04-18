package dev.Jacinth.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepos movieRepos;
    public List<Movie> allMovies(){

        return movieRepos.findAll();

    }

}
