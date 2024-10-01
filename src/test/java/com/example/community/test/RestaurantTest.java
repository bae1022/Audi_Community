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

import java.sql.Timestamp;
import java.util.List;

import static org.hibernate.boot.model.process.spi.MetadataBuildingProcess.build;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

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
    @DisplayName("read restaurants by loc data")
    void read_restaurants_by_loc() throws Exception {
        Long locX = Long.valueOf(24);
        Long locY = Long.valueOf(45);

        mockMvc.perform(get("/audi/list/loc")
                        .param("loc_x", locX.toString())
                        .param("loc_y", locY.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                       )
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("register restaurant")
    void make_restaurant() throws Exception {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        RestaurantDto restaurantDto = RestaurantDto.builder()
                .name("춘리")
                .address("광화문 어쩌구")
                .genre("점심")
                .locX(Long.valueOf(24))
                .locY(Long.valueOf(45))
                .description("새우 10마리 이상 넣어야함")
                .fst_crt_usid("LD10543")
                .lt_ch_usid("LD10543")
                .build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/audi/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(restaurantDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    // restaurant update
    @Test
    @DisplayName("update restaurant")
    void update_restaurant() throws Exception {

    }

    @Test
    @DisplayName("read a restaurant by id")
    void findRestaurantById() throws Exception {
        int restaurantId = 502;

        mockMvc.perform(get("/audi/{id}", restaurantId)  // ID를 PathVariable로 전달
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())  // 응답 상태가 200 OK 인지 확인
                .andDo(print());
    }

}
