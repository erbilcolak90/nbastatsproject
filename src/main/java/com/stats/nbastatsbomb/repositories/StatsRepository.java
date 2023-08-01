package com.stats.nbastatsbomb.repositories;

import com.stats.nbastatsbomb.entities.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Integer> {

    @Query("SELECT s FROM Stats s WHERE s.player_name = :playerName")
    List<Stats> findByPlayerName(String playerName);
}
