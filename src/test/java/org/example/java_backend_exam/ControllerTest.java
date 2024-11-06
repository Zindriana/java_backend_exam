package org.example.java_backend_exam;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.example.java_backend_exam.models.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void createHero() throws Exception {
        Hero hero = new Hero("Stina", List.of("Human", "orc"));
        mockMvc.perform(post("/createhero")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(hero)))
                        .andExpect(status().isOk());

        mockMvc.perform(get("/getheroes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Stina"))
                .andExpect(jsonPath("$[0].languages", hasSize(2)));
    }

    @Test
    void createScrolls() {
    }

    @Test
    void getHeroes() {
    }

    @Test
    void getScrolls() {
    }

    @Test
    void decrypt() {
    }
}