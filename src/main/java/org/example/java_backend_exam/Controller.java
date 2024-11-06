package org.example.java_backend_exam;

import org.example.java_backend_exam.models.Hero;
import org.example.java_backend_exam.models.ReadAndWrite;
import org.example.java_backend_exam.models.Scroll;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    private ArrayList<Hero> heroList = new ArrayList<>();
    private ArrayList<Scroll> scrollList = new ArrayList<>();
    private final ReadAndWrite language = new ReadAndWrite();

    public Controller() {}

    @CrossOrigin(origins = "https://zindriana.github.io/")
    @PostMapping("/createhero")
    public void CreateHero(@RequestBody Hero hero){
        heroList.add(hero);
    }

    @PostMapping("/createscroll")
    public void CreateScrolls(@RequestBody Scroll scroll){

    }

    @GetMapping("/getheroes")
    public List<Hero> getHeroes(){
        return heroList;
    }

    @GetMapping("/getscrolls")
    public List<Scroll> getScrolls(){
        return null;
    }

    @PostMapping("/decrypt")
    public Scroll decrypt(@RequestBody Scroll scroll){
        return null;
    }

}

