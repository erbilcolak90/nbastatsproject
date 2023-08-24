package com.stats.nbastatsbomb.services.mongoservices;

import com.stats.nbastatsbomb.entities.mongoentities.PlayerMongo;
import com.stats.nbastatsbomb.repositories.mongo.PlayerMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerMongoService {

    private final PlayerMongoRepository playerMongoRepository;

    public PlayerMongo createPlayer(String playerName){
        try{
            PlayerMongo playerMongo = new PlayerMongo();
            playerMongo.setPlayerName(playerName);
            playerMongoRepository.save(playerMongo);
            return playerMongo;
        }catch (Exception ex){
            throw ex;
        }
    }

    public List<PlayerMongo> getAllPlayers(){
        List<PlayerMongo> playerMongoList = playerMongoRepository.findAll();

        return playerMongoList;
    }
}
