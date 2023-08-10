package com.stats.nbastatsbomb.services;

import com.stats.nbastatsbomb.entities.Team;
import com.stats.nbastatsbomb.inputs.team.CreateTeamInput;
import com.stats.nbastatsbomb.mapper.MapperService;
import com.stats.nbastatsbomb.payloads.TeamPayload;
import com.stats.nbastatsbomb.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final MapperService mapperService;

    @Transactional
    public TeamPayload createTeam(CreateTeamInput createTeamInput) {
        Team dbTeam = teamRepository.findByTeamName(createTeamInput.getName().toString()).orElse(null);

        if (dbTeam == null) {
            Team newTeam = new Team();
            newTeam.setTeamName(createTeamInput.getName());
            teamRepository.save(newTeam);
            return mapperService.convertTeamToTeamPayload(newTeam);
        } else {
            throw new RuntimeException("Team is already exist");
        }
    }

}
