package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.controller;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.client.SportClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.JsonNode;

@RestController
@RequestMapping("/hien/sport")
@RequiredArgsConstructor
public class SportController {

    private static final MediaType XLSX =
            MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

    @Autowired
    private SportClient sportClient;

    @PostMapping("/leagues/import")
    public JsonNode importLeagues() { return sportClient.importLeagues(); }

    @PostMapping("/matches/import")
    public JsonNode importMatches(@RequestParam String leagueShortcut, @RequestParam String leagueSeason) {
        return sportClient.importMatches(leagueShortcut, leagueSeason);
    }

    @GetMapping("/leagues")
    public JsonNode leagues(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "10") int size) {
        return sportClient.leagues(page, size);
    }

    @GetMapping("/leagues/options")
    public JsonNode leagueOptions() { return sportClient.leagueOptions(); }

    @GetMapping("/leagues/export")
    public ResponseEntity<byte[]> exportLeagues() {
        return xlsx(sportClient.exportLeagues().getBody(), "leagues.xlsx");
    }

    @GetMapping("/matches")
    public JsonNode matches(@RequestParam(required = false) String leagueShortcut,
                            @RequestParam(required = false) String leagueSeason,
                            @RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "10") int size) {
        return sportClient.matches(leagueShortcut, leagueSeason, page, size);
    }

    @GetMapping("/matches/export")
    public ResponseEntity<byte[]> exportMatches(@RequestParam(required = false) String leagueShortcut,
                                                @RequestParam(required = false) String leagueSeason) {
        return xlsx(sportClient.exportMatches(leagueShortcut, leagueSeason).getBody(), "matches.xlsx");
    }

    private ResponseEntity<byte[]> xlsx(byte[] body, String name) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + name)
                .contentType(XLSX)
                .body(body);
    }
}
