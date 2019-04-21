package com.journal.data.repository;

import com.journal.data.entities.Week;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeekRepository extends JpaRepository<Week, Long> {
    List<Week> findBySubjectNameContainsIgnoreCaseAndWeekTypeIgnoreCase(String subjName,String weekType);

    List<Week> findByWeekType(String weekType);

}