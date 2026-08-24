package com.mypack.service;

import com.mypack.entity.Docter;
import com.mypack.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository repository;
    // Add new doctor
    public List<Docter> getAllDoctor(){
        return repository.findAll();
    }
    public Docter saveDoctor(Docter d){
        return repository.save(d);
    }
    public Docter getDoctorById(Long id){
        return repository.findById(id)
                .orElseThrow(()->new RuntimeException("Doctor not found wit id "));
    }
    public Docter upadateDoctor(Docter docter){
        return repository.save(docter);
    }
   public void deleteDoctor(Long id){
        repository.deleteById(id);

    }

}
