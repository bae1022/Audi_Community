package com.example.community.controller;

import com.example.community.dto.RestaurantDto;
import com.example.community.repository.RestaurantRepository;
import com.example.community.service.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/audi")
public class RestaurantController {
    private RestaurantService restaurantService;
    private RestaurantRepository restaurantRepository;

//    @GetMapping("/list")

}
