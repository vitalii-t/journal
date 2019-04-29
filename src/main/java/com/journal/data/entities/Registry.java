package com.journal.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "registry")
@Data @NoArgsConstructor @AllArgsConstructor
public class Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean present;

    private String subject;

    private Long studentId;

    private double mark;

    private LocalDate date;

}
