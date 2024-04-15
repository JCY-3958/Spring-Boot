package com.codehows.sbd.repository;

import com.codehows.sbd.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

//제네릭 안은 엔티티 이름, 엔티티의 기본키의 타입
public interface BlogRepository extends JpaRepository<Article, Long> {
}
