package org.example.java_backend_exam;

import org.example.java_backend_exam.lists.HeroList;
import org.example.java_backend_exam.lists.ScrollList;
import org.example.java_backend_exam.models.Hero;
import org.example.java_backend_exam.models.ReadAndWrite;
import org.example.java_backend_exam.models.Scroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private final HeroList heroList;
    private final ScrollList scrollList;
    private final ReadAndWrite language = new ReadAndWrite();

    @Autowired
    public Controller(HeroList heroList, ScrollList scrollList) {
        this.heroList = heroList;
        this.scrollList = scrollList;
    }

    @CrossOrigin(origins = "https://zindriana.github.io/")
    @PostMapping("/createhero")
    public void CreateHero(@RequestBody Hero hero){
    }

    @PostMapping("/createscroll")
    public void CreateScrolls(@RequestBody Scroll scroll){

    }

    @GetMapping("/getheroes")
    public List<Hero> getHeroes(){
        return null;
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

