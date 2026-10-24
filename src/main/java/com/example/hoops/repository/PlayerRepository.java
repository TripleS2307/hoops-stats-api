package com.example.hoops.repository;


import com.example.hoops.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    // Extending JpaRepository automatically gives us .save(), .findById(), .findAll()
}
