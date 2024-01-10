package org.hammerit.worktimer.user.repository;

import org.hammerit.worktimer.user.entities.TimeNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeNoteRepo extends JpaRepository<TimeNote, Long> {
}
