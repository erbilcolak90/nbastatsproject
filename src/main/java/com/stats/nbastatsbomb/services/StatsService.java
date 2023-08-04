package com.stats.nbastatsbomb.services;

import com.stats.nbastatsbomb.entities.Player;
import com.stats.nbastatsbomb.entities.Stats;
import com.stats.nbastatsbomb.enums.SortBy;
import com.stats.nbastatsbomb.enums.StatsTableColumns;
import com.stats.nbastatsbomb.inputs.GetAllStatsInput;
import com.stats.nbastatsbomb.inputs.GetPlayerStatsBySeasonInput;
import com.stats.nbastatsbomb.inputs.GetTeamPlayersStatsBySeasonInput;
import com.stats.nbastatsbomb.inputs.GetTeamRosterBySeasonInput;
import com.stats.nbastatsbomb.mapper.MapperService;
import com.stats.nbastatsbomb.payloads.StatsPayload;
import com.stats.nbastatsbomb.payloads.TeamRosterPayload;
import com.stats.nbastatsbomb.repositories.StatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final StatsRepository statsRepository;
    private final MapperService mapperService;

    public List<Stats> findByPlayerName(String playerName) {
        List<Stats> playerStats = statsRepository.findByPlayerName(playerName);

        return playerStats;
    }

    public List<StatsPayload> getPlayerStatsBySeason(GetPlayerStatsBySeasonInput getPlayerStatsBySeasonInput) {

        List<Stats> playerStats = statsRepository.findByPlayerNameAndSeason(getPlayerStatsBySeasonInput.getFull_name(),getPlayerStatsBySeasonInput.getSeason());

        return playerStats.stream().map(mapperService::convertStatsToStatsPayload).toList();
    }

    public List<StatsPayload> getTeamPlayersStatsBySeason(GetTeamPlayersStatsBySeasonInput getTeamPlayersStatsBySeasonInput) {

        List<Stats> teamStats = statsRepository.findByTeamNameAndSeason(getTeamPlayersStatsBySeasonInput.getTeamName(),getTeamPlayersStatsBySeasonInput.getSeason());

        return teamStats.stream().map(mapperService::convertStatsToStatsPayload).toList();
    }

    public TeamRosterPayload getTeamRosterBySeason(GetTeamRosterBySeasonInput getTeamRosterBySeasonInput) {
        List<Stats> players = statsRepository.findByTeamNameAndSeason(getTeamRosterBySeasonInput.getTeam_name(), getTeamRosterBySeasonInput.getSeason());

        List<Player> playerList = players.stream().map(mapperService::convertStatsToPlayer).toList();

        TeamRosterPayload teamRosterPayload = new TeamRosterPayload();
        List<String> teamPlayers = playerList.stream().map(Player::getPlayer_name).toList();
        teamRosterPayload.setPlayerList(teamPlayers);
        return teamRosterPayload;

    }

    public Page<StatsPayload> getAllStats(GetAllStatsInput getAllStatsInput) {

        int page = getAllStatsInput.getPaginationInput().getPage();
        int size = getAllStatsInput.getPaginationInput().getSize();
        StatsTableColumns fieldName = getAllStatsInput.getFieldName();
        String column = fieldName.toString();
        SortBy sortBy = getAllStatsInput.getPaginationInput().getSort();

        Sort.Direction sortDirection = Sort.Direction.fromString(sortBy.toString());
        Sort sort = Sort.by(sortDirection, fieldName.toString());

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Stats> statsPage = statsRepository.findAllByCustomQuery(column,pageable);

        return statsPage.map(mapperService::convertStatsToStatsPayload);
    }
}
