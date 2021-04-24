package com.killstealer.services;

import com.killstealer.entities.League;
import com.killstealer.repositories.LeagueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static com.killstealer.API.SecretAPIKeys.API_KEY;

@Service
public class LeagueService {
    @Autowired
    private LeagueRepo leagueRepo;

    public List<League> getChallengerLeague() {
        RestTemplate template = new RestTemplate();
        String URL = "https://euw1.api.riotgames.com/lol/league/v4/challengerleagues/by-queue/RANKED_SOLO_5x5?api_key=";
        Map response = template.getForObject(URL + API_KEY, Map.class);

        List<Map> summonersMap = (List<Map>) response.get("entries");
        List<League> challengerPlayers = new ArrayList<>();

        if(summonersMap == null)
            return null;

        for(Map summonerMap : summonersMap) {
            String summonerId = summonerMap.get("summonerId").toString();
            String summonerName = summonerMap.get("summonerName").toString();
            int leaguePoints = Integer.parseInt(summonerMap.get("leaguePoints").toString());
            String rank = summonerMap.get("rank").toString();
            int wins = Integer.parseInt(summonerMap.get("wins").toString());
            int losses = Integer.parseInt(summonerMap.get("losses").toString());

            League challengerPlayer = new League(summonerId, summonerName, leaguePoints, rank, wins, losses);

            challengerPlayers.add(challengerPlayer);
        }
        Comparator c = Collections.reverseOrder(new sortByLeaguePoints());

        Collections.sort(challengerPlayers, c);
        return challengerPlayers;
    }

    private class sortByLeaguePoints implements Comparator<League> {
        public int compare(League a, League b) {
            return a.getLeaguePoints() - b.getLeaguePoints();
        }
    }
}
