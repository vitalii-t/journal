package com.journal.business.service;

import com.journal.data.entities.EvenWeek;
import com.journal.data.entities.OddWeek;
import com.journal.data.entities.Schedule;
import com.journal.data.repository.EvenWeekRepository;
import com.journal.data.repository.OddWeekRepository;
import com.journal.data.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {

    private ScheduleRepository scheduleRepository;
    private OddWeekRepository oddWeekRepository;
    private EvenWeekRepository evenWeekRepository;

    public JournalService(ScheduleRepository scheduleRepository,
                          OddWeekRepository oddWeekRepository, EvenWeekRepository evenWeekRepository) {
        this.scheduleRepository = scheduleRepository;
        this.oddWeekRepository = oddWeekRepository;
        this.evenWeekRepository = evenWeekRepository;
    }

    public List<Schedule> getSchedule() {
        return (List<Schedule>) scheduleRepository.findAll();
    }

    public List<OddWeek> getOddWeek() {
        return (List<OddWeek>) oddWeekRepository.findAll();
    }

    public List<EvenWeek> getEvenWeek() {
        return (List<EvenWeek>) evenWeekRepository.findAll();
    }


    public List<OddWeek> filterOdd(String filter) {
        if(filter!=null && !filter.isEmpty()) {
            return oddWeekRepository.findBySubjectNameContainsIgnoreCase(filter);
        }
        else
        {
            return (List<OddWeek>) oddWeekRepository.findAll();
        }
    }
    public List<EvenWeek> filterEven(String filter){
        if(filter!=null && !filter.isEmpty()) {
            return evenWeekRepository.findBySubjectNameContainsIgnoreCase(filter);
        }
        else
        {
            return (List<EvenWeek>) evenWeekRepository.findAll();
        }
    }
}