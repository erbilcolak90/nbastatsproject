package com.stats.nbastatsbomb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stats")
public class Stats {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "player_name")
    private String player_name;
    @Column(name = "team_abbreviation")
    private String team_abbreviation;
    @Column(name = "age")
    private int age;
    @Column(name = "player_height")
    private double player_height;
    @Column(name = "player_weight")
    private double player_weight;
    @Column(name = "college")
    private String college;
    @Column(name = "country")
    private String country;
    @Column(name = "draft_year")
    private String draft_year;
    @Column(name = "draft_round")
    private String draft_round;
    @Column(name = "draft_number")
    private String draft_number;
    @Column(name = "gp")
    private int games_played;
    @Column(name = "pts")
    private double points;
    @Column(name = "reb")
    private double rebounds;
    @Column(name = "ast")
    private double assists;
    @Column(name = "net_rating")
    private double net_rating;
    @Column(name = "oreb_pct")
    private double offensive_rebound_pct;
    @Column(name = "dreb_pct")
    private double defensive_rebound_pct;
    //percentage of team plays used by the player while was on the floor( (FGA+ Possession Ending FTA + TO) / POSS)
    @Column(name = "usg_pct")
    private double usg_pct;
    //Measure of the player's shooting efficiency that takes into account free throws, 2 and 3 point shots (PTS / (2*(FGA + 0.44 * FTA)))
    @Column(name = "ts_pct")
    private double ts_pct;
    //Percentage of teammate field goals the player assisted while he was on the floor
    @Column(name = "ast_pct")
    private double ast_pct;
    @Column(name = "season")
    private String season;
}
