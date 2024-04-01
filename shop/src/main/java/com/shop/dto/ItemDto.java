package com.shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

//데이터 전송 객체, List나 여러 형태의 객체를 view로 전달하는 것
@Getter
@Setter
public class ItemDto {
    private Long id;

    private String itemNm;

    private Integer price;

    private String itemDetail;

    private String sellStatCd;

    private LocalDateTime regTime;

    private LocalDateTime updateTime;
}
