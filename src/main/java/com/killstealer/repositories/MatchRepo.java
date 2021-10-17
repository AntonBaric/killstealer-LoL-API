package com.killstealer.repositories;

import com.killstealer.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo extends JpaRepository<Match, String> {
}
