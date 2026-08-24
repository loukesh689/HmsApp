package com.mypack.controller;

import com.mypack.entity.Patient;
import com.mypack.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("patient")
public class PatientController {

    @Autowired
    PatientService service;
    //open in the browser "localhost:5050/patient"
    @GetMapping("/patient")
    public String getAllPatient(Model model){
        model.addAttribute("Patient",service.getAllPatients());
        return "/Patient/Patient";
    }

    @GetMapping("/Patient/new")
    public String AddNewPatient(Model model)
    {
        Patient p=new Patient();
        model.addAttribute("Patient",p);
        return "/Patient/Add_Patient";
    }

    @PostMapping("/patient")
    public String savePatient(@ModelAttribute Patient p)
    {
        service.savePatient(p);
        return "redirect:/patient";
    }

    @GetMapping("/patient/edit/{id}")
    public String editPatientForm(@PathVariable Long id, Model model) {
        model.addAttribute("Patient", service.getPatientById(id));
        return "/Patient/edit_Patient";
    }

    @PostMapping("/patient/{id}")
    public String updatePatient(@PathVariable Long id, @ModelAttribute("Patient") Patient patient) {

        // Fetch the current record
        Patient existingPatient = service.getPatientById(id);

        // Update fields from the form submission
        existingPatient.setName(patient.getName());
        existingPatient.setGender(patient.getGender());
        existingPatient.setAge(patient.getAge());
        existingPatient.setContact(patient.getContact());
        existingPatient.setDisease(patient.getDisease());

        // Save the changes back to the database
        service.upadatePatient(existingPatient);

        return "redirect:/patient";
    }

    // handler method to handle delete patient request

   @GetMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        service.deletePatient(id);
        return "redirect:/patient";
    }
}