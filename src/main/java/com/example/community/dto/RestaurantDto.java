package com.example.community.dto;

import com.example.community.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantDto {
    private Long id;
    private String name;
    private String address;
    private String genre;
    private long loc_x;
    private long loc_y;
    private String description;
    private String register;
    private String fst_crt_usid;
    private String lt_ch_usid;
    private String lt_ch_dtti;

//    @Builder
//    public RestaurantDto(Restaurant restaurant){
//        this.id = restaurant.getId();
//        this.name = restaurant.getName();
//        this.address = restaurant.getAddress();
//        this.genre = restaurant.getGenre();
//        this.loc_x = restaurant.getLoc_x();
//        this.loc_y = restaurant.getLoc_y();
//        this.description = restaurant.getDescription();
//        this.register = restaurant.getRegister();
//        this.fst_crt_usid = restaurant.getFst_crt_usid();
//        this.lt_ch_usid = restaurant.getLt_ch_usid();
//        this.lt_ch_dtti = restaurant.getLt_ch_dtti();
//    }
}
