package com.example.hoops.service;

import com.example.hoops.model.Player;
import com.example.hoops.repository.PlayerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Test
    void shouldSavePlayerSuccessfully() {
        // Arrange
        Player inputPlayer = new Player(null, "LeBron James", 25.7);
        Player savedPlayer = new Player(1L, "LeBron James", 25.7);

        when(playerRepository.save(any(Player.class))).thenReturn(savedPlayer);

        // Act
        Player result = playerService.savePlayer(inputPlayer);


        // Assert
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getId()).isEqualTo(1L);
        Assertions.assertThat(result.getName()).isEqualTo("LeBron James");
        Assertions.assertThat(result.getPointsPerGame()).isEqualTo(25.7);

        // Verify repository interaction
        verify(playerRepository, times(1)).save(inputPlayer);
    }

    @Test
    void shouldThrowExceptionWhenPointsExceedMaximum() {
        // Arrange
        Player invalidPlayer = new Player(null, "Wilt Chamberlain Jr", 105.0);

        // Act & Assert
        Assertions.assertThatThrownBy(() -> playerService.savePlayer(invalidPlayer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid points per game record.");

        // Verify repository is never called if validation fails early
        verify(playerRepository, never()).save(any(Player.class));
    }
}
