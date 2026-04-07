package com.eventmanagement.eventmanagementsystem.notification.DTO;

import com.eventmanagement.eventmanagementsystem.notification.Model.NotificationModel;
import lombok.Data;

@Data
public class NotificationModelDTO {
    private Long userId;

    private String title;
    private String message;
    private Boolean isRead;


    private Long user;
    private String username;

    public static NotificationModelDTO map (NotificationModel notification){

        NotificationModelDTO dto = new NotificationModelDTO();

        dto.setTitle(notification.getTitle());
        dto.setMessage(notification.getMessage());
        dto.setIsRead(notification.isRead());


        return dto;
    }

}
