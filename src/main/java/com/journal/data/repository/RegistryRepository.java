package com.journal.data.repository;

import com.journal.data.entities.Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Long> {
    List<Registry> findByStudentIdAndPresentAndDateAndSubject(Long id, boolean present, LocalDate date, String subject);

    List<Registry> findByDate(LocalDate date);

    List<Registry> findByStudentId(Long id);

    List<Registry> findBySubjectAndDate(String subj, LocalDate date);

}