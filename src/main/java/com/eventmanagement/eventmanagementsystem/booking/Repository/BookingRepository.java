package com.eventmanagement.eventmanagementsystem.booking.Repository;


import com.eventmanagement.eventmanagementsystem.booking.Model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel,Long> {
}
