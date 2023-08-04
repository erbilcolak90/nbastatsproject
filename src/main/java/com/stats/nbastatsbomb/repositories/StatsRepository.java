package com.stats.nbastatsbomb.repositories;

import com.stats.nbastatsbomb.entities.Stats;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Integer> {

    @Query("SELECT s FROM Stats s WHERE s.player_name = :playerName")
    List<Stats> findByPlayerName(String playerName);

    @Query("SELECT s FROM Stats s WHERE s.player_name = :full_name AND s.season = :season")
    List<Stats> findByPlayerNameAndSeason(String full_name, String season);

    @Query("SELECT s FROM Stats s WHERE s.team = :teamName AND s.season = :season")
    List<Stats> findByTeamNameAndSeason(String teamName, String season);

    @Query(value = "SELECT * FROM stats ORDER BY ?1", nativeQuery = true)
    Page<Stats> findAllByCustomQuery(String fieldName, Pageable pageable);
}
