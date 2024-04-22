package com.codehows.sbd.repository;

import com.codehows.sbd.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //optional은 데이터베이스 조회 결과를 저장함,
    //값이 존재할 수도 있고 하지 않을 수도 있는 경우를 다룰 때 사용
    //값이 없다면 null을 반환하는 대신 명시적으로 값이 없음을 표현
    Optional<User> findByEmail(String email); //email로 사용자 정보를 가져옴
}
