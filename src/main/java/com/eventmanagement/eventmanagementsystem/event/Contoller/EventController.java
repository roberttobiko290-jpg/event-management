package com.eventmanagement.eventmanagementsystem.event.Contoller;


import com.eventmanagement.eventmanagementsystem.event.DTO.EventModelDTO;
import com.eventmanagement.eventmanagementsystem.event.Model.EventModel;
import com.eventmanagement.eventmanagementsystem.event.Service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/events")

public class EventController {
   private final EventService eventService;

    public EventController(EventService eventService) {

        this.eventService = eventService;
    }
    //create an event
    @PostMapping("/all events")
    public EventModel createAllEvents(@RequestBody
                                          EventModelDTO event){
        return eventService.createAllEvents(event);
    }
//view the events
    @GetMapping("/event")
    public List<EventModelDTO> getAllEvents(){

        return eventService.getAllEvents();

    }
    //get event by a specific user
    @GetMapping("/{id}")
    public EventModelDTO getEventByUserId(@PathVariable Long id){
        return eventService.getEventByUserId(id);

    }

    @GetMapping("/date")
    public List<EventModelDTO> getEventsByDate(
            @RequestParam LocalDate date
            ){
        return eventService.getAllEventsByDate(date);
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<EventModelDTO> getEventById(@PathVariable Long id) {
//        EventModelDTO event = eventService.getEventById(id);
//        return ResponseEntity.ok(event);
//    }


    //update the events
    @PutMapping("/{id}")
   public EventModel updateEventsById(@PathVariable Long id,@RequestBody EventModelDTO eventModelDTO
          ){
        return eventService.updateEventsById(id , eventModelDTO);
    }

// delete the event
    @DeleteMapping("/{id}")
    public EventModel deleteEventById(@PathVariable Long id){
       return eventService.deleteEventById(id);
    }

}
