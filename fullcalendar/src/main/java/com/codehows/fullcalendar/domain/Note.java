package com.codehows.fullcalendar.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "start")
    private LocalDate start;

    /*@CreatedDate
    @Column(name = "start")
    //달력에 띄울 때 start 값이 yyyy-MM-dd로 되어야하는데
    //LocalDateTime이면 뒤에 이상
    private LocalDate start;*/

    @Builder
    public Note(String title, String content, LocalDate start) {
        this.title = title;
        this.content = content;
        this.start = start;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
