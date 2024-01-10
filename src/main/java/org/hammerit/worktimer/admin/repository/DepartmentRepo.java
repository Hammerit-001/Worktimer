package org.hammerit.worktimer.admin.repository;

import org.hammerit.worktimer.admin.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
