package org.hammerit.worktimer.admin.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_id")
    private Long workerId;

    @Column(name = "worker_name")
    private String workerName;

    @Column(name = "worker_phone")
    private String workerPhone;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department departmentId;

    @Column(name = "on_work")
    private boolean onWork;

    public Worker() {
    }

    public Worker(Long workerId, String workerName) {
        this.workerId = workerId;
        this.workerName = workerName;
    }

    public Worker(Long workerId, String workerName, String workerPhone) {
        this.workerId = workerId;
        this.workerName = workerName;
        this.workerPhone = workerPhone;
    }

    public Worker(Long workerId, String workerName, String workerPhone, Department departmentId, boolean onWork) {
        this.workerId = workerId;
        this.workerName = workerName;
        this.workerPhone = workerPhone;
        this.departmentId = departmentId;
        this.onWork = onWork;
    }

    public Worker(String workerName) {
        this.workerName = workerName;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerPhone() {
        return workerPhone;
    }

    public void setWorkerPhone(String workerPhone) {
        this.workerPhone = workerPhone;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public boolean isOnWork() {
        return onWork;
    }

    public void setOnWork(boolean onWork) {
        this.onWork = onWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return onWork == worker.onWork && Objects.equals(workerId, worker.workerId) && Objects.equals(workerName, worker.workerName) && Objects.equals(workerPhone, worker.workerPhone) && Objects.equals(departmentId, worker.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerId, workerName, workerPhone, departmentId, onWork);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "workerId=" + workerId +
                ", workerName='" + workerName + '\'' +
                ", workerPhone='" + workerPhone + '\'' +
                ", departmentId=" + departmentId +
                ", onWork=" + onWork +
                '}';
    }
}
