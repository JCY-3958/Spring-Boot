package com.codehows.fullcalendar.repository;

import com.codehows.fullcalendar.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Note, Long> {
}
