package com.eventmanagement.eventmanagementsystem.booking.Service;


import com.eventmanagement.eventmanagementsystem.booking.DTO.BookingModelDTO;
import com.eventmanagement.eventmanagementsystem.booking.Exception.BookingNotFoundException;
import com.eventmanagement.eventmanagementsystem.booking.Model.BookingModel;
import com.eventmanagement.eventmanagementsystem.booking.Repository.BookingRepository;
import com.eventmanagement.eventmanagementsystem.user.Exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public BookingModel createBooking(BookingModelDTO bookingModelDTO) {
        BookingModel booking = new BookingModel();

        booking.setEventId(bookingModelDTO.getEventId());
        booking.setNumberOfTicket(bookingModelDTO.getNumberOfTicket());
        booking.setTotalPrice(bookingModelDTO.getTotalPrice());
        return bookingRepository.save(booking);
    }


    public List<BookingModelDTO> getAllBooking() {

            List<BookingModel> bookings = bookingRepository.findAll();
            return bookings.stream()
                    .map((booking) ->
                            BookingModelDTO.map( booking))
                    .toList();
        }



    public BookingModel getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + id));
    }

    public BookingModel updateBookingById(Long id, BookingModelDTO bookingModelDTO) {
        BookingModel booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {

            booking.setEventId(bookingModelDTO.getEventId());
            booking.setNumberOfTicket(bookingModelDTO.getNumberOfTicket());
            booking.setTotalPrice(bookingModelDTO.getTotalPrice());
            return bookingRepository.save(booking);
        }
        return null;

    }


    public BookingModel deleteBooking(Long id) {
        BookingModel booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            bookingRepository.delete(booking);
            return booking;
        }
        return null;
    }
}

