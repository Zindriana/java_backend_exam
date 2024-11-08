package org.example.java_backend_exam.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Todo: add test that prevents any field to be empty.

class HeroTest {

    @Test
    void createHeroBasicTest() {
        List<String> languages = new ArrayList<>();
        languages.add("human");
        languages.add("dwarven");
        Hero hero = new Hero(" Hero name ", languages);
        assertNotNull(hero);
        assertEquals(hero.getName(), "Hero name");
        assertEquals(hero.getLanguages().size(), 2);
        assertTrue(hero.getLanguages().contains("dwarven"));
    }

}