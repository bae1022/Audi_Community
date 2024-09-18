package com.example.community.test;

import com.example.community.dto.RestaurantDto;
import com.example.community.entity.Restaurant;
import com.example.community.repository.RestaurantRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@DataJpaTest
@AutoConfigureMockMvc
@SpringBootTest
public class RestaurantTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;
    @Autowired
    RestaurantRepository restaurantRepository;

    @BeforeEach
    void setUp() {
//        Restaurant restaurant = Restaurant.builder()
//                .name("우육면가당기당당")
//                .build();
//
//        restaurantRepository.save(restaurant);

        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    @DisplayName("임시 테스트")
    void test(){
        List<Restaurant> r = restaurantRepository.findAll();

        for (Restaurant restaurant : r) {
            System.out.println(restaurant.getName());
        }
    }

    @Test
    void make_restaurant() throws Exception {
        RestaurantDto restaurantDto = new RestaurantDto(Long.valueOf(1), "춘리", "광화문 어쩌구", "점심", 24, 55, "새우 꼬챙이로 계산 안 함", "배세현", "LD10543", "오늘", "오늘");

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/audi/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(restaurantDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
