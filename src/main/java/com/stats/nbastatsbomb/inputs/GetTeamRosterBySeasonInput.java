package com.stats.nbastatsbomb.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTeamRosterBySeasonInput {

    private String team_name;
    private String season;
}
