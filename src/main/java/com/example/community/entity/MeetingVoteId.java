package com.example.community.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class MeetingVoteId implements Serializable {

    @Column(name="meeting_id")
    private int meetingId;

    @Column(name="eno")
    private String eno;
}
