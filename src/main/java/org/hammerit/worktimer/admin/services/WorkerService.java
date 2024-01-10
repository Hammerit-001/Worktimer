package org.hammerit.worktimer.admin.services;

import org.hammerit.worktimer.admin.entities.Worker;
import org.hammerit.worktimer.admin.repository.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerService {
    private WorkerRepo workerRepo;

    @Autowired
    public void setWorkerRepo(WorkerRepo workerRepo) {
        this.workerRepo = workerRepo;
    }

    public List<Worker> getAllWorkers() {
        return workerRepo.findAll(Sort.by("workerId"));
    }

    public void addWorker(Worker worker) {
        workerRepo.save(worker);
    }

    public Worker findById(Long workerId) {
        return workerRepo.getById(workerId);
    }

    public void deleteById(Long workerId) {
        workerRepo.deleteById(workerId);
    }

    public List<Worker> findByDepartmentId(Long departmentId) {
        List<Worker> workerList = workerRepo.findAll();
        return workerList.stream().filter((worker) -> worker.getDepartmentId().getDepartmentId() == departmentId).collect(Collectors.toList());
    }
}
