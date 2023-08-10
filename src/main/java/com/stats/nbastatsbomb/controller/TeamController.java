package com.stats.nbastatsbomb.controller;

import com.stats.nbastatsbomb.inputs.team.CreateTeamInput;
import com.stats.nbastatsbomb.payloads.TeamPayload;
import com.stats.nbastatsbomb.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/createTeam")
    public ResponseEntity<TeamPayload> createTeam(@RequestBody CreateTeamInput createTeamInput){
        return ResponseEntity.ok(teamService.createTeam(createTeamInput));
    }

}