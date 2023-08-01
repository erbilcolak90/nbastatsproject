package com.stats.nbastatsbomb.services;

import com.stats.nbastatsbomb.entities.Stats;
import com.stats.nbastatsbomb.repositories.StatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final StatsRepository statsRepository;

    public List<Stats> findByPlayerName(String playerName) {
        List<Stats> playerStats = statsRepository.findByPlayerName(playerName);

        return playerStats;
    }
}
