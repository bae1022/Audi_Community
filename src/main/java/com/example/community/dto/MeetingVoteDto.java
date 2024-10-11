package com.example.community.dto;

import com.example.community.entity.Meeting;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Getter
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
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
