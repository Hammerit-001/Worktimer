package org.hammerit.worktimer.user.controllers;

import org.hammerit.worktimer.admin.entities.Worker;
import org.hammerit.worktimer.admin.services.WorkerService;
import org.hammerit.worktimer.user.entities.TimeNote;
import org.hammerit.worktimer.user.services.TimeNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequestMapping("/add_note")
public class TimeNoteUserController {
    private TimeNoteService timeNoteService;
    private WorkerService workerService;

    @Autowired
    public void setTimeNoteService(TimeNoteService timeNoteService) {
        this.timeNoteService = timeNoteService;
    }

    @Autowired
    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public String formNote(Model model) {
        Worker worker = new Worker();
        TimeNote timeNote = new TimeNote();
        model.addAttribute(worker);
        model.addAttribute(timeNote);
        return "add_note";
    }

    @PostMapping
    public String addNote(@ModelAttribute(value = "timeNote") TimeNote timeNote) {
        timeNote.setDate(LocalDate.now());
        timeNote.setTime(LocalTime.now());
        Worker worker = workerService.findById(timeNote.getWorker().getWorkerId());
        worker.setOnWork(!worker.isOnWork());
        timeNote.setOnWork(worker.isOnWork());
        workerService.addWorker(worker);
        timeNoteService.addNote(timeNote);
        return "redirect:/add_note";
    }

}
