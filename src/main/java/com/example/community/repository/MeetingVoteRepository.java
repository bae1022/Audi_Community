package com.example.community.repository;

import com.example.community.entity.Meeting;
import com.example.community.entity.MeetingVote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingVoteRepository extends JpaRepository<MeetingVote, Long> {

    List<MeetingVote> findByMeetingId(int meetingId);
}
