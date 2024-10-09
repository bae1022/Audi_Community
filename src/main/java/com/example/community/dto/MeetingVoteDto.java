package com.example.community.dto;

import com.example.community.entity.Meeting;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;

import java.sql.Timestamp;

public class MeetingVoteDto {

    private String eno;
    private int meetingId;
    private String ename;
    private Timestamp fst_crt_dtti;

    @Builder
    MeetingVoteDto (String eno
            , int meetingId
            , String ename
            , Timestamp fst_crt_dtti) {
        this.eno = eno;
        this.meetingId = meetingId;
        this.ename = ename;
        this.fst_crt_dtti = fst_crt_dtti;
    }
}
