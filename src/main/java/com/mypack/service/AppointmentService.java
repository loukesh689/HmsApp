package com.mypack.service;

import com.mypack.entity.Appointment;
import com.mypack.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository repository;
    public List<Appointment> getAllAppointment(){
        return repository.findAll();
    }
    public Appointment saveAppointment(Appointment a){
        return repository.save(a);
    }
    public Appointment getAppointmentById(Long id){
        return repository.findById(id)
                .orElseThrow(()->new RuntimeException("Appointment not found wit id "));
    }
    public Appointment upadateAppointment(Appointment appointment){
        return repository.save(appointment);
    }
   /* public  void deleteAppointment(Long id){
        repository.deleteById(id);

    }*/
}
