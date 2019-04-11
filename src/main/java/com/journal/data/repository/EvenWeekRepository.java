package com.journal.data.repository;

import com.journal.data.entities.EvenWeek;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvenWeekRepository extends /*WeekRepository*/PagingAndSortingRepository<EvenWeek,Long> {
    List<EvenWeek> findBySubjectNameContainsIgnoreCase(String subjName);
}