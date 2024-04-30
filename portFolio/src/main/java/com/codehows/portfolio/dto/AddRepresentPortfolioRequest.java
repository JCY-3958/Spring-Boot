package com.codehows.portfolio.dto;

import com.codehows.portfolio.entity.RepresentPortfolio;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddRepresentPortfolioRequest {
    private String title;
    private String portName;
    private String phone;
    private String portEmail;
    private String summary;
    private String mySkill;
    private String projectIntro;

    public RepresentPortfolio toEntity() {
        return RepresentPortfolio.builder()
                .title(title)
                .portName(portName)
                .phone(phone)
                .portEmail(portEmail)
                .summary(summary)
                .mySkill(mySkill)
                .projectIntro(projectIntro)
                .build();
    }

}
