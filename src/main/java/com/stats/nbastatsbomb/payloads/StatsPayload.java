package com.stats.nbastatsbomb.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatsPayload {

    private int id;
    private String player_name;
    private String team;
    private int games_played;
    private double points;
    private double rebounds;
    private double assists;
    private double net_rating;
    private double offensive_rebound_pct;
    private double defensive_rebound_pct;
    //percentage of team plays used by the player while was on the floor( (FGA+ Possession Ending FTA + TO) / POSS)
    private double usg_pct;
    //Measure of the player's shooting efficiency that takes into account free throws, 2 and 3 point shots (PTS / (2*(FGA + 0.44 * FTA)))
    private double ts_pct;
    //Percentage of teammate field goals the player assisted while he was on the floor
    private double ast_pct;
    private String season;
}
