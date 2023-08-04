package com.stats.nbastatsbomb.mapper;

import com.stats.nbastatsbomb.entities.Player;
import com.stats.nbastatsbomb.entities.Stats;
import com.stats.nbastatsbomb.payloads.StatsPayload;
import com.stats.nbastatsbomb.payloads.TeamRosterPayload;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperService {

    private final ModelMapper modelMapper = new ModelMapper();

    public StatsPayload convertStatsToStatsPayload(Stats stats){
        return modelMapper.map(stats, StatsPayload.class);
    }

    public Player convertStatsToPlayer(Stats stats){
        return modelMapper.map(stats, Player.class);
    }

    public TeamRosterPayload convertPlayerToTeamRosterPayload(Player player){
        return modelMapper.map(player, TeamRosterPayload.class);
    }
}
