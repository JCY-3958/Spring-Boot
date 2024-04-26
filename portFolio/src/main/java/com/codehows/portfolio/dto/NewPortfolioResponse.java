package com.codehows.portfolio.dto;

import com.codehows.portfolio.entity.PortFolio;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class NewPortfolioResponse {
    private Long id;
    private String title;
    private String portName;
    private String phone;
    private String portEmail;
    private String summary;
    private String mySkill;
    private String projectIntro;

    public NewPortfolioResponse(PortFolio portFolio) {
        this.id = portFolio.getId();
        this.title = portFolio.getTitle();
        this.portName = portFolio.getPortName();
        this.phone = portFolio.getPhone();
        this.portEmail = portFolio.getPortEmail();
        this.summary = portFolio.getSummary();
        this.mySkill = portFolio.getMySkill();
        this.projectIntro = portFolio.getProjectIntro();
    }
}
