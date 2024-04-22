package com.codehows.sbd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CalendarController {

    @GetMapping("/calendar")
    public String calendar() {
        return "calendar";
    }

}
