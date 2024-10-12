package com.example.community.service;

import com.example.community.entity.Meeting;
import com.example.community.entity.MeetingVote;
import com.example.community.entity.MeetingVoteId;
import com.example.community.repository.MeetingRepository;
import com.example.community.repository.MeetingVoteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor // 싱글톤 패턴 사용
public class MeetingVoteService {

    private final MeetingVoteRepository meetingVoteRepository;

    public List<MeetingVote> findByMeetingId(int meetingId) {
        return meetingVoteRepository.findByMeetingVoteId_MeetingId(meetingId);
    }

    @Transactional
    public void saveMeetingVote(int meetingId, String eno, String ename) {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        MeetingVoteId meetingVoteId = new MeetingVoteId();
        meetingVoteId.setMeetingId(meetingId);
        meetingVoteId.setEno(eno);

        // 엔티티 생성 및 값 설정
        MeetingVote meetingVote = new MeetingVote();
        meetingVote.setMeetingVoteId(meetingVoteId);
        meetingVote.setEname(ename);
        meetingVote.setFst_crt_dtti(currentTimestamp);

        // 저장
        meetingVoteRepository.save(meetingVote);
    }

    @Transactional
    public void deleteMeetingVote(int meetingId, String eno) {
        MeetingVoteId meetingVoteId = new MeetingVoteId();
        meetingVoteId.setMeetingId(meetingId);
        meetingVoteId.setEno(eno);

        if (meetingVoteRepository.existsById(meetingVoteId)) {
            meetingVoteRepository.deleteByMeetingVoteId(meetingVoteId);
        } else {
            throw new IllegalArgumentException("MeetingVote not found for the given meetingId and eno.");
        }
    }
}
