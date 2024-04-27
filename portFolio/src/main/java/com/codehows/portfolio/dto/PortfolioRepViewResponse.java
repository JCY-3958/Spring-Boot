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
    private String portName;
    private String phone;
    private String portEmail;
    private String summary;
    private String mySkill;
    private String projectIntro;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public PortfolioRepViewResponse(PortFolio portFolio) {
        this.id = portFolio.getId();
        this.title = portFolio.getTitle();
        this.portName = portFolio.getPortName();
        this.phone = portFolio.getPhone();
        this.portEmail = portFolio.getPortEmail();
        this.summary = portFolio.getSummary();
        this.mySkill = portFolio.getMySkill();
        this.projectIntro = portFolio.getProjectIntro();
        this.createTime = portFolio.getCreateTime();
        this.updateTime = portFolio.getUpdateTime();
    }

}
