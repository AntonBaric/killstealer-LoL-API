package com.killstealer.services;

import com.killstealer.entities.League;
import com.killstealer.repositories.LeagueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static com.killstealer.API.SecretAPIKeys.API_KEY;

@Service
public class LeagueService {
    @Autowired
    private LeagueRepo leagueRepo;

    public List<League> getChallengerLeague() {
        RestTemplate template = new RestTemplate();
        String URL = "https://euw1.api.riotgames.com/lol/league/v4/challengerleagues/by-queue/RANKED_SOLO_5x5?api_key=";
        Map response = template.getForObject(URL + API_KEY, Map.class);

        List<Map>
    }
}
