package com.codehows.portfolio.repository;

import com.codehows.portfolio.entity.PortFolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PortfolioRepository extends JpaRepository<PortFolio, Long> {
    Optional<PortFolio> findByRepresent(Boolean represent);
}
