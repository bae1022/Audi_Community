package com.example.community.test;

import com.example.community.dto.MeetingDto;
import com.example.community.dto.RestaurantDto;
import com.example.community.entity.Meeting;
import com.example.community.repository.MeetingRepository;
import com.example.community.repository.RestaurantRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Timestamp;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class MeetingTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;
    @Autowired
    MeetingRepository meetingRepository;

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
    @DisplayName("register meeting")
    void make_restaurant() throws Exception {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        Meeting m = Meeting.builder()
                .crym("202410")
                .unitBizCode("02")
                .registerStatus("1")
                .stdt("20241010")
                .lunDinDiv("1")
                .restaurantName("새우새우")
                .joinMeetingYn("0")
                .category("3")
                .fst_crt_usid("LD10543")
                .lt_ch_usid("LD10543")
                .build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/meetings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(m)))
                .andExpect(status().isOk())
                .andDo(print());
    }


}
