package com.stats.nbastatsbomb.services.mongoservices;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.stats.nbastatsbomb.entities.mongoentities.TeamMongo;
import com.stats.nbastatsbomb.inputs.team.GetTeamInfoInput;
import com.stats.nbastatsbomb.repositories.mongo.TeamMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamMongoService {

    private final TeamMongoRepository teamMongoRepository;

    @Value("${rapidApi.url}")
    private String url;

    private String teamStats = "teams?id=";

    @Value("${rapidApi.apiKey}")
    private String apiKey;


    public List<TeamMongo> addTeamListToDb() throws IOException, InterruptedException {
        List<TeamMongo> teamMongoList= new ArrayList<>();
        for(int i = 1 ; i<35 ; i++){
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url+teamStats+i))
                    .header("X-RapidAPI-Key", "03a119ff6fmsh5ad9d26add6fffcp1e7cebjsnb0ed70b7b03f")
                    .header("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());


            if(response.statusCode() == 200) {
                String responseBody = response.body();
                JsonElement jsonElement = JsonParser.parseString(responseBody);
                if (jsonElement.isJsonObject()) {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    if (jsonObject.has("response")) {
                        JsonArray responseArray = jsonObject.getAsJsonArray("response");
                        if (responseArray.size() > 0) {
                            JsonObject teamStatsObject = responseArray.get(0).getAsJsonObject(); // İlk öğe varsayılan olarak alınıyor
                            TeamMongo teamMongo = new TeamMongo();
                            teamMongo.setApiId(teamStatsObject.get("id").getAsInt());
                            teamMongo.setName(teamStatsObject.get("name").getAsString());
                            teamMongo.setNickName(teamStatsObject.get("nickname").getAsString());
                            teamMongo.setCode(teamStatsObject.get("code").getAsString());
                            teamMongo.setCity(teamStatsObject.get("city").getAsString());
                            teamMongo.setLogo(teamStatsObject.get("logo").getAsString());
                            teamMongoRepository.save(teamMongo);
                            teamMongoList.add(teamMongo);
                        }
                    }
                }
            }
        }

        return teamMongoList;
    }

    public TeamMongo getTeamInfo(GetTeamInfoInput getTeamInfoInput) {
        TeamMongo dbTeam = teamMongoRepository.findByName(getTeamInfoInput.getTeamName()).orElse(null);
        return dbTeam;
    }
}
