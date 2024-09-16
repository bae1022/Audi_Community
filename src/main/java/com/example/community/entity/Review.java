package com.example.community.entity;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "REVIEW")
public class Review {
    private String id; // 식당 id
    private String div; // 점심 저녁 구분
    private String rating; // 평점
    private String detail; // 리뷰 내용
}
