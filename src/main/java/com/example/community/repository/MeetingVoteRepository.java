package com.example.community.repository;

import com.example.community.entity.Meeting;
import com.example.community.entity.MeetingVote;
import com.example.community.entity.MeetingVoteId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingVoteRepository extends JpaRepository<MeetingVote, MeetingVoteId> {

    List<MeetingVote> findByMeetingVoteId_MeetingId(int meetingId);

    void deleteByMeetingVoteId_MeetingId(int meetingId);

    void deleteByMeetingVoteId(MeetingVoteId m);
}
