package dev.Jacinth.Movies;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepos extends MongoRepository<Movie, Object> {
}
