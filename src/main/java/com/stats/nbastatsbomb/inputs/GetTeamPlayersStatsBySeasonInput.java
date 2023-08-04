package com.stats.nbastatsbomb.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTeamPlayersStatsBySeasonInput {

    private String teamName;
    private String season;
}
