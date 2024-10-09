package com.example.community.service;

import com.example.community.dto.MeetingDto;
import com.example.community.entity.Meeting;
import com.example.community.entity.Restaurant;
import com.example.community.repository.MeetingRepository;
import com.example.community.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

//    @Transactional
//    public void saveMeeting(MeetingDto meetingDto){
//        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
//
//       meetingRepository.save(MeetingDto.builder()
//                .crym(meetingDto.getCrym())
//                .unitBizCode(meetingDto.getUnitBizCode())
//                .registerStatus(meetingDto.getRegisterStatus())
//                .stdt(meetingDto.getStdt())
//                .lunDinDiv(meetingDto.getLunDinDiv())
//                .restaurantName(meetingDto.getRestaurantName())
//                .joinMeetingYn(meetingDto.getJoinMeetingYn())
//                .category(meetingDto.getCategory())
//                .fst_crt_usid(meetingDto.getFst_crt_usid())
//                .fst_crt_dtti(currentTimestamp)
//                .lt_ch_usid(meetingDto.getLt_ch_usid())
//                .lt_ch_dtti(currentTimestamp)
//                .build()
//        );
//    }
}
