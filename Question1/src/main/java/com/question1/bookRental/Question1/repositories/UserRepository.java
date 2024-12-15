package com.question1.bookRental.Question1.repositories;

import com.question1.bookRental.Question1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
