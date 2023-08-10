package com.stats.nbastatsbomb.repositories.elasticsearch;

import com.stats.nbastatsbomb.entities.Stats;
import com.stats.nbastatsbomb.entities.StatsElasticsearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StatsElasticsearchRepository extends ElasticsearchRepository<StatsElasticsearch, Integer> {

/*
    @Query("{\"prefix\": {\"player_name\": \"?0\"}}")
    List<StatsElasticsearch> searchStatsByPlayerName(@PathVariable("player_name") String player_name);
*/
    //List<StatsElasticsearch> findByPlayerNameStartsWith(String player_name);

    @Query("{\"bool\": {\"must\": [{\"match_phrase_prefix\": {\"player_name\": \"?0\"}}]}}")
    List<StatsElasticsearch> findByCustomPlayerNameStartsWith(String player_name);

}
