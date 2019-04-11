package com.journal.data.repository;

import com.journal.data.entities.OddWeek;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OddWeekRepository extends /*WeekRepository*//*PagingAndSorting*/CrudRepository<OddWeek,Long> {
    //List<OddWeek> findBySubjectName(final String subjNme);
    List<OddWeek> findBySubjectNameContainsIgnoreCase(String subjName);
}