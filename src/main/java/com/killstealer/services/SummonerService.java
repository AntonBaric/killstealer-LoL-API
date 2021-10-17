package com.killstealer.services;

import com.killstealer.entities.Summoner;
import com.killstealer.repositories.SummonerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static com.killstealer.API.SecretAPIKeys.API_KEY;

@Service
public class SummonerService {
    @Autowired
    SummonerRepo summonerRepo;

    public Summoner getSummonerByName(String username) {
        RestTemplate template = new RestTemplate();
        String URL = "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + username + "?api_key=";
        Map response = template.getForObject(URL + API_KEY, Map.class);

        String id = response.get("id").toString();
        String accountId = response.get("accountId").toString();
        String puuid = response.get("puuid").toString();
        String name = response.get("name").toString();
        int profileIconId = Integer.parseInt(response.get("profileIconId").toString());
        String revisionDate = response.get("revisionDate").toString();
        int summonerLevel = Integer.parseInt(response.get("summonerLevel").toString());

        Summoner summoner = new Summoner(id, accountId, puuid, name, profileIconId, revisionDate, summonerLevel);

        return summoner;
    }
}
