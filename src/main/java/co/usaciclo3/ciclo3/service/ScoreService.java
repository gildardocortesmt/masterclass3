package co.usaciclo3.ciclo3.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usaciclo3.ciclo3.model.Score;
import co.usaciclo3.ciclo3.repository.ScoreRepository;

@Service
public class ScoreService {
     
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score s){
        if(s.getIdScore()==null){
            return scoreRepository.save(s);
        }else{
            //Valida si el Id existe, si es vacío no existe y lo guarda
            Optional<Score> saux=scoreRepository.getScore(s.getIdScore());
            if (saux.isEmpty()){
                return scoreRepository.save(s);
            }else{
                return s;
            }
        }
    }
    
    public Score update(Score k){
        if(k.getIdScore()!=null){
            Optional<Score> kaux=scoreRepository.getScore(k.getIdScore());
            if (kaux.isEmpty()){
                return scoreRepository.save(k);
            }

        }
    return null;       
    }
    
    public boolean deleteScore(int id){
        Boolean aBoolean=getScore(id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}