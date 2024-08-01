package com.practise.new_user_details.repository;

import com.practise.new_user_details.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, String> {
}