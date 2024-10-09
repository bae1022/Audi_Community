package com.example.community.service;

import com.example.community.dto.RestaurantDto;
import com.example.community.entity.Restaurant;
import com.example.community.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // 싱글톤 패턴 사용
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    // final 썼을 때 에러 안 나려면 @RequiredArgsConstructor

    public Restaurant getRestaurantById(int id){
        return restaurantRepository.findById(id);
    }
    public List<Restaurant> getRestaurantByLocXAndLocY(Long locX, Long locY) {
        return restaurantRepository.findByLocXAndLocY(locX, locY);
    }
    /*
        레스토랑 등록
        중복 등록 시 예외처리 등록 필요
     */
    @Transactional
    public void registerRestaurant(RestaurantDto restaurantDto){
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        restaurantRepository.save(Restaurant.builder()
                .name(restaurantDto.getName())
                .address(restaurantDto.getAddress())
                .genre(restaurantDto.getGenre())
                .locX(restaurantDto.getLocX())
                .locY(restaurantDto.getLocY())
                .description(restaurantDto.getDescription())
                .fst_crt_usid(restaurantDto.getFst_crt_usid())
                .fst_crt_dtti(currentTimestamp)
                .lt_ch_usid(restaurantDto.getLt_ch_usid())
                .lt_ch_dtti(currentTimestamp)
                .build()
        );
    }

    @Transactional
    public void updateRestaurant(RestaurantDto restaurantDto){
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        restaurantRepository.save(Restaurant.builder()
                .name(restaurantDto.getName())
                .address(restaurantDto.getAddress())
                .genre(restaurantDto.getGenre())
                .locX(restaurantDto.getLocX())
                .locY(restaurantDto.getLocY())
                .description(restaurantDto.getDescription())
                .lt_ch_usid(restaurantDto.getLt_ch_usid())
                .lt_ch_dtti(currentTimestamp)
                .build()
        );
    }



}
