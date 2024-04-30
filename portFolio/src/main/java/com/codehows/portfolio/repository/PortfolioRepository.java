package com.codehows.portfolio.repository;

import com.codehows.portfolio.dto.ManageViewResponse;
import com.codehows.portfolio.entity.PortFolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<PortFolio, Long> {

}
