package com.example.community.dto;

import com.example.community.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantDto {
    private int id;
    private String name;
    private String address;
    private String genre;
    private Long locX;
    private Long locY;
    private String description;
    private String register;
    private String fst_crt_usid;
    private Timestamp fst_crt_dtti;
    private String lt_ch_usid;
    private Timestamp lt_ch_dtti;

    @Builder RestaurantDto(int id
            , String name
            , String address
            , String genre
            , Long locX
            , Long locY
            , String description
            , String fst_crt_usid
            , Timestamp fst_crt_dtti
            , String lt_ch_usid
            , Timestamp lt_ch_dtti){
        this.id = id;
        this.name = name;
        this.address = address;
        this.genre = genre;
        this.locX = locX;
        this.locY = locY;
        this.description = description;
        this.fst_crt_usid = fst_crt_usid;
        this.fst_crt_dtti = fst_crt_dtti;
        this.lt_ch_usid = lt_ch_usid;
        this.lt_ch_dtti = lt_ch_dtti;
    }
}


