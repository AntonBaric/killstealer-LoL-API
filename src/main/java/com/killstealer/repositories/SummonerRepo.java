package com.killstealer.repositories;

import com.killstealer.entities.Summoner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummonerRepo extends JpaRepository<Summoner, String> {
}
