package com.journal.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "registry")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean present;

    private String subject;

   // @ElementCollection(targetClass = Long.class, fetch = FetchType.EAGER)
    private Long studentId;

    private LocalDate date;

}
