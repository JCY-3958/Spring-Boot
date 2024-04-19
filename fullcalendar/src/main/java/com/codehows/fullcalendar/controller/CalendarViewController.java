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
        return "calendar";
    }

    @GetMapping("/calendar/add")
    public String newNote() {

        return "newNote";
    }

    @GetMapping("/calendar/note/{id}")
    public String ViewNote(@PathVariable Long id, Model model) {
        //System.out.println("이거시다:" + id);
        Note note = noteService.findById(id);
       model.addAttribute("note", new NoteViewResponse(note));
        return "ViewNote";
    }

    @GetMapping("/calendar/noteupdate")
    public String UpdateNote(@RequestParam Long id, Model model) {
        Note note = noteService.findById(id);
        model.addAttribute("note", new NoteViewResponse(note));
        return "updateNote";
    }
}
