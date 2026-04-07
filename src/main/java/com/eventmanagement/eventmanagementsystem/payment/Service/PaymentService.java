package com.eventmanagement.eventmanagementsystem.payment.Service;

import com.eventmanagement.eventmanagementsystem.payment.DTO.PaymentModelDTO;
import com.eventmanagement.eventmanagementsystem.payment.Exception.PaymentNotFoundException;
import com.eventmanagement.eventmanagementsystem.payment.Model.PaymentModel;
import com.eventmanagement.eventmanagementsystem.payment.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


//Make Payment
    public PaymentModel makePayment(PaymentModelDTO paymentModelDTO) {

        PaymentModel payment = PaymentModelDTO.map(paymentModelDTO);

        return paymentRepository.save(payment);
    }

    //  Get All Payments
    public List<PaymentModel> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get Payment By ID
    public PaymentModel getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(()
                ->new PaymentNotFoundException("payment not found"));
    }

    //  Delete Payment
    public PaymentModel deletePayment(Long id) {
        PaymentModel payment = paymentRepository.findById(id).orElse(null);
        if (payment != null) {
            paymentRepository.delete(payment);
            return payment;
        }
        return null;
    }
}