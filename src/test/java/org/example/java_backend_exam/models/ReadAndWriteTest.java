package org.example.java_backend_exam.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Todo:Add more tests for handling scrolls containing numbers and special characters
//Todo: also add tests for scrolls containing null, shouldn´t happen, but it will be good to test anyway

class ReadAndWriteTest {

    ReadAndWrite readAndWrite = new ReadAndWrite();

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
    void encryptDwarvenTest() {
        Scroll scroll = new Scroll(" Dwarf scroll", " Dwarven ", "Lorem Ipsum");
        readAndWrite.encryptScroll(scroll);

        assertEquals("76 111 114 101 109 32 73 112 115 117 109", scroll.getContent());
    }

    @Test
    void encryptElvenTest() {
        Scroll scroll = new Scroll(" Elven scroll", " elVen ", "Lorem Ipsum");
        readAndWrite.encryptScroll(scroll);

        assertEquals("Knqdl~Hortl", scroll.getContent());
    }

    @Test
    void encryptHumanTest() {
        Scroll scroll = new Scroll(" Human scroll", " humaN ", "Lorem Ipsum");
        readAndWrite.encryptScroll(scroll);
        scroll.setContent(convertDigitsToZero(scroll.getContent())); //convert the randomized numbers to 0

        assertEquals("muspI0meroL", scroll.getContent());
    }

    @Test
    void encryptOrcTest() {
        Scroll scroll = new Scroll(" Orchish scroll", " oRc ", "Lorem Ipsum");
        readAndWrite.encryptScroll(scroll);

        assertEquals("Mpsfn!Jqtvn", scroll.getContent());
    }

    @Test
    void decryptDwarvenTest() {
        Scroll scroll = new Scroll(" Dwarf scroll", " Dwarven ", "Lorem Ipsum");
        Scroll scroll2 = new Scroll(" Dwarf scroll2", " Dwarven ", " /42*! ");
        readAndWrite.encryptScroll(scroll);
        readAndWrite.decryptScroll(scroll);
        readAndWrite.encryptScroll(scroll2);
        readAndWrite.decryptScroll(scroll2);
        assertEquals("Lorem Ipsum", scroll.getContent());
        assertEquals("/42*!", scroll2.getContent());
    }

    @Test
    void decryptElvenTest() {
        Scroll scroll = new Scroll(" Elven scroll", " elVen ", "Lorem Ipsum");
        Scroll scroll2 = new Scroll(" Elven scroll2", " ElvEn  ", " /42*! ");
        readAndWrite.encryptScroll(scroll);
        readAndWrite.decryptScroll(scroll);
        readAndWrite.encryptScroll(scroll2);
        readAndWrite.decryptScroll(scroll2);
        assertEquals("Lorem Ipsum", scroll.getContent());
        assertEquals("/42*!", scroll2.getContent());
    }

    @Test
    void decryptHumanTest() {
        Scroll scroll = new Scroll(" Human scroll", " humaN ", "Lorem Ipsum");
        Scroll scroll2 = new Scroll("    Human scroll2", "HuMaN ", "/42*!");
        readAndWrite.encryptScroll(scroll);
        scroll.setContent(convertDigitsToZero(scroll.getContent())); //convert the randomized numbers to 0
        readAndWrite.decryptScroll(scroll);
        readAndWrite.encryptScroll(scroll2);
        System.out.println(scroll2.getContent());
        scroll2.setContent(convertDigitsToZero(scroll2.getContent()));
        readAndWrite.decryptScroll(scroll2);
        assertEquals("Lorem Ipsum", scroll.getContent());
        assertEquals("/42*!", scroll2.getContent());
    }

    @Test
    void decryptOrcTest() {
        Scroll scroll = new Scroll(" Orchish scroll", " oRc ", "Lorem Ipsum");
        Scroll scroll2 = new Scroll(" Orc scroll2", " OrC  ", " /42*! ");
        readAndWrite.encryptScroll(scroll);
        readAndWrite.decryptScroll(scroll);
        readAndWrite.encryptScroll(scroll2);
        readAndWrite.decryptScroll(scroll2);
        assertEquals("Lorem Ipsum", scroll.getContent());
        assertEquals("/42*!", scroll2.getContent());
    }

}