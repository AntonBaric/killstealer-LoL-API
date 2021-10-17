package com.killstealer.controllers;

import com.killstealer.entities.Summoner;
import com.killstealer.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MatchController {
    @Autowired
    MatchService matchService;

    @GetMapping("/matches/{puuid}")
    public Summoner getMatchesByPuuid(@PathVariable String puuid) {
        return matchService.getMatchesByPuuid(puuid);
    }
}
