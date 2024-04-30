package com.codehows.portfolio.controller;

import com.codehows.portfolio.dto.ManageViewResponse;
import com.codehows.portfolio.dto.NewPortfolioResponse;
import com.codehows.portfolio.dto.PortfolioRepViewResponse;
import com.codehows.portfolio.entity.PortFolio;
import com.codehows.portfolio.entity.RepresentPortfolio;
import com.codehows.portfolio.service.PortfolioService;
import com.codehows.portfolio.service.RepresentPortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PortfolioViewController {
    private final PortfolioService portfolioService;
    private final RepresentPortfolioService representPortfolioService;

    //메인 페이지(대표 포트폴리오) 띄우기
    @GetMapping("/portfolio")
    public String getRepresentPortfolio(Model model) {
        List<PortfolioRepViewResponse> representPortfolio = representPortfolioService.findAll()
                .stream()
                .map(PortfolioRepViewResponse::new)
                .toList();

        model.addAttribute("repPortfolio", representPortfolio);
        return "Main";
    }

    //포트폴리오 상세 페이지 띄우기
    @GetMapping("/portfolio/{id}")
    public String getDetailPortfolio(@PathVariable Long id, Model model) {
        PortFolio portFolio = portfolioService.findById(id);

        model.addAttribute("portfolio", portFolio);

        return "PortfolioView";
    }

    //포트폴리오 글 등록 페이지 띄우기
    @GetMapping("/portfolio/new")
    public String newPortfolio(Model model) {
        model.addAttribute("portfolio", new NewPortfolioResponse());

        return "NewPortfolio";
    }

    //포트폴리오 관리 페이지 띄우기
    @GetMapping("/portfolio/ManagePortfolio")
    public String managePortfolio(Model model) {
        List<ManageViewResponse> portFolios = portfolioService.findAll()
                .stream()
                .map(ManageViewResponse::new)
                .toList();

        model.addAttribute("portfolios", portFolios);
        return "ManagePortfolio";
    }

    //포트폴리오 수정 페이지 띄우기
    @GetMapping("/portfolio/modify")
    public String modifyPortfolio(@RequestParam(required = false) Long id, Model model) {
        PortFolio portFolio = portfolioService.findById(id);
        model.addAttribute("portfolio", portFolio);

        return "ModifyPortfolio";
    }
}
