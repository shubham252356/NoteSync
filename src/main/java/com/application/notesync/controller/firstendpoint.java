package com.application.notesync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notes")
public class firstendpoint {

    @GetMapping
    public String notes() {
        return "hello";
    }

}
