package co.usaciclo3.ciclo3.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import co.usaciclo3.ciclo3.model.Reservation;
import co.usaciclo3.ciclo3.service.ReservationService;

//OPERACIONES CRUD  - LISTAR
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})


public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation p){
        Date today=Calendar.getInstance().getTime();
        p.setDevolutionDate(today);
        return reservationService.save(p);
    }
    
    // @DeleteMapping("Reservation/delete/{id}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // public boolean borrarReservation(@PathVariable("id") Integer id){
    //        return reservationService.borrarReservationId(id);
    // }
}
