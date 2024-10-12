package com.example.community.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@Embeddable
public class MeetingVoteId implements Serializable {

    @Column(name="meeting_id")
    private int meetingId;

    @Column(name="eno")
    private String eno;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingVoteId that = (MeetingVoteId) o;
        return meetingId == that.meetingId && Objects.equals(eno, that.eno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meetingId, eno);
    }
}
