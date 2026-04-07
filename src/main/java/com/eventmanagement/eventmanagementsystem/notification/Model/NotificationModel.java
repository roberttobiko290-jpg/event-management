package com.eventmanagement.eventmanagementsystem.notification.Model;

import com.eventmanagement.eventmanagementsystem.user.Model.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String title;
    private String message;

    private String type; // BOOKING, PAYMENT, REMINDER

    private boolean isRead = false;

    private LocalDateTime createdAt;

//    @ManyToOne
//    @JoinColumn
//    private UserModel user;
@ManyToOne
@JoinColumn(name = "user_id")
private UserModel user;
}

