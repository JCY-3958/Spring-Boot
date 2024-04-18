package com.codehows.fullcalendar.service;

import com.codehows.fullcalendar.domain.Note;
import com.codehows.fullcalendar.dto.AddNoteRequest;
import com.codehows.fullcalendar.dto.UpdateRequest;
import com.codehows.fullcalendar.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service
public class NoteService {
    private final CalendarRepository CalendarRepository;

    public Note save(AddNoteRequest request) {
        return CalendarRepository.save(request.toEntity());
    }

    public List<Note> findAll() {
        return CalendarRepository.findAll();
    }

    public Note findById(Long id) {
        return CalendarRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void deleteById(Long id) {
        CalendarRepository.deleteById(id);
    }

    @Transactional
    public Note update(Long id, UpdateRequest request) {
        Note note = CalendarRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        note.update(request.getTitle(), request.getContent());

        return note;
    }
}
