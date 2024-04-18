package com.codehows.fullcalendar.dto;

import com.codehows.fullcalendar.domain.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddNoteRequest {
    private String title;
    private String content;
    private LocalDate start;

    public Note toEntity() {
        return Note.builder()
                .title(title)
                .content(content)
                .start(start)
                .build();
    }
}
