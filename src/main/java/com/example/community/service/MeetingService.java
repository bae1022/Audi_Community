package com.example.community.service;

import com.example.community.entity.Meeting;
import com.example.community.entity.Restaurant;
import com.example.community.repository.MeetingRepository;
import com.example.community.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // 싱글톤 패턴 사용
public class MeetingService {

    private final MeetingRepository meetingRepository;

    public List<Meeting> findByCrymAndRegisterStatus(String crym, String register_status) {
        return meetingRepository.findByCrymAndRegisterStatus(crym, register_status);
    }

    public Meeting findByMeetingId(int meetingId) {
        return meetingRepository.findByMeetingId(meetingId);
    }

    public List<Meeting> findByCrymAndUnitBizCode(String crym, String unit_biz_code){
        return meetingRepository.findByCrymAndUnitBizCode(crym, unit_biz_code);
    }
}
