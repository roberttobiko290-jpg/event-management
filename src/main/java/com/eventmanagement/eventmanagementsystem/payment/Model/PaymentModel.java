package com.eventmanagement.eventmanagementsystem.payment.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment_model", schema = "public")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;
    private Double amount;
    private String paymentMethod;
    private String status;
}
