package com.question1.bookRental.Question1.service;

import com.question1.bookRental.Question1.NotificationType;
import com.question1.bookRental.Question1.entity.Notification;
import com.question1.bookRental.Question1.entity.User;
import com.question1.bookRental.Question1.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {
    @Autowired
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    // Create a notification for rental expiration reminder
    public void createRentalExpirationNotification(User user, String message) {
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage(message);
        notification.setScheduledAt(LocalDateTime.now().plusMinutes(5)); // Set to 5 minutes later for example
        notification.setIsSent(false);
        notification.setType(NotificationType.RENTAL_EXPIRATION);
        notificationRepository.save(notification);
    }

    public void createNewArrivalNotification(User user, String message) {
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage(message);
        notification.setScheduledAt(LocalDateTime.now().plusMinutes(1)); // Set to 1 minute later for example
        notification.setIsSent(false);
        notification.setType(NotificationType.NEW_ARRIVAL);
        notificationRepository.save(notification);
    }

    public void createNewRatingNotification(User user, String message) {
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage(message);
        notification.setScheduledAt(LocalDateTime.now().plusMinutes(1)); // Set to 1 minute later for example
        notification.setIsSent(false);
        notification.setType(NotificationType.NEW_RATING);
        notificationRepository.save(notification);
    }





}
