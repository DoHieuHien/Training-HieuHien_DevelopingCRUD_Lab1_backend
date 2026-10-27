package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tools.jackson.databind.JsonNode;

@FeignClient(name = "sport", url = "${sport.base-url}")
public interface SportClient {

        @PostMapping("/hien/sport/leagues/import")
        JsonNode importLeagues();

        @PostMapping("/hien/sport/matches/import")
        JsonNode importMatches(@RequestParam("leagueShortcut") String leagueShortcut,
                               @RequestParam("leagueSeason") String leagueSeason);

        @GetMapping("/hien/sport/leagues")
        JsonNode leagues(@RequestParam("page") int page, @RequestParam("size") int size);

        @GetMapping("/hien/sport/leagues/options")
        JsonNode leagueOptions();

        @GetMapping("/hien/sport/leagues/export")
        ResponseEntity<byte[]> exportLeagues();

        @GetMapping("/hien/sport/matches")
        JsonNode matches(@RequestParam(value = "leagueShortcut", required = false) String leagueShortcut,
                         @RequestParam(value = "leagueSeason", required = false) String leagueSeason,
                         @RequestParam("page") int page, @RequestParam("size") int size);

        @GetMapping("/hien/sport/matches/export")
        ResponseEntity<byte[]> exportMatches(
                @RequestParam(value = "leagueShortcut", required = false) String leagueShortcut,
                @RequestParam(value = "leagueSeason", required = false) String leagueSeason);
    }

