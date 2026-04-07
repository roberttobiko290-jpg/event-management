package com.eventmanagement.eventmanagementsystem.booking.DTO;

import com.eventmanagement.eventmanagementsystem.booking.Model.BookingModel;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingModelDTO {
    private Long eventId;

    private int numberOfTicket;
    private Double totalPrice;

    private Long userId;
    private String username;
    private LocalDate date;

    public static BookingModelDTO map (BookingModel booking) {
        BookingModelDTO   bookingModelDTO = new   BookingModelDTO();

        bookingModelDTO.setNumberOfTicket(booking.getNumberOfTicket());

        bookingModelDTO.setTotalPrice(booking.getTotalPrice());
        bookingModelDTO.setUserId(booking.getUserId());
        bookingModelDTO.setEventId(booking.getEventId());
        bookingModelDTO.setDate(LocalDate.from(booking.getDate()));



                    return bookingModelDTO;
                }
}
