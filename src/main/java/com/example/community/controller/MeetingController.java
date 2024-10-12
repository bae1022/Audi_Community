package com.example.community.controller;

import com.example.community.dto.MeetingDto;
import com.example.community.dto.RestaurantDto;
import com.example.community.entity.Meeting;
import com.example.community.entity.Restaurant;
import com.example.community.repository.MeetingRepository;
import com.example.community.repository.RestaurantRepository;
import com.example.community.service.MeetingService;
import com.example.community.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MeetingController {

    @Autowired
    private final MeetingService meetingService;
    private MeetingRepository meetingRepository;

    @Autowired
    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("/meetings")
    @Operation(summary="캘린더1", description="전체 확정 간담회 리스트 조회")
    public List<Meeting> getConfirmedMeetings(@RequestParam("crym")String crym, @RequestParam String register_status) {
        List<Meeting> list_meeting = meetingService.findByCrymAndRegisterStatus(crym, register_status);

        return list_meeting;
    }

    @GetMapping("/meetings/{meetingId}")
    @Operation(summary="캘린더1-1", description="특정 간담회 상세 정보 조회")
    public Meeting getMeetingDetail(@PathVariable("meetingId")int meetingId){
        Meeting meeting = meetingService.findByMeetingId(meetingId);

        return meeting;
    }

    @GetMapping("/meetings2")
    @Operation(summary="캘린더2", description="특정 월 특정 업무 간담회 리스트")
    public List<Meeting> getUnitMeeting(@RequestParam("crym")String crym, @RequestParam("unitBiz")String unitBiz){
        List<Meeting> meetingList = meetingService.findByCrymAndUnitBizCode(crym, unitBiz);

        return meetingList;
    }

    @PostMapping("/meetings")
    @Operation(summary="캘린더4", description="간담회 후보 등록")
    public Meeting saveMeeting(@RequestBody MeetingDto meetingDto){
        Meeting meeting = meetingService.saveMeeting(meetingDto);

        return meeting;
    }

    @DeleteMapping("/meetings/{meetingId}")
    @Operation(summary="캘린더4-1", description="간담회 후보 삭제")
    public void deleteMeeting(@PathVariable("meetingId")int meetingId){
        // 현재 접속자가 등록자 or 단위업무관리자 일 경우에만 삭제 가능
        // 유저 ID를 받아오는 방법?
        meetingService.deleteMeeting(meetingId);
    }

}
