/*/package com.mypack.service;

import com.mypack.entity.Bill;
import com.mypack.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    BillService billService;
    public void sendBillEmail(String toEmail, Bill bill) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Hospital Bill - ID: " + bill.getBill_id());

        // Aapki entity ke fields direct use honge
        String content = String.format(
                "Dear %s,\n\n" +
                        "Your appointment details are as follows:\n" +
                        "Doctor: %s\n" +
                        "Date: %s\n" +
                        "Total Amount: ₹%s\n\n" +
                        "Thank you for visiting! Stay Healthy.",
                bill.getPatient(),      // Ye aapka Patient String hai
                bill.getDoctor(),       // Ye aapka Doctor String hai
                bill.getAppointment(),  // Ye aapka Appointment String hai
                bill.getAmount()        // Ye aapka Amount String hai
        );

        message.setText(content);

        try {
            mailSender.send(message);
        } catch (Exception e) {
            // Log error
            System.out.println("Error sending email: " + e.getMessage());
        }
    }
}*/
