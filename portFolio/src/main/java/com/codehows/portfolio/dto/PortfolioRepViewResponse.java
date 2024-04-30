package com.codehows.portfolio.dto;

import com.codehows.portfolio.entity.PortFolio;
import com.codehows.portfolio.entity.RepresentPortfolio;
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

    public PortfolioRepViewResponse(RepresentPortfolio representPortfolio) {
        this.id = representPortfolio.getId();
        this.title = representPortfolio.getTitle();
        this.portName = representPortfolio.getPortName();
        this.phone = representPortfolio.getPhone();
        this.portEmail = representPortfolio.getPortEmail();
        this.summary = representPortfolio.getSummary();
        this.mySkill = representPortfolio.getMySkill();
        this.projectIntro = representPortfolio.getProjectIntro();
    }

}
