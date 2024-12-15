package com.question1.bookRental.Question1.repositories;

import com.question1.bookRental.Question1.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;


public interface ReviewRepository extends JpaRepository<Review,Long> {
}
