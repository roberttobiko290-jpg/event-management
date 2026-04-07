package com.eventmanagement.eventmanagementsystem.event.DTO;

import com.eventmanagement.eventmanagementsystem.event.Model.EventModel;
import lombok.Data;

import java.time.LocalDate;
@Data
public class EventModelDTO {
    private String title;
    private String location;
    private LocalDate date;
    private Double price;
    private String description;

    private Long userId;
    private String username;
    private String email;// aggregate

    public static EventModelDTO map( EventModel event){
        EventModelDTO eventModelDTO = new EventModelDTO();

        eventModelDTO.setTitle(event.getTitle());
        eventModelDTO.setLocation(event.getLocation());
        eventModelDTO.setPrice(event.getPrice());
        eventModelDTO.setDate(event.getDate());
        eventModelDTO.setDescription(event.getDescription());
        if(event.getUser() != null){
//            eventModelDTO.setUsername(event.getUser().getName());
            eventModelDTO.setUserId(event.getUser().getId());
            eventModelDTO.setDate(event.getDate());
            eventModelDTO.setEmail(event.getEmail());
            eventModelDTO.setDescription(event.getDescription());
        }
        return eventModelDTO;
    }

}

