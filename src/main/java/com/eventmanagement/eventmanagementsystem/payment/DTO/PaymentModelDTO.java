package com.eventmanagement.eventmanagementsystem.payment.DTO;

import com.eventmanagement.eventmanagementsystem.payment.Model.PaymentModel;
import lombok.Data;

@Data
public class PaymentModelDTO {
    private Long bookingId;
    private Double amount;
    private String paymentMethod;
    private String status;


        public static PaymentModel map(PaymentModelDTO dto) {

            PaymentModel payment = new PaymentModel();

            payment.setBookingId(dto.getBookingId());
            payment.setAmount(dto.getAmount());
            payment.setPaymentMethod(dto.getPaymentMethod());
            payment.setStatus(dto.getStatus());

            return payment;
        }
    }



