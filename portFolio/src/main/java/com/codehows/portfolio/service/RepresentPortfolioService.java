package com.codehows.portfolio.service;

import com.codehows.portfolio.dto.AddRepresentPortfolioRequest;
import com.codehows.portfolio.entity.RepresentPortfolio;
import com.codehows.portfolio.repository.RepresentPortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepresentPortfolioService {
    private final RepresentPortfolioRepository representPortfolioRepository;

    public RepresentPortfolio save(AddRepresentPortfolioRequest request) {
        return representPortfolioRepository.save(request.toEntity());
    }

    public List<RepresentPortfolio> findAll() {
        return representPortfolioRepository.findAll();
    }

    public void delete() {
        representPortfolioRepository.deleteAll();
    }
}
