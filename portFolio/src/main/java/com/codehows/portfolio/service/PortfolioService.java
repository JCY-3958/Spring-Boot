package com.codehows.portfolio.service;

import com.codehows.portfolio.dto.AddPortfolioRequest;
import com.codehows.portfolio.dto.ManageViewResponse;
import com.codehows.portfolio.entity.PortFolio;
import com.codehows.portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    //관리자가 포트폴리오 등록
    public PortFolio save(AddPortfolioRequest request) {
        return portfolioRepository.save(request.toEntity());
    }

    //대표로 설정된 포트폴리오 가져오기
    public PortFolio findByRepresent(Boolean represent) {
        return portfolioRepository.findByRepresent(represent);
    }

    //포트폴리오 상세 정보 가져오기
    public PortFolio findById(long id) {
        return portfolioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }

    //등록된 포트폴리오 목록 가져오기(포트폴리오 관리)
    public List<PortFolio> findAll() {
        return portfolioRepository.findAll();
    }

}
