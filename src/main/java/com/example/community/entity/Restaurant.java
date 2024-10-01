package com.example.community.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
@SequenceGenerator(name = "restaurants_seq_generator",
        sequenceName = "restaurants_seq",
        initialValue = 1)
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "restaurants_seq_generator")
    private int id;
    private String name;
    private String address;
    private String genre;
    @Column(name = "loc_x")
    private Long locX;
    @Column(name = "loc_y")
    private Long locY;
    private String description;
    private String fst_crt_usid;
    private Timestamp fst_crt_dtti;
    private String lt_ch_usid;
    private Timestamp lt_ch_dtti;

    @Builder Restaurant(int id
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
