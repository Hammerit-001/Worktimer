package org.hammerit.worktimer.user.services;

import org.hammerit.worktimer.user.entities.TimeNote;
import org.hammerit.worktimer.user.repository.TimeNoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeNoteService {
    private TimeNoteRepo timeNoteRepo;

    @Autowired
    public void setTimeNoteRepo(TimeNoteRepo timeNoteRepo) {
        this.timeNoteRepo = timeNoteRepo;
    }

    public List<TimeNote> getAllNotes() {
        return timeNoteRepo.findAll(Sort.by("timeNoteId"));
    }

    public void addNote(TimeNote timeNote) {
        timeNoteRepo.save(timeNote);
    }
}
