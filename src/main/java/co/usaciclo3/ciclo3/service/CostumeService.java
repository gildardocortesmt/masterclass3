package co.usaciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usaciclo3.ciclo3.modelo.Costume;
import co.usaciclo3.ciclo3.repository.CostumeRepository;

@Service
public class CostumeService {
    
    @Autowired
    private CostumeRepository costumeRepository;

    public List<Costume> getAll(){
        return costumeRepository.getAll();
    }
    
    public Optional<Costume> getCostume(int id){
        return costumeRepository.getCostume(id);
    }

    public Costume save(Costume p){
        if(p.getId()==null){
            return costumeRepository.save(p);
        }else{
            //Valida si el Id existe, si es vacío no existe y lo guarda
            Optional<Costume> caux=costumeRepository.getCostume(p.getId());
            if (caux.isEmpty()){
                return costumeRepository.save(p);
            }else{
                return p;
            }
        }
    }
}
