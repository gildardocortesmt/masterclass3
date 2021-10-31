package co.usaciclo3.ciclo3.repository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.usaciclo3.ciclo3.model.Score;
import co.usaciclo3.ciclo3.repository.crud.ScoreCrudRepository;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    
    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }

    public Score save(Score s){
        return scoreCrudRepository.save(s);
    }

    public void delete(Score score){
        scoreCrudRepository.delete(score);
    }
    
}

