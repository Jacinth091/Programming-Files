package dev.Jacinth.Movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepos extends MongoRepository<Review, ObjectId> {
}
