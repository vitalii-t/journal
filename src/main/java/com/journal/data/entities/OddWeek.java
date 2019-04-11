package com.journal.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "odd_week")
@Data @NoArgsConstructor
public class OddWeek { //нечетная неделя

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "index_number")
    private Long indexNumber;

    @Column(name = "week_day")
    private String dayOfTheWeek;

}