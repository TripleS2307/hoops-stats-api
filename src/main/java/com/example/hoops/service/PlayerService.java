package com.example.hoops.service;

import com.example.hoops.model.Player;
import com.example.hoops.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player savePlayer(Player player) {
        // Business logic check: You can't average more than 100 points
        if (player.getPointsPerGame() > 100.0) {
            throw new IllegalArgumentException("Invalid points per game record.");
        }
        return playerRepository.save(player);
    }

    public Player getPlayer(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found with ID: " + id));
    }
}
