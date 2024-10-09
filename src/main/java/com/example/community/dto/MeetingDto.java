package com.example.community.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingDto {

    private int meetingId;
    private int restaurantId;
    private String crym;
    private String unitBizCode;
    private String registerStatus;
    private String stdt;
    private String lunDinDiv;
    private String restaurantName;
    private String joinMeetingYn;
    private String category;
    private String fst_crt_usid;
    private Timestamp fst_crt_dtti;
    private String lt_ch_usid;
    private Timestamp lt_ch_dtti;

    @Builder
    MeetingDto (
                 String crym
                , String unitBizCode
                , String registerStatus
                , String stdt
                , String lunDinDiv
                , String restaurantName
                , String joinMeetingYn
                , String category
                , String fst_crt_usid
                , Timestamp fst_crt_dtti
                , String lt_ch_usid
                , Timestamp lt_ch_dtti){
        this.crym = crym;
        this.unitBizCode = unitBizCode;
        this.registerStatus = registerStatus;
        this.stdt = stdt;
        this.lunDinDiv = lunDinDiv;
        this.restaurantName = restaurantName;
        this.joinMeetingYn = joinMeetingYn;
        this.category = category;
        this.fst_crt_usid = fst_crt_usid;
        this.fst_crt_dtti = fst_crt_dtti;
        this.lt_ch_usid = lt_ch_usid;
        this.lt_ch_dtti = lt_ch_dtti;
    }
}
