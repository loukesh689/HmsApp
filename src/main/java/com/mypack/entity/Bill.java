package com.mypack.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bill")

public class Bill {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long Bill_id;
    String amount;
    String Appointment;
    String Patient;
    String Doctor;

}
