package com.eventmanagement.eventmanagementsystem.booking.Contoller;


import com.eventmanagement.eventmanagementsystem.booking.DTO.BookingModelDTO;
import com.eventmanagement.eventmanagementsystem.booking.Model.BookingModel;
import com.eventmanagement.eventmanagementsystem.booking.Service.BookingService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")




public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    //createBooking
    @PostMapping
    public BookingModel createBooking(@RequestBody BookingModelDTO bookingModelDTO){
        return bookingService.createBooking(bookingModelDTO);
    }
    //get all booking
    @GetMapping
    public List<BookingModelDTO> getAllBooking(){
        return bookingService.getAllBooking();


        }
        //get booking by id
        @GetMapping("/{id}")
     public BookingModel getBookingById(@PathVariable Long id) {
            return bookingService.getBookingById(id);
        }

        // Update Booking
        @PutMapping("/{id}")
        public BookingModel updateBooking(
                @PathVariable Long id, @RequestBody BookingModelDTO bookingModeDTO) {
            return bookingService.updateBookingById(id, bookingModeDTO);
        }

        // Delete Booking
        @DeleteMapping("/{id}")
        public BookingModel deleteBooking(@PathVariable Long id) {
            return bookingService.deleteBooking(id);
        }

    }

