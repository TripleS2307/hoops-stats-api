package com.example.hoops.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "players")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Player name cannot be blank")
    private String name;

    @Min(value = 0, message = "Points cannot be negative")
    private double pointsPerGame;

    @Min(value = 0, message = "Rebounds cannot be negative")
    private double reboundsPerGame;

    @Min(value = 0, message = "Assists cannot be negative")
    private double assistsPerGame;

    @Min(value = 0, message = "Steals cannot be negative")
    private double stealsPerGame;

    @Min(value = 0, message = "Blocks cannot be negative")
    private double blocksPerGame;

    @Min(value = 0, message = "3 Pointers Made cannot be negative")
    private double threesPerGame;

    @Min(value = 0, message = "Field goal percentage cannot be negative")
    @Max(value = 1, message = "Field goal percentage cannot exceed 1.0 (100%)")
    private double fieldGoalPercentage;

    @Min(value = 0, message = "Free throw percentage cannot be negative")
    @Max(value = 1, message = "Free throw percentage cannot exceed 1.0 (100%)")
    private double freeThrowPercentage;

    @Min(value = 0, message = "Turnovers cannot be negative")
    private double turnoversPerGame;

    @NotBlank(message = "Player position cannot be blank")
    private String position;
}
