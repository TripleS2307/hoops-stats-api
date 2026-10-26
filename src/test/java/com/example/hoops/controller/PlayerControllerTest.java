package com.example.hoops.controller;

import com.example.hoops.model.Player;
import com.example.hoops.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlayerController.class)
public class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private PlayerService playerService;

    @Test
    void shouldCreatePlayerSuccessfully() throws Exception {
        Player inputPlayer = new Player(null, "Stephen Curry", 29.4);
        Player savedPlayer = new Player(1L, "Stephen Curry", 29.4);

        when(playerService.savePlayer(any(Player.class))).thenReturn(savedPlayer);

        mockMvc.perform(post("/api/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inputPlayer)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Stephen Curry"))
                .andExpect(jsonPath("$.pointsPerGame").value(29.4));
    }

    @Test
    void shouldGetPlayerByIdSuccessfully() throws Exception {
        Player foundPlayer = new Player(1L, "LeBron James", 25.7);

        when(playerService.getPlayer(eq(1L))).thenReturn(foundPlayer);

        mockMvc.perform(get("/api/players/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("LeBron James"))
                .andExpect(jsonPath("$.pointsPerGame").value(25.7));
    }
}
