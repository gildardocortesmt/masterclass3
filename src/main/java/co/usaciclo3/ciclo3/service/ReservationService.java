package co.usaciclo3.ciclo3.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usaciclo3.ciclo3.model.Reservation;
import co.usaciclo3.ciclo3.repository.ReservationRepository;

@Service
public class ReservationService {
     
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else{
            //Valida si el Id existe, si es vacío no existe y lo guarda
            Optional<Reservation> raux=reservationRepository.getReservation(r.getIdReservation());
            if (raux.isEmpty()){
                return reservationRepository.save(r);
            }else{
                return r;
            }
        }
    }
    
    public Reservation update(Reservation k){
        if(k.getIdReservation()!=null){
            Optional<Reservation> kaux=reservationRepository.getReservation(k.getIdReservation());
            if (!kaux.isEmpty()){
                return reservationRepository.save(k);
            }

        }
    return null;       
    }
    
    public boolean deleteReservation(int id){
        Boolean aBoolean=getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
