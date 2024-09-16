package com.example.community.service;

import com.example.community.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // 싱글톤 패턴 사용
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    // final 썼을 때 에러 안 나려면 @RequiredArgsConstructor

//    @Transactional

}
