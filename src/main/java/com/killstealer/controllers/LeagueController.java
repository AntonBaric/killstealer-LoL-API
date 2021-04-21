package com.killstealer.controllers;

import com.killstealer.entities.League;
import com.killstealer.entities.User;
import com.killstealer.services.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/league")
public class LeagueController {
    @Autowired
    private LeagueService leagueService;

    @GetMapping("/challenger")
    public List<League> getChallengerLeague() {
        return leagueService.getChallengerLeague();
    }
}
