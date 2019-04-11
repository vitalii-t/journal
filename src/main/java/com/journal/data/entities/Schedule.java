package com.journal.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "schedule")
@Data @NoArgsConstructor
public class Schedule {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "begin_time")
    private LocalTime beginning;

    @Column(name = "end_time")
    private LocalTime end;

    @Override
    public String toString() {
        return "Schedule{" +
                "№ " + id +
                ", beginning=" + beginning +
                ", end=" + end +
                '}';
    }
}