package com.eventmanagement.eventmanagementsystem.notification.Service;

import com.eventmanagement.eventmanagementsystem.booking.Model.BookingModel;
import com.eventmanagement.eventmanagementsystem.notification.DTO.NotificationModelDTO;
import com.eventmanagement.eventmanagementsystem.notification.Exception.NotificationNotFoundException;
import com.eventmanagement.eventmanagementsystem.notification.Model.NotificationModel;
import com.eventmanagement.eventmanagementsystem.notification.Repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.eventmanagement.eventmanagementsystem.notification.DTO.NotificationModelDTO.map;

@Service
public class NotificationService {


    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    public List<NotificationModelDTO> getUserNotificationsByUserId(Long userId) {
        List<NotificationModel> notifications =
                notificationRepository.getUnreadNotificationsByUserId(userId);
        return notifications
                .stream()
                .filter(n -> n.getTitle() != null && n.getTitle().contains("Event"))
                .map(notification -> map(notification))
                .toList();}


    public List<NotificationModelDTO> getUnreadNotificationsById(Long userId) {

        return notificationRepository.getUnreadNotificationsByUserId(userId)
                .stream()
                .filter(notification ->!notification.isRead())
                .map(notification -> map(notification)
                ).toList();

                }


    public NotificationModelDTO markAsRead(Long id) {

        NotificationModel notification = notificationRepository.findAll()
                .stream()
                .filter(n -> n.getId().equals(id))
                .peek(n -> n.setRead(true))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Notification not found with id: " + id));



        notificationRepository.save(notification);


        return new NotificationModelDTO() {{

            setTitle(notification.getTitle());
            setMessage(notification.getMessage());
        }};
    }

    public NotificationModelDTO deleteNotification(Long id) {
        NotificationModel notification = notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException(
                        "Notification not found with id: " + id));

        notificationRepository.delete(notification);
        return map(notification);

    }
}

