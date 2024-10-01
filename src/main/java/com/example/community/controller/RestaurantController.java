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
    @Autowired
    private final RestaurantService restaurantService;
    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // 레스토랑 Id 조회
    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable("id")int id) {
        Restaurant result = restaurantService.getRestaurantById(id);

        return result;
    }

    // 지도에서 좌표 찍어서 조회
    @GetMapping("/list/loc")
    public List<Restaurant> getRestaurantList(@RequestParam("loc_x")Long locX,
                                  @RequestParam("loc_y")Long locY) {
        List<Restaurant> result =  restaurantService.getRestaurantByLocXAndLocY(locX, locY);

        return result;
    }

    // 레스토랑 저장
    @PostMapping("/add")
    public void save(@RequestBody RestaurantDto restaurant) {
        restaurantService.registerRestaurant(restaurant);
    }

    // 레스토랑 수정
    @PostMapping("/update")
    public void updateRestaurant(@PathVariable("id")int id,
                                 @RequestBody RestaurantDto restaurantDto) {

    }

    // 레스토랑 삭제


}
