package com.example.community.controller;

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
    @Operation(summary="캘린더 1", description="해당 기준년월 간담회 확정 리스트 전달")
    public List<Meeting> getConfirmedMeetings(@RequestParam("crym")String crym, @RequestParam String register_status) {
        List<Meeting> list_meeting = meetingService.findByDateAndRegisterStatus(crym, register_status);

        return list_meeting;
    }

}
