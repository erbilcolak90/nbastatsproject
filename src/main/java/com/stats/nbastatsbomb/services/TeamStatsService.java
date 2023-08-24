package com.stats.nbastatsbomb.services;

import com.google.gson.*;
import com.stats.nbastatsbomb.payloads.TeamStatsThirdPartyPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.net.http.HttpClient;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@RequiredArgsConstructor
public class TeamStatsService {

    @Value("${rapidApi.url}")
    private String url;

    private String teamStats = "teams/statistics?";

    @Value("${rapidApi.apiKey}")
    private String apiKey;

    public TeamStatsThirdPartyPayload getTeamStats(String teamName, int season) throws IOException, InterruptedException {
        /*
        this api offers limited requests.
        If you have a membership other than the free version,
        the method for accessing team information and other information can be arranged according to your request.
        this method contains just Atlanta hawks info's.
         */
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url + teamStats + "id=1" + "&season=" + season))
                    .header("X-RapidAPI-Key", apiKey)
                    .header("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String responseBody = response.body();
                JsonElement jsonElement = JsonParser.parseString(responseBody);
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                if (jsonObject.has("response")) {
                    JsonArray responseArray = jsonObject.getAsJsonArray("response");
                    JsonObject teamStatsObject = responseArray.get(0).getAsJsonObject();
                    TeamStatsThirdPartyPayload teamStatsThirdPartyPayload = new TeamStatsThirdPartyPayload();

                    teamStatsThirdPartyPayload.setGames(teamStatsObject.get("games").getAsInt());
                    teamStatsThirdPartyPayload.setFast(teamStatsObject.get("fastBreakPoints").getAsInt());
                    teamStatsThirdPartyPayload.setPointsInPaint(teamStatsObject.get("pointsInPaint").getAsInt());
                    teamStatsThirdPartyPayload.setBiggestLead(teamStatsObject.get("biggestLead").getAsInt());
                    teamStatsThirdPartyPayload.setSecondChancePoints(teamStatsObject.get("secondChancePoints").getAsInt());
                    teamStatsThirdPartyPayload.setPointsOffTurnovers(teamStatsObject.get("pointsOffTurnovers").getAsInt());
                    teamStatsThirdPartyPayload.setLongestRun(teamStatsObject.get("longestRun").getAsInt());
                    teamStatsThirdPartyPayload.setPoints(teamStatsObject.get("points").getAsInt());
                    teamStatsThirdPartyPayload.setFgm(teamStatsObject.get("fgm").getAsInt());
                    teamStatsThirdPartyPayload.setFga(teamStatsObject.get("fga").getAsInt());
                    teamStatsThirdPartyPayload.setFgp(teamStatsObject.get("fgp").getAsString());
                    teamStatsThirdPartyPayload.setFtm(teamStatsObject.get("ftm").getAsInt());
                    teamStatsThirdPartyPayload.setFta(teamStatsObject.get("fta").getAsInt());
                    teamStatsThirdPartyPayload.setFtp(teamStatsObject.get("ftp").getAsString());
                    teamStatsThirdPartyPayload.setTpm(teamStatsObject.get("tpm").getAsInt());
                    teamStatsThirdPartyPayload.setTpa(teamStatsObject.get("tpa").getAsInt());
                    teamStatsThirdPartyPayload.setTpp(teamStatsObject.get("tpp").getAsString());
                    teamStatsThirdPartyPayload.setOffReb(teamStatsObject.get("offReb").getAsInt());
                    teamStatsThirdPartyPayload.setDefReb(teamStatsObject.get("defReb").getAsInt());
                    teamStatsThirdPartyPayload.setTotReb(teamStatsObject.get("totReb").getAsInt());
                    teamStatsThirdPartyPayload.setAssists(teamStatsObject.get("assists").getAsInt());
                    teamStatsThirdPartyPayload.setPFouls(teamStatsObject.get("pFouls").getAsInt());
                    teamStatsThirdPartyPayload.setSteals(teamStatsObject.get("steals").getAsInt());
                    teamStatsThirdPartyPayload.setTurnovers(teamStatsObject.get("turnovers").getAsInt());
                    teamStatsThirdPartyPayload.setBlocks(teamStatsObject.get("blocks").getAsInt());
                    teamStatsThirdPartyPayload.setPlusMinus(teamStatsObject.get("plusMinus").getAsInt());
                    return teamStatsThirdPartyPayload;
                }
            }

        } catch (
                Exception ex) {
            throw ex;
        }
        return null;
    }
}
