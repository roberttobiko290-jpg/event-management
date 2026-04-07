package com.eventmanagement.eventmanagementsystem.booking.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking_model", schema = "public")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;

    private int numberOfTicket;
    private Double totalPrice;
    private LocalDateTime date;
    private Long userId;




}
