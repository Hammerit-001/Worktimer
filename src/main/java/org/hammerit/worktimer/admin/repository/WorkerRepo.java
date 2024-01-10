package org.hammerit.worktimer.admin.repository;

import org.hammerit.worktimer.admin.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepo extends JpaRepository<Worker, Long> {
}
