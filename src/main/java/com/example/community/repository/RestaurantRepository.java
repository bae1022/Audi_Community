package com.example.community.repository;

import com.example.community.dto.RestaurantDto;
import com.example.community.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByLocXAndLocY(Long locX, Long locY);

    Restaurant findById(int id);
}
