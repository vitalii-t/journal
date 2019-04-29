package com.journal.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "week")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Week implements Serializable { //нечетная неделя

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "week_type")
    private String weekType;

    @Column(name = "index_number")
    private Long indexNumber;

    @Column(name = "week_day")
    private String dayOfTheWeek;

    public Week(String subjectName, String weekType, Long indexNumber, String dayOfTheWeek) {
        this.subjectName = subjectName;
        this.weekType = weekType;
        this.indexNumber = indexNumber;
        this.dayOfTheWeek = dayOfTheWeek;
    }
}