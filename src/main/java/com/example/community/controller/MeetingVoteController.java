package com.example.community.controller;

import com.example.community.entity.Meeting;
import com.example.community.entity.MeetingVote;
import com.example.community.repository.MeetingRepository;
import com.example.community.repository.MeetingVoteRepository;
import com.example.community.service.MeetingService;
import com.example.community.service.MeetingVoteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
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
    public MeetingVote saveMeetingVote(@PathVariable("meetingId")int meetingId) {
        MeetingVote m = null;

        return m;
    }

    @DeleteMapping("/meetings/{meetingId}/votes")
    @Operation(summary="캘린더5-1", description="간담회 투표 취소")
    public void deleteMeetingVote(@PathVariable("meetingId") int meetingId) {
        //단, 현재 접속자가 등록자 or 단위업무관리자 일 경우에만 삭제 가능 (추가 예정)
        // 유저 id를 받아오는 방법?

        // return redirect? 임시로 void 처리
    }



}
