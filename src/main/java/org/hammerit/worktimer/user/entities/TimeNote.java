package org.hammerit.worktimer.user.entities;

import org.hammerit.worktimer.admin.entities.Worker;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "time_note")
public class TimeNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_note_id")
    private Long timeNoteId;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @Column(name = "date")
    private LocalDate date = LocalDate.now();

    @Column(name = "time")
    private LocalTime time = LocalTime.now();

    @Column(name = "on_work")
    private boolean onWork;

    public TimeNote() {
    }

    public TimeNote(Long timeNoteId, Worker worker, LocalDate date, LocalTime time, boolean onWork) {
        this.timeNoteId = timeNoteId;
        this.worker = worker;
        this.date = date;
        this.time = time;
        this.onWork = onWork;
    }

    public Long getTimeNoteId() {
        return timeNoteId;
    }

    public void setTimeNoteId(Long timeNoteId) {
        this.timeNoteId = timeNoteId;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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
        TimeNote timeNote = (TimeNote) o;
        return onWork == timeNote.onWork && Objects.equals(timeNoteId, timeNote.timeNoteId) && Objects.equals(worker, timeNote.worker) && Objects.equals(date, timeNote.date) && Objects.equals(time, timeNote.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeNoteId, worker, date, time, onWork);
    }

    @Override
    public String toString() {
        return "TimeNote{" +
                "timeNoteId=" + timeNoteId +
                ", worker=" + worker +
                ", date=" + date +
                ", time=" + time +
                ", onWork=" + onWork +
                '}';
    }
}
