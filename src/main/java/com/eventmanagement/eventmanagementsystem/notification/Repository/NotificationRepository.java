package com.eventmanagement.eventmanagementsystem.notification.Repository;

import com.eventmanagement.eventmanagementsystem.notification.Model.NotificationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<NotificationModel,Long> {
   public List<NotificationModel> getUnreadNotificationsByUserId(Long userId);
}
