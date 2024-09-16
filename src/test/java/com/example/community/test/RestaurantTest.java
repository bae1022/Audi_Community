package com.example.community.test;

import com.example.community.entity.Restaurant;
import com.example.community.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class RestaurantTest {

    @Autowired
    RestaurantRepository restaurantRepository;

    @BeforeEach
    void setUp() {
        Restaurant restaurant = Restaurant.builder()
                .name("우육면")
                .build();

        restaurantRepository.save(restaurant);
    }

    @Test
    @DisplayName("임시 테스트")
    void test(){
        List<Restaurant> r = restaurantRepository.findAll();

        for (Restaurant restaurant : r) {
            System.out.println(restaurant.getName());
        }
    }
}
