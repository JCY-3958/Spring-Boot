package com.codehows.fullcalendar.controller;

import com.codehows.fullcalendar.domain.Note;
import com.codehows.fullcalendar.dto.AddNoteRequest;
import com.codehows.fullcalendar.dto.NoteResponse;
import com.codehows.fullcalendar.dto.UpdateRequest;
import com.codehows.fullcalendar.repository.CalendarRepository;
import com.codehows.fullcalendar.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CalendarApiController {
    private final NoteService noteService;

    @PostMapping("/api/notes")
    public ResponseEntity<Note> addNote(@RequestBody AddNoteRequest request) {
        Note savedNote = noteService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedNote);
    }

    @GetMapping("/api/notes")
    public ResponseEntity<List<NoteResponse>> findAllNotes() {
        List<NoteResponse> notes = noteService.findAll()
                .stream()
                .map(NoteResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(notes);
    }

    @GetMapping("/api/notes/{id}")
    public ResponseEntity<NoteResponse> findNoteById(@PathVariable long id) {
        Note note = noteService.findById(id);

        return ResponseEntity.ok()
                .body(new NoteResponse(note));
    }

    @DeleteMapping("/api/notes/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable long id) {
        noteService.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/notes/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable long id,
                                           @RequestBody UpdateRequest request) {
        Note updatedNote = noteService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedNote);
    }
}
