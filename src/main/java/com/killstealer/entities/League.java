package com.killstealer.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class League {
    @Id
    private String summonerId;
    private String summonerName;
    private int leaguePoints;
    private String rank;
    private int wins;
    private int losses;

    public League() {
    }

    public League(String summonerId, String summonerName, int leaguePoints, String rank, int wins, int losses) {
        this.summonerId = summonerId;
        this.summonerName = summonerName;
        this.leaguePoints = leaguePoints;
        this.rank = rank;
        this.wins = wins;
        this.losses = losses;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    @Override
    public String toString() {
        return "League{" +
                "summonerId='" + summonerId + '\'' +
                ", summonerName='" + summonerName + '\'' +
                ", leaguePoints=" + leaguePoints +
                ", rank='" + rank + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                '}';
    }
}
