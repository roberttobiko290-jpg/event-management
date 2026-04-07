package com.eventmanagement.eventmanagementsystem.payment.Repository;

import com.eventmanagement.eventmanagementsystem.payment.Model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel,Long > {
}
