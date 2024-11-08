package org.example.java_backend_exam.models;

import java.util.List;

public class Hero {

    private String name;
    private List<String> languages;
    private boolean choosen = false;

    public Hero(String name, List<String> languages) {
        this.name = name.trim();
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public boolean isChoosen() {
        return choosen;
    }

    public void setChoosen(boolean choosen) {
        this.choosen = choosen;
    }
}
