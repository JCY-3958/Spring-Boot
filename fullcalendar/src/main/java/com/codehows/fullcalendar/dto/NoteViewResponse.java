package com.codehows.fullcalendar.dto;

import com.codehows.fullcalendar.domain.Note;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class NoteViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDate start;

    public NoteViewResponse(Note note) {
        this.id = note.getId();
        this.title = note.getTitle();
        this.content = note.getContent();
        this.start = note.getStart();
    }
}
