package dev.Jacinth.Movies;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepos extends MongoRepository<Movie, Object> {

    Optional<Movie> findMovieByImdbId(String imdbId);
}
