package com.mypack.service;

import com.mypack.entity.Patient;
import com.mypack.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository repository;
    public List<Patient> getAllPatients()
    {
        return repository.findAll();
    }
    public Patient savePatient(Patient p){
        return repository.save(p);
    }
    public Patient getPatientById(Long id){
        return repository.findById(id)
                .orElseThrow(()->new RuntimeException("patient not found wit id "));
    }
    public Patient upadatePatient(Patient patient){
       return repository.save(patient);
    }
    public  void deletePatient(Long id){
       repository.deleteById(id);

    }
}
