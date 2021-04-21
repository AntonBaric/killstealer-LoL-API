package com.killstealer.repositories;

import com.killstealer.entities.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepo extends JpaRepository<League, String> {
}
