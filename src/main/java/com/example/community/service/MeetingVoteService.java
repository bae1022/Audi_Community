package com.example.community.service;

import com.example.community.entity.Meeting;
import com.example.community.entity.MeetingVote;
import com.example.community.repository.MeetingRepository;
import com.example.community.repository.MeetingVoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // 싱글톤 패턴 사용
public class MeetingVoteService {

    private final MeetingVoteRepository meetingVoteRepository;

    public List<MeetingVote> findByMeetingId(int meetingId) {
        return meetingVoteRepository.findByMeetingVoteId_MeetingId(meetingId);
    }
}
