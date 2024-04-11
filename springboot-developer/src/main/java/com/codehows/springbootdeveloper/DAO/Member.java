package com.codehows.springbootdeveloper.DAO;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자, public class Member();
@AllArgsConstructor //모든 필드 값을 이용해서 생성자를 생성 , public class Member(Long id, Stirng name);
@Getter //객체의 필드 값을 가져올 때
@Entity //DB연결과 테이블 생성
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id; //DB 테이블의 id 컬럼과 매칭

    @Column(name = "name", nullable = false)
    private String name; //DB 테이블의 name 컬럼과 매칭
}
