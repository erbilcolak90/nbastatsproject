package com.stats.nbastatsbomb.repositories.mongo;

import com.stats.nbastatsbomb.entities.mongoentities.PlayerMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerMongoRepository extends MongoRepository<PlayerMongo, String> {
}
