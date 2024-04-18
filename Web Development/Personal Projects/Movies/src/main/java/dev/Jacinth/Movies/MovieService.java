package dev.Jacinth.Movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepos movieRepos;
    public List<Movie> allMovies(){

        return movieRepos.findAll();

    }

    public Optional<Movie> singleMovies(String imdbId){
        return movieRepos.findMovieByImdbId(imdbId);
    }

}
