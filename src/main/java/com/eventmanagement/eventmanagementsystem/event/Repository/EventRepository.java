package com.eventmanagement.eventmanagementsystem.event.Repository;

import com.eventmanagement.eventmanagementsystem.event.Model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventModel, Long> {
    public List<EventModel> findByDate(LocalDate date);
}
