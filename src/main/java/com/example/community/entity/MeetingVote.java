package com.example.community.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "MEETING_VOTE")
public class MeetingVote {
    @EmbeddedId
    private MeetingVoteId meetingVoteId;
    private String ename;
    private Timestamp fst_crt_dtti;
}
