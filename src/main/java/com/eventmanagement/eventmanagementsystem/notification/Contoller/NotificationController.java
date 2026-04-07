package com.eventmanagement.eventmanagementsystem.notification.Contoller;

import com.eventmanagement.eventmanagementsystem.notification.DTO.NotificationModelDTO;
import com.eventmanagement.eventmanagementsystem.notification.Model.NotificationModel;
import com.eventmanagement.eventmanagementsystem.notification.Service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")

public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Get all notifications for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificationModelDTO>> getUserNotificationsByUserId(
            @PathVariable Long userId) {

        List<NotificationModelDTO> notifications = notificationService.getUserNotificationsByUserId(userId);

        return ResponseEntity.ok(notifications);
    }



    // Get unread notifications
  @GetMapping("/unread/{userId}")
    public ResponseEntity  <NotificationModel> getUnreadNotificationsById(
             @PathVariable Long userId ) {


      List<NotificationModelDTO> unreadNotifications =
              notificationService.getUnreadNotificationsById(userId);

      return ResponseEntity.ok((NotificationModel) unreadNotifications);
  }

    // Mark a notification as read
    @PutMapping("/{id}/read")
    public ResponseEntity<NotificationModelDTO> markAsRead(@PathVariable Long id) {
        NotificationModelDTO updateNotification = notificationService.markAsRead(id);

       return ResponseEntity.ok(updateNotification);
   }

   // Delete a notification
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteNotification(@PathVariable Long id) {
      NotificationModelDTO  deleteNotification=  notificationService.deleteNotification(id);

    return ResponseEntity.ok("Notification deleted");
   }
}

