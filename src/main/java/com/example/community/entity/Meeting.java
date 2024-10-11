package com.example.community.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Builder
@SequenceGenerator(name = "meetings_seq_generator",
        sequenceName = "meetings_seq",
        initialValue = 5,
        allocationSize = 1 // 시퀀스 값을 1씩 증가
)
@Table(name = "MEETING")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "meetings_seq_generator")
    private int meetingId;
    @Column(name="restaurant_id")
    private int restaurantId;
    private String crym;
    @Column(name="unit_biz_code")
    private String unitBizCode;
    @Column(name="register_status")
    private String registerStatus;
    private String stdt;
    @Column(name="lun_din_div")
    private String lunDinDiv;
    @Column(name="restaurant_name")
    private String restaurantName;
    @Column(name="join_meeting_yn")
    private String joinMeetingYn;
    private String category;
    private String fst_crt_usid;
    private Timestamp fst_crt_dtti;
    private String lt_ch_usid;
    private Timestamp lt_ch_dtti;
}
