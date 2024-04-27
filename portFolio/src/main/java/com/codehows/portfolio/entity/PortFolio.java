package com.codehows.portfolio.entity;

import com.codehows.portfolio.constant.Represent;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class PortFolio {
    //포트폴리오 게시물 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
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

    //대표 게시물인가
    /*@Enumerated(EnumType.STRING)*/
    @Column(name = "represent")
    private Boolean represent;
    //-----------------------------------------

    //생성 시각
    @CreatedDate
    @Column(name = "createTime")
    private LocalDateTime createTime;

    //수정 시각
    @LastModifiedDate
    @Column(name = "updateTime")
    private LocalDateTime updateTime;

    @Builder
    public PortFolio(String title, String portName, String phone, String portEmail, String summary, String mySkill, String projectIntro, Boolean represent) {
        this.title = title;
        this.portName = portName;
        this.phone = phone;
        this.portEmail = portEmail;
        this.summary = summary;
        this.mySkill = mySkill;
        this.projectIntro = projectIntro;
        this.represent = represent;
    }

    public void update(String title, String portName, String portEmail, String phone, String summary, String mySkill, String projectIntro, Boolean represent) {
        this.title = title;
        this.portName = portName;
        this.phone = phone;
        this.portEmail = portEmail;
        this.summary = summary;
        this.mySkill = mySkill;
        this.projectIntro = projectIntro;
        this.represent = represent;
    }
}
