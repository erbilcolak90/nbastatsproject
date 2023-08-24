package com.stats.nbastatsbomb.inputs.team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTeamInfoInput {

    private String teamName;
    private String shortName;
}
