package com.codehows.portfolio.controller;

import com.codehows.portfolio.dto.AddPortfolioRequest;
import com.codehows.portfolio.entity.PortFolio;
import com.codehows.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PortfolioApiController {
    private final PortfolioService portfolioService;

    //포트폴리오 추가
    @PostMapping("/api/portfolio")
    public ResponseEntity<PortFolio> addPortfolio(@RequestBody AddPortfolioRequest request) {
        PortFolio savedPortfolio = portfolioService.save(request);
        //System.out.println("여기로 오냐?");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedPortfolio);
    }
}
