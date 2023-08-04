package com.stats.nbastatsbomb.controller;

import com.stats.nbastatsbomb.entities.Player;
import com.stats.nbastatsbomb.entities.Stats;
import com.stats.nbastatsbomb.inputs.GetAllStatsInput;
import com.stats.nbastatsbomb.inputs.GetPlayerStatsBySeasonInput;
import com.stats.nbastatsbomb.inputs.GetTeamPlayersStatsBySeasonInput;
import com.stats.nbastatsbomb.inputs.GetTeamRosterBySeasonInput;
import com.stats.nbastatsbomb.payloads.StatsPayload;
import com.stats.nbastatsbomb.payloads.TeamRosterPayload;
import com.stats.nbastatsbomb.services.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/getPlayerStatsBySeason")
    public List<StatsPayload> getPlayerStatsBySeason(@RequestBody GetPlayerStatsBySeasonInput getPlayerStatsBySeasonInput){
        return statsService.getPlayerStatsBySeason(getPlayerStatsBySeasonInput);
    }

    @PostMapping("/getTeamPlayersStatsBySeason")
    public ResponseEntity<List<StatsPayload>> getTeamPlayersStatsBySeason(@RequestBody GetTeamPlayersStatsBySeasonInput getTeamPlayersStatsBySeasonInput){
        return ResponseEntity.ok(statsService.getTeamPlayersStatsBySeason(getTeamPlayersStatsBySeasonInput));
    }

    @PostMapping("/getTeamRosterBySeason")
    public ResponseEntity<TeamRosterPayload> getTeamRosterBySeason(@RequestBody GetTeamRosterBySeasonInput getTeamRosterBySeasonInput){
        return ResponseEntity.ok(statsService.getTeamRosterBySeason(getTeamRosterBySeasonInput));
    }

    @PostMapping("/getAllStats")
    public ResponseEntity<Page<StatsPayload>> getAllStats(@RequestBody GetAllStatsInput getAllStatsInput){
        return ResponseEntity.ok(statsService.getAllStats(getAllStatsInput));
    }

}