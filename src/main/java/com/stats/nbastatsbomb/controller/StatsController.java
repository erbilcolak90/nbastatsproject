package com.stats.nbastatsbomb.controller;

import com.stats.nbastatsbomb.entities.Stats;
import com.stats.nbastatsbomb.services.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class StatsController {

    private final StatsService statsService;

    @PostMapping("/findByPlayerName")
    public List<Stats> findByPlayerName(@RequestBody String playerName){
        return statsService.findByPlayerName(playerName);
    }
}