package com.stats.nbastatsbomb.controller;

import com.stats.nbastatsbomb.entities.mongoentities.TeamMongo;
import com.stats.nbastatsbomb.inputs.team.GetTeamInfoInput;
import com.stats.nbastatsbomb.payloads.TeamStatsThirdPartyPayload;
import com.stats.nbastatsbomb.inputs.team.CreateTeamInput;
import com.stats.nbastatsbomb.payloads.TeamPayload;
import com.stats.nbastatsbomb.services.TeamService;
import com.stats.nbastatsbomb.services.TeamStatsService;
import com.stats.nbastatsbomb.services.mongoservices.TeamMongoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;
    private final TeamStatsService teamStatsService;
    private final TeamMongoService teamMongoService;

    @PostMapping("/createTeam")
    public ResponseEntity<TeamPayload> createTeam(@RequestBody CreateTeamInput createTeamInput){
        return ResponseEntity.ok(teamService.createTeam(createTeamInput));
    }

    @PostMapping("/getTeamStatsBySeason")
    public TeamStatsThirdPartyPayload getTeamStatsBySeason(@RequestParam String teamName, @RequestParam int season) throws IOException, InterruptedException {
        return teamStatsService.getTeamStats(teamName, season);
    }

    @PostMapping("/getTeamInfo")
    public TeamMongo getTeamInfo(@RequestBody GetTeamInfoInput getTeamInfoInput){
        return teamMongoService.getTeamInfo(getTeamInfoInput);
    }
}