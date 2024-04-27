package com.codehows.portfolio.controller;

import com.codehows.portfolio.dto.ManageViewResponse;
import com.codehows.portfolio.dto.NewPortfolioResponse;
import com.codehows.portfolio.entity.PortFolio;
import com.codehows.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PortfolioViewController {
    private final PortfolioService portfolioService;

    //메인 페이지(대표 포트폴리오) 띄우기
    @GetMapping("/portfolio")
    public String getPortfolio(Model model) {
        PortFolio representPortfolio = portfolioService.findByRepresent(true);

        /*PortfolioRepViewResponse representPortfolio =new PortfolioRepViewResponse();

        representPortfolio.setId(portfolioService.findByRepresent(true).getId());
        representPortfolio.setTitle(portfolioService.findByRepresent(true).getTitle());
        representPortfolio.setCreateTime(portfolioService.findByRepresent(true).getCreateTime());
        representPortfolio.setUpdateTime(portfolioService.findByRepresent(true).getUpdateTime());*/


        //System.out.println("앙기모띠:" + representPortfolio.getTitle());
        if(representPortfolio != null) {
            model.addAttribute("portfolio", representPortfolio);
            return "Main";
        } else {
            return "FirstMain";
        }


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
}
