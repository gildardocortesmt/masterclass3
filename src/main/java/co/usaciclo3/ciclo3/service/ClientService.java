package co.usaciclo3.ciclo3.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usaciclo3.ciclo3.model.Client;
import co.usaciclo3.ciclo3.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client c){
        if(c.getIdClient()==null){
            return clientRepository.save(c);
        }else{
            //Valida si el Id existe, si es vacío no existe y lo guarda
            Optional<Client> caux=clientRepository.getClient(c.getIdClient());
            if (caux.isEmpty()){
                return clientRepository.save(c);
            }else{
                return c;
            }
        }
    }
    
    public Client update(Client k){
        if(k.getIdClient()!=null){
            Optional<Client> kaux=clientRepository.getClient(k.getIdClient());
            if (!kaux.isEmpty()){
                return clientRepository.save(k);
            }

        }
    return null;       
    }
    
    public boolean deleteClient(int id){
        Boolean aBoolean=getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
