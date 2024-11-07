package org.example.java_backend_exam.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrollTest {

    @Test
    void createScrollBasicTest() {

        Scroll scroll = new Scroll(" Scroll name ", " elven ", "Lorem Ipsum");
        assertNotNull(scroll);
        assertEquals(scroll.getName(), "Scroll name");
        assertEquals(scroll.getLanguage(), "elven");
        assertEquals(scroll.getContent(), "Lorem Ipsum");
    }

}