package com.stats.nbastatsbomb.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamStatsThirdPartyPayload {

    private int games;
    private int fast;
    private int pointsInPaint;
    private int biggestLead;
    private int secondChancePoints;
    private int pointsOffTurnovers;
    private int longestRun;
    private int points;
    private int fgm;
    private int fga;
    private String fgp;
    private int ftm;
    private int fta;
    private String ftp;
    private int tpm;
    private int tpa;
    private String tpp;
    private int offReb;
    private int defReb;
    private int totReb;
    private int assists;
    private int pFouls;
    private int steals;
    private int turnovers;
    private int blocks;
    private int plusMinus;
}
