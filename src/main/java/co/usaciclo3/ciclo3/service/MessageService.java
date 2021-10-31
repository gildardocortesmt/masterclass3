package co.usaciclo3.ciclo3.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usaciclo3.ciclo3.model.Message;
import co.usaciclo3.ciclo3.repository.MessageRepository;

@Service
public class MessageService {
     
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);
        }else{
            //Valida si el Id existe, si es vacío no existe y lo guarda
            Optional<Message> maux=messageRepository.getMessage(m.getIdMessage());
            if (maux.isEmpty()){
                return messageRepository.save(m);
            }else{
                return m;
            }
        }
    }
    
    public Message update(Message k){
        if(k.getIdMessage()!=null){
            Optional<Message> kaux=messageRepository.getMessage(k.getIdMessage());
            if (!kaux.isEmpty()){
                return messageRepository.save(k);
            }

        }
    return null;       
    }
    
    public boolean deleteMessage(int id){
        Boolean aBoolean=getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
