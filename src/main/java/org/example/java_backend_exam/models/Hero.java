package org.example.java_backend_exam.models;

import java.util.List;

public class Hero {

    private String name;
    private List<String> languages;

    public Hero(String name, List<String> languages) {
        this.name = name;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public List<String> getLanguages() {
        return languages;
    }
}
