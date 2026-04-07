package com.eventmanagement.eventmanagementsystem.event.Model;

import com.eventmanagement.eventmanagementsystem.user.Model.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "event_model", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
        private String description;
        private String location;
        private LocalDate date;
        private Double price;

        @ManyToOne
        @JoinColumn
        private UserModel user;
        private String email;
    }

