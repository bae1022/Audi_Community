package com.example.community.controller;

import com.example.community.dto.RestaurantDto;
import com.example.community.entity.Restaurant;
import com.example.community.repository.RestaurantRepository;
import com.example.community.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audi")
public class RestaurantController {
    private RestaurantService restaurantService;
    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @PostMapping("/add")
    public void save(@RequestBody Restaurant restaurant) {
        restaurantService.registerRestaurant(restaurant);
    }

}
