package co.usaciclo3.ciclo3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import co.usaciclo3.ciclo3.model.Score;
import co.usaciclo3.ciclo3.service.ScoreService;

//OPERACIONES CRUD  - LISTAR
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})


public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getScores(){
        return scoreService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Score> getReservation(@PathVariable("id") int id){
        return scoreService.getScore(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score p){
        return scoreService.save(p);
    }
    
    // @DeleteMapping("Score/delete/{id}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // public boolean borrarScore(@PathVariable("id") Integer id){
    //        return scoreService.borrarScoreId(id);
    // }
}
