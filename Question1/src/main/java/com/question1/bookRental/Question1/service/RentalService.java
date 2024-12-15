package com.question1.bookRental.Question1.service;

import com.question1.bookRental.Question1.NotificationType;
import com.question1.bookRental.Question1.entity.Notification;
import com.question1.bookRental.Question1.entity.Rental;
import com.question1.bookRental.Question1.entity.User;
import com.question1.bookRental.Question1.repositories.NotificationRepository;
import com.question1.bookRental.Question1.repositories.RentalRepository;
import com.question1.bookRental.Question1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository, NotificationRepository notificationRepository, UserRepository userRepository) {
        this.rentalRepository = rentalRepository;
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }
    public Rental rentBook(Rental rental) {
        rental.setStartDate(LocalDateTime.now());
        rental.setReturned(false);
        // Save the rental information to the repository
        Rental savedRental = rentalRepository.save(rental);
        // Create a notification for rental expiration
        createRentalNotification(savedRental);
        return savedRental;
    }

    public Rental extendRental(Long id, int extraDays) {
        Rental rental = rentalRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Rental not found")
        );
        rental.setEndDate(rental.getEndDate().plusDays(extraDays));
        return rentalRepository.save(rental);
    }

    public Rental returnBook(Long id) {
        Rental rental = rentalRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Rental not found")
        );
        rental.setReturned(true);
        return rentalRepository.save(rental);
    }

    private void createRentalNotification(Rental rental) {
        // Retrieve user who rented the book
        User user = rental.getUser();

        // Create a notification
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage("Your rental for the book will expire on " + rental.getEndDate() +
                ". Please return it on time.");
        notification.setScheduledAt(rental.getEndDate());  // Set the scheduled time of the notification
        notification.setIsSent(false);  // Initially, the notification is not sent
        notification.setType(NotificationType.RENTAL_EXPIRATION);  // Type of notification
        notificationRepository.save(notification);

        System.out.println("Rental created and notification scheduled for user: " + user.getUsername());
    }

}
