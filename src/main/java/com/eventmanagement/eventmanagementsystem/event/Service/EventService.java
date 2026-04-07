package com.eventmanagement.eventmanagementsystem.event.Service;

import com.eventmanagement.eventmanagementsystem.event.DTO.EventModelDTO;
import com.eventmanagement.eventmanagementsystem.event.Exception.EventNotFoundException;
import com.eventmanagement.eventmanagementsystem.event.Model.EventModel;
import com.eventmanagement.eventmanagementsystem.event.Repository.EventRepository;

import com.eventmanagement.eventmanagementsystem.user.Model.UserModel;
import com.eventmanagement.eventmanagementsystem.user.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public  List<EventModelDTO> getAllEvents() {

        return eventRepository.findAll()

                .stream()
                .map((event) -> EventModelDTO.map(event))
                .toList();
    }

    public EventModel createAllEvents(EventModelDTO eventModelDTO){
        EventModel event = new EventModel();
        event.setTitle(eventModelDTO.getTitle());
        event.setLocation(eventModelDTO.getLocation());
        event.setPrice(eventModelDTO.getPrice());

        if(eventModelDTO.getUserId() != null){
            UserModel user = userRepository.findById(eventModelDTO.getUserId()).orElse(null);

            if(user != null){
                event.setUser(user);
            }
        }

        return eventRepository.save(event);
    }

    public EventModel updateEventsById(Long id, EventModelDTO eventModelDTO) {
        EventModel event = eventRepository.findById(id).orElse(null);
        if (event != null) {

            event.setTitle(eventModelDTO.getTitle());
            event.setLocation(eventModelDTO.getLocation());
            event.setPrice(eventModelDTO.getPrice());
            event.setDescription(eventModelDTO.getDescription());

            if(eventModelDTO.getUserId() != null){
                UserModel user = userRepository.findById(eventModelDTO.getUserId()).orElse(null);

                if(user != null){
                    event.setUser(user);
                }
            }

            return eventRepository.save(event);

        }
        return null;
    }

    public EventModel deleteEventById(Long id) {
        EventModel event = eventRepository.findById(id).orElse(null);
        if(event != null){
            eventRepository.delete(event);
            return event;

    }
        return  null;
     }

    public EventModelDTO getEventByUserId(Long id) {
        EventModel event = eventRepository.findById(id).orElseThrow(()
                -> new EventNotFoundException("Event not found with id: " + id));
      if(event != null){
          return EventModelDTO.map(event);
      }
        return null;
    }

    public List<EventModelDTO> getAllEventsByDate(LocalDate date){
        if(date != null){
            List<EventModel> events = eventRepository.findByDate(date);
            return events.stream()
                    .map((event) -> EventModelDTO.map(event))
                    .toList();
        }

        return null;
    }
//    public EventModelDTO getEventById(Long id) {
//        EventModel event = eventRepository.findById(id)
//                .orElseThrow(() -> new EventNotFoundException("Event not found with id: " + id));
//        return EventModelDTO.map(event);
//    }
    }
