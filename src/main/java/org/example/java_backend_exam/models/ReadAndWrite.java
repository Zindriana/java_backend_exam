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
                char shifted = (char) (c - 1);
                if (shifted < 32) {
                    shifted += 95;
                }
                encryptString.append(shifted);
            }
        return encryptString.toString().trim();
    }

    private String encryptHuman(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);
        String reversedString = stringBuilder.reverse().toString();
        StringBuilder encryptedString = new StringBuilder();
        for (char c : reversedString.toCharArray()) {
            switch (c){
                case '0':
                    encryptedString.append('é');
                    break;
                case '1':
                    encryptedString.append('ñ');
                    break;
                case '2':
                    encryptedString.append('ü');
                    break;
                case '3':
                    encryptedString.append('ö');
                    break;
                case '4':
                    encryptedString.append('å');
                    break;
                case '5':
                    encryptedString.append('ä');
                    break;
                case '6':
                    encryptedString.append('£');
                    break;
                case '7':
                    encryptedString.append('@');
                    break;
                case '8':
                    encryptedString.append('ó');
                    break;
                case '9':
                    encryptedString.append('á');
                    break;
                case '!':
                    encryptedString.append('#');
                    break;
                case '?':
                    encryptedString.append('ë');
                    break;
                case '@':
                    encryptedString.append('?');
                    break;
                case '$':
                    encryptedString.append('+');
                    break;
                case '/':
                    encryptedString.append('-');
                    break;
                case '*':
                    encryptedString.append('/');
                    break;
                case '-':
                    encryptedString.append('.');
                    break;
                case '+':
                    encryptedString.append(',');
                    break;
                case '=':
                    encryptedString.append('[');
                break;
                default:
                    if(c == ' '){encryptedString.append(rand.nextInt(10));
                    } else {
                        encryptedString.append(c);
                    }
                    break;
            }
        }
        return encryptedString.toString().trim();
    }

    private String encryptOrc(String text) {
        StringBuilder encryptString = new StringBuilder();
        for (char c : text.toCharArray()) {
            char shifted = (char) (c + 1);
            if (shifted > 126) {
                shifted -= 95;
            }
            encryptString.append(shifted);
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
        StringBuilder decryptedString = new StringBuilder();
        for (char c : text.toCharArray()) {
            char shifted = (char) (c + 1);
            if (shifted > 126) {
                shifted -= 95;
            }
            decryptedString.append(shifted);
        }
        return decryptedString.toString().trim();
    }

    private String decryptHuman(String text) {
        StringBuilder decryptedString = new StringBuilder();
        for (char c : text.toCharArray()) {
            switch (c){
                case 'é':
                    decryptedString.append('0');
                    break;
                case 'ñ':
                    decryptedString.append('1');
                    break;
                case 'ü':
                    decryptedString.append('2');
                    break;
                case 'ö':
                    decryptedString.append('3');
                    break;
                case 'å':
                    decryptedString.append('4');
                    break;
                case 'ä':
                    decryptedString.append('5');
                    break;
                case '£':
                    decryptedString.append('6');
                    break;
                case '@':
                    decryptedString.append('7');
                    break;
                case 'ó':
                    decryptedString.append('8');
                    break;
                case 'á':
                    decryptedString.append('9');
                    break;
                case '#':
                    decryptedString.append('!');
                    break;
                case 'ë':
                    decryptedString.append('?');
                    break;
                case '?':
                    decryptedString.append('@');
                    break;
                case '+':
                    decryptedString.append('$');
                    break;
                case '-':
                    decryptedString.append('/');
                    break;
                case '/':
                    decryptedString.append('*');
                    break;
                case '.':
                    decryptedString.append('-');
                    break;
                case ',':
                    decryptedString.append('+');
                    break;
                case '[':
                    decryptedString.append('=');
                    break;
                default:
                    if (Character.isDigit(c)) {
                        decryptedString.append(' ');
                    } else {
                        decryptedString.append(c);
                    }
                    break;
            }

        }
        return decryptedString.reverse().toString();
    }

    private String decryptOrc(String text) {
        StringBuilder decryptedString = new StringBuilder();
        for (char c : text.toCharArray()) {
            char shifted = (char) (c - 1);
            if (shifted < 32) {
                shifted += 95;
            }
            decryptedString.append(shifted);
        }
        return decryptedString.toString().trim();
    }
}
