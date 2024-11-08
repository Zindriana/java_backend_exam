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

    public Scroll decryptScroll(Scroll scroll) {
        String language = scroll.getLanguage();
        Scroll decryptedScroll = scroll;
        switch (language) {
            case "dwarven":
                decryptedScroll.setContent(decryptDwarven(scroll.getContent()));
                return decryptedScroll;
            case "elven":
                decryptedScroll.setContent(decryptElven(scroll.getContent()));
                return decryptedScroll;
            case "human":
                decryptedScroll.setContent(decryptHuman(scroll.getContent()));
                return decryptedScroll;
            case "orc":
                decryptedScroll.setContent(decryptOrc(scroll.getContent()));
                return decryptedScroll;
            default:
                break;
        }
        return scroll;
    }

    private String encryptDwarven(String text) {
        StringBuilder encryptString = new StringBuilder();
        String trimmedText = text.trim();
        for (char c : trimmedText.toCharArray()) {
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
        return encryptString.toString().trim();
    }

    private String encryptHuman(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);
        String reversedString = stringBuilder.reverse().toString();
        StringBuilder encryptedString = new StringBuilder();
        for (char c : reversedString.toCharArray()) {
            if (c == ' ') {
                encryptedString.append(rand.nextInt(10));
            } else {
                encryptedString.append(c);
            }
        }
        return encryptedString.toString().trim();
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
        return encryptString.toString().trim();
    }

    private String decryptDwarven(String encryptedText) {
        StringBuilder decryptedString = new StringBuilder();
        String[] asciiValues = encryptedText.split(" ");

        for (String asciiValue : asciiValues) {
            int charCode = Integer.parseInt(asciiValue);
            decryptedString.append((char) charCode);
        }

        return decryptedString.toString();
    }

    private String decryptElven(String text) {
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

    private String decryptHuman(String text) {
        StringBuilder decryptedString = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                decryptedString.append(' ');
            } else {
                decryptedString.append(c);
            }
        }
        return decryptedString.reverse().toString();
    }

    private String decryptOrc(String text) {
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
        return encryptString.toString().trim();
    }
}
