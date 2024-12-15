package com.question1.bookRental.Question1.controller;
import com.question1.bookRental.Question1.entity.Rental;
import com.question1.bookRental.Question1.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    @Autowired
    private RentalService rentalService;

//    public RentalController(RentalService rentalService) {
//        this.rentalService = rentalService;
//    }

    @PostMapping
    public Rental rentBook(@RequestBody Rental rental) {
        return rentalService.rentBook(rental);
    }

    @PutMapping("/extend/{id}")
    public Rental extendRental(@PathVariable Long id, @RequestParam int extraDays) {
        return rentalService.extendRental(id, extraDays);
    }

    @PutMapping("/return/{id}")
    public Rental returnBook(@PathVariable Long id) {
        return rentalService.returnBook(id);
    }



}
