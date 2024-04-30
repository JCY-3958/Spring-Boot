package com.codehows.portfolio.controller;

import com.codehows.portfolio.dto.AddPortfolioRequest;
import com.codehows.portfolio.dto.AddRepresentPortfolioRequest;
import com.codehows.portfolio.dto.NewPortfolioResponse;
import com.codehows.portfolio.entity.PortFolio;
import com.codehows.portfolio.entity.RepresentPortfolio;
import com.codehows.portfolio.service.PortfolioService;
import com.codehows.portfolio.service.RepresentPortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PortfolioApiController {
    private final PortfolioService portfolioService;
    private final RepresentPortfolioService representPortfolioService;

    //포트폴리오 추가
    @PostMapping("/api/portfolio")
    public ResponseEntity<PortFolio> addPortfolio(@RequestBody AddPortfolioRequest request) {
        PortFolio savedPortfolio = portfolioService.save(request);
        //System.out.println("여기로 오나?");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedPortfolio);
    }

    //포트폴리오 수정
    //등록과 수정은 NewPortfolioResponse로 같이
    @PutMapping("/api/portfolio/{id}")
    public ResponseEntity<PortFolio> updatePortfolio(@PathVariable Long id, @RequestBody NewPortfolioResponse request) {
        PortFolio updatedPortfolio = portfolioService.update(id, request);

        return ResponseEntity.ok(updatedPortfolio);
    }

    //포트폴리오 삭제
    @DeleteMapping("/api/portfolio/{id}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable Long id) {
        portfolioService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    //대표 포트폴리오 추가
    @PostMapping("/api2/portfolio/{id}")
    public ResponseEntity<RepresentPortfolio> addRepresentPortfolio(@PathVariable Long id) {
        representPortfolioService.delete();

        PortFolio portFolio = portfolioService.findById(id);
        AddRepresentPortfolioRequest representPortfolio = new AddRepresentPortfolioRequest(
                portFolio.getTitle(),
                portFolio.getPortName(),
                portFolio.getPhone(),
                portFolio.getPortEmail(),
                portFolio.getSummary(),
                portFolio.getMySkill(),
                portFolio.getProjectIntro()
        );

        RepresentPortfolio savedRepPortfolio = representPortfolioService.save(representPortfolio);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedRepPortfolio);
    }

}
