package com.mypack.controller;

import com.mypack.entity.Appointment;
import com.mypack.entity.Bill;
import com.mypack.service.AppointmentService;
import com.mypack.service.BillService;
import com.mypack.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BillController {
    @Autowired
    BillService service;
   @Autowired
    AppointmentService appointmentService;
   @Autowired
    DoctorService doctorService;
  // @Autowired
   // EmailService emailService;
    // Controller ke andar
//emailService.sendBillEmail(patientEmailVariable, bill);
    // Show all bills
    @GetMapping("/bill")
    public String billList(Model model) {
        model.addAttribute("bills", service.getAllBills());
        return "Bill/Bill";
    }
    // 1. Khali form dikhane ke liye
    @GetMapping("/bill/new")
    public String showAddBillForm(Model model) {
        model.addAttribute("bill", new Bill()); // Thymeleaf object bind karne ke liye
        return "Bill/add_bill";
    }

    // 2. Form ka data save karne ke liye
    @PostMapping("/bill/save")
    public String saveManualBill(@ModelAttribute("bill") Bill bill) {
        service.saveBill(bill);
        return "redirect:/bill"; // Save hone ke baad list page par bhej dega
    }

    // Generate bill for an appointment
    @GetMapping("/generate/{appointmentId}")
    public String generateBill(@PathVariable Long appointmentId) {
        Appointment appointment = appointmentService.getAppointmentById(appointmentId);

        if (appointment != null) {
            Bill bill = new Bill();
            bill.setAppointment(appointment.getId().toString());
            bill.setPatient(appointment.getPatient_name());
            bill.setDoctor(appointment.getDoctor_name());

            // IMPORTANT: Amount null nahi hona chahiye
            bill.setAmount("500"); // Ya appointment.getFees() use karein

            service.saveBill(bill);
            System.out.println("Bill saved successfully for: " + appointment.getPatient_name());
        }
        return "redirect:/bill";
    }


  /*  // Delete bill
    @GetMapping("/delete/{id}")
    public String deleteBill(@PathVariable Long id) {
        service.deleteBillById(id);
        return "redirect:/bill/list";
    }*/
}
