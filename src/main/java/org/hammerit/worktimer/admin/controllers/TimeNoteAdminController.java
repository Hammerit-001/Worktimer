package org.hammerit.worktimer.admin.controllers;

import org.hammerit.worktimer.user.services.TimeNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class TimeNoteAdminController {
    private TimeNoteService timeNoteService;

    @Autowired
    public void setTimeNoteService(TimeNoteService timeNoteService) {
        this.timeNoteService = timeNoteService;
    }

    @GetMapping("/time_notes")
    public String timeNotes(Model model) {
        model.addAttribute("timenotes", timeNoteService.getAllNotes());
        return "time_notes";
    }


}
