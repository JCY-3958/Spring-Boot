package com.codehows.fullcalendar.controller;

import com.codehows.fullcalendar.domain.Note;
import com.codehows.fullcalendar.dto.NoteResponse;
import com.codehows.fullcalendar.dto.NoteViewResponse;
import com.codehows.fullcalendar.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CalendarViewController {

    private final NoteService noteService;

    @GetMapping("/calendar")
    public String getcalendar(Model model) {
        /*List<NoteResponse> notes = noteService.findAll().stream()
                .map(NoteResponse::new)
                .toList();

        model.addAttribute("notes", notes);*/
        return "calendar";
    }

    @GetMapping("/calendar/add")
    public String newNote() {

        return "newNote";
    }
}
