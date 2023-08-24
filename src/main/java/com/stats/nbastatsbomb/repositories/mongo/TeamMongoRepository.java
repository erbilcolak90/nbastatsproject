package com.stats.nbastatsbomb.repositories.mongo;

import com.stats.nbastatsbomb.entities.mongoentities.TeamMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeamMongoRepository extends MongoRepository<TeamMongo, Integer> {

    Optional<TeamMongo> findByName(String teamName);
}
