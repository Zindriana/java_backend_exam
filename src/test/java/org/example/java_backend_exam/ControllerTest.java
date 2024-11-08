package org.example.java_backend_exam;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.jayway.jsonpath.JsonPath;
import org.example.java_backend_exam.models.Hero;
import org.example.java_backend_exam.models.Scroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Todo: Add tests to handle null and with faulty language or scrolls containing numbers

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //human encryption has a randomizer (' ' becomes a random number)
    //this method convert random numbers to zero, so we can use asserEquals in our tests
    String convertDigitsToZero(String text) {
        StringBuilder standardizedString = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                standardizedString.append('0');
            } else {
                standardizedString.append(c);
            }
        }
        return standardizedString.toString();
    }

    @Test
    void createHero() throws Exception {
        Hero hero = new Hero("Stina", List.of("Human", "orc"));
        mockMvc.perform(post("/newhero")
                 .contentType("application/json")
                 .content(objectMapper.writeValueAsString(hero)))
                 .andExpect(status().isOk());

        mockMvc.perform(get("/getheroes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Stina"))
                .andExpect(jsonPath("$[0].languages", hasSize(2)));
    }

    @Test
    void createScrolls() throws Exception{
        Scroll orcScroll = new Scroll("Orcisch ballads", " oRc ", " Songs and stuff ");
        mockMvc.perform(post("/newscroll")
                 .contentType("application/json")
                 .content(objectMapper.writeValueAsString(orcScroll)))
                 .andExpect(status().isOk());

        mockMvc.perform(get("/getscrolls"))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$[0].name").value("Orcisch ballads"))
                 .andExpect(jsonPath("$[0].language").value("orc"))
                 .andExpect(jsonPath("$[0].content").value("Tpoht boe tuvgg"));

        Scroll humanScroll = new Scroll("Human rituals ", " hUmAn ", " Wierd Rituals  ");
        mockMvc.perform(post("/newscroll")
                 .contentType("application/json")
                 .content(objectMapper.writeValueAsString(humanScroll)))
                 .andExpect(status().isOk());

        mockMvc.perform(get("/getscrolls"))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$[1].name").value("Human rituals"))
                 .andExpect(jsonPath("$[1].language").value("human"))
                 .andDo(result -> {
                    String actualContent = JsonPath.read(result.getResponse().getContentAsString(), "$[1].content");
                    String standardizedContent = convertDigitsToZero(actualContent);
                    assertEquals("00slautiR0dreiW0", standardizedContent);
                });

        Scroll elvishScroll = new Scroll("Elven politics", "   eLvEN ", " Political science stuff ");
        mockMvc.perform(post("/newscroll")
                 .contentType("application/json")
                 .content(objectMapper.writeValueAsString(elvishScroll)))
                 .andExpect(status().isOk());

        mockMvc.perform(get("/getscrolls"))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$[2].name").value("Elven politics"))
                 .andExpect(jsonPath("$[2].language").value("elven"))
                 .andExpect(jsonPath("$[2].content").value("Onkhshbzk rbhdmbd rstee"));

        Scroll dwarvenScroll = new Scroll("   Smithing techniques ", " dwArVen ", " Axes and Armours   ");
        mockMvc.perform(post("/newscroll")
                 .contentType("application/json")
                 .content(objectMapper.writeValueAsString(dwarvenScroll)))
                 .andExpect(status().isOk());

        mockMvc.perform(get("/getscrolls"))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$[3].name").value("Smithing techniques"))
                 .andExpect(jsonPath("$[3].language").value("dwarven"))
                 .andExpect(jsonPath("$[3].content").value("65 120 101 115 32 97 110 100 32 65 114 109 111 117 114 115"));

    }


    @Test
    void decrypt() throws Exception {
        Scroll scroll = new Scroll("   Mystisk rulle ", " hUman", " Massa mystisk text");
        mockMvc.perform(post("/newscroll")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(scroll)))
                .andExpect(status().isOk());

        mockMvc.perform(post("/decrypt")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(scroll)))
                .andExpect(status().isOk());

    }

}