package com.stats.nbastatsbomb.controller;

import com.stats.nbastatsbomb.entities.mongoentities.PlayerMongo;
import com.stats.nbastatsbomb.services.mongoservices.PlayerMongoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playerMongo")
@RequiredArgsConstructor
public class PlayerMongoController {

    private final PlayerMongoService playerMongoService;

    @PostMapping("/createPlayer")
    public PlayerMongo createPlayer(@RequestParam String playerName){
        return playerMongoService.createPlayer(playerName);
    }

    @GetMapping("/getAllPlayers")
    public List<PlayerMongo> getAllPlayers(){
        return playerMongoService.getAllPlayers();
    }
}
