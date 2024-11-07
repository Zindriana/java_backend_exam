package org.example.java_backend_exam.models;
import java.util.Random;

public class ReadAndWrite {
    Random rand = new Random();

    public Scroll encryptScroll(Scroll scroll) {
        String language = scroll.getLanguage();
        Scroll encryptedScroll = scroll;
        switch (language) {
            case "dwarven":
                encryptedScroll.setContent(encryptDwarven(scroll.getContent()));
                return encryptedScroll;
            case "elven":
                encryptedScroll.setContent(encryptElven(scroll.getContent()));
                return encryptedScroll;
            case "human":
                encryptedScroll.setContent(encryptHuman(scroll.getContent()));
                return encryptedScroll;
            case "orc":
                encryptedScroll.setContent(encryptOrc(scroll.getContent()));
                return encryptedScroll;
            default:
                break;
        }
        return scroll;
    }

    private String encryptDwarven(String text) {
        StringBuilder encryptString = new StringBuilder();
        for (char c : text.toCharArray()) {
            encryptString.append((int) c).append(" ");
        }
        return encryptString.toString().trim();
    }

    private String encryptElven(String text) {
        StringBuilder encryptString = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char shifted = (char) (c - 1);
                if ((Character.isLowerCase(c) && shifted < 'a') || (Character.isUpperCase(c) && shifted < 'A')) {
                    shifted += 26;
                }
                encryptString.append(shifted);
            } else {
                encryptString.append(c);
            }
        }
        return encryptString.toString();
    }

    private String encryptHuman(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);
        String reversedString = stringBuilder.reverse().toString();
        String lowCaseString = reversedString.toLowerCase();
        StringBuilder encryptedString = new StringBuilder();
        for (char c : lowCaseString.toCharArray()) {
            if (c == ' ') {
                encryptedString.append(rand.nextInt(10));
            } else {
                encryptedString.append(c);
            }
        }
        return encryptedString.toString();
    }

    private String encryptOrc(String text) {
        StringBuilder encryptString = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char shifted = (char) (c + 1);
                if ((Character.isLowerCase(c) && shifted > 'z') || (Character.isUpperCase(c) && shifted > 'Z')) {
                    shifted -= 26;
                }
                encryptString.append(shifted);
            } else {
                encryptString.append(c);
            }
        }
        return encryptString.toString();
    }
}
