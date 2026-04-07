package com.eventmanagement.eventmanagementsystem.payment.Controller;

import com.eventmanagement.eventmanagementsystem.payment.DTO.PaymentModelDTO;
import com.eventmanagement.eventmanagementsystem.payment.Model.PaymentModel;
import com.eventmanagement.eventmanagementsystem.payment.Service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;

    }
    //make payment
    @PostMapping
    public PaymentModel makePayment(@RequestBody PaymentModelDTO payment){
        return paymentService.makePayment(payment);
    }
    // Get All Payments
    @GetMapping
    public List<PaymentModel> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Get Payment By ID
    @GetMapping("/{id}")
    public PaymentModel getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    //  Delete Payment
    @DeleteMapping("/{id}")
    public PaymentModel deletePayment(@PathVariable Long id) {
        return paymentService.deletePayment(id);
    }
}
