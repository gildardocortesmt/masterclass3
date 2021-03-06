package co.usaciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usaciclo3.ciclo3.model.Costume;
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
            Optional<Costume> paux=costumeRepository.getCostume(p.getId());
            if (paux.isEmpty()){
                return costumeRepository.save(p);
            }else{
                return p;
            }
        }
    }
    
    public Costume update(Costume k){
        if(k.getId()!=null){
            Optional<Costume> kaux=costumeRepository.getCostume(k.getId());
            if (!kaux.isEmpty()){
                return costumeRepository.save(k);
            }

        }
    return null;       
    }
    
    public boolean deleteCostume(int id){
        Boolean aBoolean=getCostume(id).map(costume -> {
            costumeRepository.delete(costume);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
