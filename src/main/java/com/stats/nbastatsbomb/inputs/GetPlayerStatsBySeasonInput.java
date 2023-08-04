package com.stats.nbastatsbomb.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPlayerStatsBySeasonInput {

    private String full_name;
    private String season;
}
