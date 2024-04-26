package com.codehows.portfolio.dto;

import com.codehows.portfolio.entity.PortFolio;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class PortfolioRepViewResponse {
    private Long id;
    private String title;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public PortfolioRepViewResponse(PortFolio portFolio) {
        this.id = portFolio.getId();
        this.title = portFolio.getTitle();
        this.createTime = portFolio.getCreateTime();
        this.updateTime = portFolio.getUpdateTime();
    }

}
