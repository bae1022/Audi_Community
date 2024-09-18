package com.example.community.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SequenceGenerator(name = "restaurants_seq_generator",
        sequenceName = "restaurants_seq",
        initialValue = 1,
        allocationSize = 50 )
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "restaurants_seq_generator")
    private Long id;

    private String name;
    private String address;
    private String genre;
    private Long loc_x;
    private Long loc_y;
    private String description;
    private String register;
    private String fst_crt_usid;
    private String lt_ch_usid;
    private String lt_ch_dtti;

    @Builder Restaurant(String name){
        this.name = name;
    }
}
