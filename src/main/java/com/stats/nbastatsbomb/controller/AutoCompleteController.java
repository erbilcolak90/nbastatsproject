package com.stats.nbastatsbomb.controller;

import com.stats.nbastatsbomb.entities.StatsElasticsearch;
import com.stats.nbastatsbomb.payloads.StatsPayload;
import com.stats.nbastatsbomb.services.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AutoCompleteController {

    private final StatsService statsService;

    @GetMapping("/search_results")
    public ResponseEntity<List<StatsElasticsearch>> search_results(@RequestParam String player_name){
        return ResponseEntity.ok(statsService.searchStatsByPlayerName(player_name));
    }

    @GetMapping("/playerNames")
    public String playerNames(Model model) {
        model.addAttribute("suggestions", new ArrayList<>());
        return "playerNames";
    }

    @GetMapping("/player_stats")
    public String playerStats(@RequestParam String player_name, Model model) {
        List<StatsPayload> statsList = statsService.getPlayerDetailsByPlayerName(player_name);
        model.addAttribute("player_name", player_name);
        model.addAttribute("statsList", statsList);
        return "playerStats";
    }
}
