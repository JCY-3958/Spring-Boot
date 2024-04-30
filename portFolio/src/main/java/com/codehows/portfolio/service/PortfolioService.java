package com.codehows.portfolio.service;

import com.codehows.portfolio.dto.*;
import com.codehows.portfolio.entity.PortFolio;
import com.codehows.portfolio.entity.RepresentPortfolio;
import com.codehows.portfolio.repository.PortfolioRepository;
import com.codehows.portfolio.repository.RepresentPortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final RepresentPortfolioRepository representPortfolioRepository;

    //관리자가 포트폴리오 등록
    public PortFolio save(AddPortfolioRequest request) {
        return portfolioRepository.save(request.toEntity());
    }

    //관리자가 대표 포트폴리오 설정
    public RepresentPortfolio saveRepresent(AddRepresentPortfolioRequest request) {
        return representPortfolioRepository.save(request.toEntity());
    }

    /*//대표로 설정된 포트폴리오 가져오기
    public PortFolio findByRepresent(Boolean represent) {
        return portfolioRepository.findByRepresent(represent);
    }*/

    //포트폴리오 상세 정보 가져오기
    public PortFolio findById(long id) {
        return portfolioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }

    //등록된 포트폴리오 목록 가져오기(포트폴리오 관리)
    public List<PortFolio> findAll() {
        return portfolioRepository.findAll();
    }

    /*//대표 포트폴리오 설정
    @Transactional
    public PortFolio updateRepresent(Long id, UpdateRepresentRequest request) {
        PortFolio portFolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));

        portFolio.updateRepresent(request.getRepresent());

        return portFolio;
    }*/

    //포트폴리오 수정
    @Transactional
    public PortFolio update(Long id, NewPortfolioResponse request) {
        PortFolio portFolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));

        portFolio.update(request.getTitle(), request.getPortName(), request.getPortEmail(), request.getPhone(), request.getSummary(), request.getMySkill(), request.getProjectIntro());

        return portFolio;
    }

    //포트폴리오 삭제
    public void delete(Long id) {
        PortFolio portFolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));

        portfolioRepository.deleteById(id);
    }

}
