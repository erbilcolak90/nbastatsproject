package com.stats.nbastatsbomb.repositories.elasticsearch;

import com.stats.nbastatsbomb.entities.StatsElasticsearch;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface StatsElasticsearchRepository extends ElasticsearchRepository<StatsElasticsearch, Integer> {

    @Query("{\"bool\": {\"must\": [{\"match_phrase_prefix\": {\"player_name\": \"?0\"}}]}}")
    List<StatsElasticsearch> findByCustomPlayerNameStartsWith(String player_name);

}
