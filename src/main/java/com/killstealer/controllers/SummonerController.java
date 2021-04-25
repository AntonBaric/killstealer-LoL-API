package com.killstealer.controllers;

import com.killstealer.entities.Summoner;
import com.killstealer.services.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class SummonerController {
    @Autowired
    SummonerService summonerService;

    @GetMapping("/summoner/{name}")
    public Summoner getSummonerByName(@PathVariable String name) {
        return summonerService.getSummonerByName(name);
    }
}
