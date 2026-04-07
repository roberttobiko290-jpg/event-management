package com.eventmanagement.eventmanagementsystem.user.Model;

import com.eventmanagement.eventmanagementsystem.event.Model.EventModel;
import com.eventmanagement.eventmanagementsystem.notification.Model.NotificationModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user_model", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  String email;
    private  Integer password;

    @OneToMany
    private List<EventModel> events;
    @OneToMany(mappedBy = "user")
    private List<NotificationModel> notifications;
}
