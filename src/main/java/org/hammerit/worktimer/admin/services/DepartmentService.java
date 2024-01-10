package org.hammerit.worktimer.admin.services;

import org.hammerit.worktimer.admin.entities.Department;
import org.hammerit.worktimer.admin.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepo departmentRepo;

    @Autowired
    public void setDepartmentRepo(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public List<Department> getAllDepartments() {
        return departmentRepo.findAll(Sort.by("departmentId"));
    }

    public void addDepartment(Department department) {
        departmentRepo.save(department);
    }

    public Department findById(Long departmentId) {
        return departmentRepo.getById(departmentId);
    }

    public void deleteById(Long departmentId) {
        departmentRepo.deleteById(departmentId);
    }
}
