package com.codehows.portfolio.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class RepresentPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //포트폴리오 제목
    @Column(name = "title", nullable = false)
    private String title;

    //포트폴리오 소유자 이름
    @Column(name = "portName")
    private String portName;

    //연락처
    @Column(name = "phone")
    private String phone;

    //메일 주소
    @Column(name = "portEmail")
    private String portEmail;

    //포트폴리오 한줄 소개
    @Column(name = "summary")
    private String summary;

    //나의 기술 스택
    @Column(name = "mySkill")
    private String mySkill;

    //나의 프로젝트 소개
    @Lob
    @Column(name = "projectIntro", nullable = false)
    private String projectIntro;

    @Builder
    public RepresentPortfolio(String title, String portName, String phone, String portEmail, String summary, String mySkill, String projectIntro) {
        this.title = title;
        this.portName = portName;
        this.phone = phone;
        this.portEmail = portEmail;
        this.summary = summary;
        this.mySkill = mySkill;
        this.projectIntro = projectIntro;
    }
}
