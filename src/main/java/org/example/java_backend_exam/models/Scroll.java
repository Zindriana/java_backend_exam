package org.example.java_backend_exam.models;

public class Scroll {

    private String name;
    private String language;
    private String content;


    public Scroll(String name, String language, String content) {
        this.name = name.trim();
        this.language = language.trim().toLowerCase();
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
