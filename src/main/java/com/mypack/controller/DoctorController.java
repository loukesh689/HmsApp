package com.mypack.controller;

import com.mypack.entity.Docter;
import com.mypack.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    DoctorService service;

    @GetMapping("/doctor")
    public String getAllDocter(Model model){
        model.addAttribute("doctors",service.getAllDoctor());
        return "Doctor/doctor";
    }

    @GetMapping("/doctor/new")
    public String AddNewDoctor(Model model)
    {
        Docter d =new Docter();
        model.addAttribute("Doctor",d);
        return "Doctor/create_doctor";
    }

    @PostMapping("/doctor")
    public String saveDoctor(@ModelAttribute Docter d)
    {
        service.saveDoctor(d);
        return "redirect:/doctor";
    }

    @GetMapping("/doctor/edit/{id}")
    public String editDoctorForm(@PathVariable Long id, Model model) {
        model.addAttribute("doctor", service.getDoctorById(id));
        return "Doctor/edit_Doctor";
    }

    @PostMapping("/doctor/{id}")
    public String updateDoctor(@PathVariable Long id, @ModelAttribute("Doctor") Docter docter) {

        // Fetch the current record
        Docter existingDoctor = service.getDoctorById(id);

        // Update fields from the form submission
        existingDoctor.setName(docter.getName());
        existingDoctor.setSpecialization(docter.getSpecialization());
        existingDoctor.setFees(docter.getFees());


        // Save the changes back to the database
        service.upadateDoctor(existingDoctor);

        return "redirect:/Patient";
    }

    // handler method to handle delete patient request

    @GetMapping("/doctor/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        service.deleteDoctor(id);
        return "redirect:/doctor";
    }
}
