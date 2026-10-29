package com.example.hoops.controller;

import com.example.hoops.model.Player;
import com.example.hoops.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // POST /api/players
    @PostMapping
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) {
        Player savedPlayer = playerService.savePlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer);
    }

    // GET /api/players/1
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable Long id) {
        Player player = playerService.getPlayer(id);
        return ResponseEntity.ok(player);
    }

    // Example URLs you can test
    // GET /api/players
    // GET /api/players?minPpg=20
    @GetMapping
    public ResponseEntity<List<Player>> listPlayers(@RequestParam(required = false) Double minPpg) {
        List<Player> players;
        if (minPpg != null) {
            players = playerService.listPlayersWithPointsAtLeast(minPpg);
        }
        else {
            players = playerService.listPlayers();
        }
        return ResponseEntity.ok(players);
    }
}
