package org.hammerit.worktimer.admin.controllers;

import org.hammerit.worktimer.admin.entities.Department;
import org.hammerit.worktimer.admin.entities.Worker;
import org.hammerit.worktimer.admin.services.DepartmentService;
import org.hammerit.worktimer.admin.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class DepartmentController {
    private DepartmentService departmentService;
    private WorkerService workerService;

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Autowired
    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("/departments")
    public String showAllDepartments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "departments";
    }

    @PostMapping("/departments")
    public String redirectDepartmentsPage(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "departments";
    }

    @GetMapping("/show_department/{department_id}")
    public String showOneDepartment(Model model, @PathVariable(value = "department_id") Long departmentId) {
        List<Worker> workerList = workerService.findByDepartmentId(departmentId);
        Department department = departmentService.findById(departmentId);
        model.addAttribute("workers", workerList);
        model.addAttribute("department", department);
        return "show_department";
    }

    @GetMapping("/add_department")
    public String addDepartmentForm(Model model) {
        Department department = new Department();
        model.addAttribute(department);
        return "add_department";
    }

    @PostMapping("/add_department")
    public String addDepartment(@ModelAttribute(value = "department") Department department) {
        departmentService.addDepartment(department);
        return "redirect:/admin/departments";
    }

    @GetMapping("/edit_department/{department_id}")
    public String editDepartmentForm(Model model, @PathVariable(value = "department_id") Long departmentId) {
        Department department = departmentService.findById(departmentId);
        model.addAttribute(department);
        return "edit_department";
    }

    @PostMapping("/edit_department")
    public String editDepartment(@ModelAttribute(value = "department") Department department) {
        departmentService.addDepartment(department);
        return "redirect:/admin/departments";
    }

    @GetMapping("delete_department/{department_id}")
    public String deleteDepartment(@PathVariable(value = "department_id") Long departmentId) {
        departmentService.deleteById(departmentId);
        return "redirect:/admin/departments";
    }
}
