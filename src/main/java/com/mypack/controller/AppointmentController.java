package com.mypack.controller;

import com.mypack.entity.Appointment;
import com.mypack.entity.Docter;
import com.mypack.entity.Patient;
import com.mypack.service.AppointmentService;
import com.mypack.service.DoctorService;
import com.mypack.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppointmentController {
    @Autowired
    AppointmentService service;
    @Autowired
     PatientService patientService;

    @Autowired
     DoctorService doctorService;

    // Show Appointment Form
    @GetMapping("/appointment")
    public String showAppointmentForm(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctor());
        return "Appointment/book_appointment";
    }

    @PostMapping("/appointment/save")
    public String saveAppointment(
            @RequestParam("patientId") Integer patientId,
            @RequestParam("doctorId") Integer docterId,
            @RequestParam("appointmentDate") String appointmentDate)
    {
        Patient patient = patientService.getPatientById(patientId.longValue());
        Docter docter = doctorService.getDoctorById(docterId.longValue());

        if (patient != null && docter != null) {
            Appointment appointment = new Appointment();
            //get data from patient and doctor
            appointment.setPatient_name(patient.getName());
            appointment.setDoctor_name(docter.getName());
            appointment.setDate(appointmentDate); // the date come from th form

            service.saveAppointment(appointment);
        }
        return "redirect:/appointment/list";
    }

    //  Appointment List Page
    @GetMapping("/appointment/list")
    public String appointmentList(Model model) {
        model.addAttribute("appointments", service.getAllAppointment());
        return "Appointment/appointment_list";
    }

    // Delete Appointment
  /*  @GetMapping("/delete/{id}")
   public String deleteAppointment(@PathVariable Integer id) {
       AppointmentService.deleteAppointment(id);
       return "redirect:/appointment/list";
   }*/
}
