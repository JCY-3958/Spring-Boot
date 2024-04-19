package com.codehows.fullcalendar.dto;

import com.codehows.fullcalendar.domain.Note;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class NoteResponse {

    private final Long id;
    private final String title;
    private final LocalDate start;

    public NoteResponse(Note note) {
        this.id = note.getId();
        this.title = note.getTitle();
        this.start = note.getStart();
    }
}
