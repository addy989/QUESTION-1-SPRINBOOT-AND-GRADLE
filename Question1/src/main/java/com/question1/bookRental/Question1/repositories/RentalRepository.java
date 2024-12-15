package com.question1.bookRental.Question1.repositories;
import com.question1.bookRental.Question1.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Long> {


}
