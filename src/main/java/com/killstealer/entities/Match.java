package com.killstealer.entities;

import javax.persistence.Entity;

@Entity
public class Match {
    private String matchId;

    public Match() {
    }

    public Match(String matchId) {
        this.matchId = matchId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchId='" + matchId + '\'' +
                '}';
    }
}
