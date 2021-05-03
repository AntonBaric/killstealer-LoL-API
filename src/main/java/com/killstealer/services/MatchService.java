package com.killstealer.services;

import com.killstealer.entities.League;
import com.killstealer.entities.Match;
import com.killstealer.entities.Summoner;
import com.killstealer.repositories.MatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.killstealer.API.SecretAPIKeys.API_KEY;

@Service
public class MatchService {
    @Autowired
    MatchRepo matchRepo;


    public Summoner getMatchesByPuuid(String puuid) {
        RestTemplate template = new RestTemplate();
        String URL = "https://europe.api.riotgames.com/lol/match/v5/matches/by-puuid/" + puuid + "/ids?start=0&count=20&api_key=";
        Map response = template.getForObject(URL + API_KEY, Map.class);

        List<Match> matches = new ArrayList<>();

        for(match : matches) {
            String matchId = response.get("ma")
            Match match = new Match(matchId);
        }
    }
}
