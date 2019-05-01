package com.journal.business.service;

import com.journal.data.entities.Schedule;
import com.journal.data.entities.Week;
import com.journal.data.repository.ScheduleRepository;
import com.journal.data.repository.WeekRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private ScheduleRepository scheduleRepository;
    private WeekRepository weekRepository;

    public ScheduleService(ScheduleRepository scheduleRepository,
                           WeekRepository weekRepository) {
        this.scheduleRepository = scheduleRepository;
        this.weekRepository = weekRepository;
    }

    public List<Schedule> getSchedule() {
        return scheduleRepository.findAll();
    }

    public List<Week> filterWeek(String filter, String weekType) {
        if (filter != null && !filter.isEmpty()) {
            return weekRepository.findBySubjectNameContainsIgnoreCaseAndWeekTypeIgnoreCase(filter, weekType);
        } else {
            return weekRepository.findByWeekType(weekType);
        }
    }
}