package com.shop.repository;

import com.shop.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository는 mapper의 역할을 하는 애, service가 실행시킨다.
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
}
