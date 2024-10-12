package com.example.community.controller;

import com.example.community.entity.Meeting;
import com.example.community.entity.MeetingVote;
import com.example.community.repository.MeetingRepository;
import com.example.community.repository.MeetingVoteRepository;
import com.example.community.service.MeetingService;
import com.example.community.service.MeetingVoteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MeetingVoteController {

    @Autowired
    private final MeetingVoteService meetingVoteService;
    private MeetingVoteRepository meetingVoteRepository;

    @Autowired
    public MeetingVoteController(MeetingVoteService meetingVoteService) {
        this.meetingVoteService = meetingVoteService;
    }

    @GetMapping("/meetings/{meetingId}/votes")
    @Operation(summary="캘린더3-2", description="간담회 후보에 투표한 사람들")
    public List<MeetingVote> getConfirmedMeetings(@PathVariable("meetingId")int meetingId) {
        List<MeetingVote> meetingVoteList = meetingVoteService.findByMeetingId(meetingId);

        return meetingVoteList;
    }

    @PostMapping("/meetings/{meetingId}/votes")
    @Operation(summary="캘린더5", description="간담회 투표하기")
    public ResponseEntity<String> saveMeetingVote(@PathVariable("meetingId")int meetingId) {
        // eno, ename 하드코딩 / 어떻게 받아올지 여부 정하고 수정
        String eno = "LD10490";
        String ename = "전승환";

        // 이미 같은 MeetingId에 투표한 이력이 있는지 select 필요 (추가)

        meetingVoteService.saveMeetingVote(meetingId, eno, ename);

        return ResponseEntity.ok("Meeting vote saved successfully");
    }

    @DeleteMapping("/meetings/{meetingId}/votes")
    @Operation(summary="캘린더5-1", description="간담회 투표 취소")
    public ResponseEntity<String>  deleteMeetingVote(@PathVariable("meetingId") int meetingId) {
        //단, 현재 접속자가 등록자 or 단위업무관리자 일 경우에만 삭제 가능 (추가 예정)
        // 유저 id를 받아오는 방법?
        String eno = "LD10490";

        meetingVoteService.deleteMeetingVote(meetingId, eno);
        return ResponseEntity.ok("Meeting vote deleted successfully");
    }



}
