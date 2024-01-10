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
public class WorkerController {
    private WorkerService workerService;
    private DepartmentService departmentService;

    @Autowired
    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/workers")
    public String showAllWorkers (Model model) {
        model.addAttribute("workers", workerService.getAllWorkers());
        return "workers";
    }

    @PostMapping("/workers")
    public String redirectWorkersPage(Model model) {
        model.addAttribute("workers", workerService.getAllWorkers());
        return "workers";
    }

    @GetMapping("/add_worker")
    public String addWorkerForm(Model model) {
        Worker worker = new Worker();
        List<Department> departmentList = departmentService.getAllDepartments();
        model.addAttribute("worker", worker);
        model.addAttribute("departments", departmentList);
        return "add_worker";
    }

    @PostMapping("/add_worker")
    public String addWorker(@ModelAttribute(value = "worker") Worker worker) {
        workerService.addWorker(worker);
        return "redirect:/admin/workers";
    }

    @GetMapping("/edit_worker/{worker_id}")
    public String editWorkerForm(Model model, @PathVariable(value = "worker_id") Long workerId) {
        Worker worker = workerService.findById(workerId);
        List<Department> departmentList = departmentService.getAllDepartments();
        model.addAttribute("worker", worker);
        model.addAttribute("departments", departmentList);
        return "edit_worker";
    }

    @PostMapping("/edit_worker")
    public String editWorker(@ModelAttribute(value = "worker") Worker worker) {
        workerService.addWorker(worker);
        return "redirect:/admin/workers";
    }

    @GetMapping("/delete_worker/{worker_id}")
    public String deleteWorker(@PathVariable(value = "worker_id") Long workerId) {
        workerService.deleteById(workerId);
        return "redirect:/admin/workers";
    }
}
