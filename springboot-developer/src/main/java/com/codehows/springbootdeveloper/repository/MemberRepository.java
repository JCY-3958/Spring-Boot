package com.codehows.springbootdeveloper.repository;

import com.codehows.springbootdeveloper.DAO.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
