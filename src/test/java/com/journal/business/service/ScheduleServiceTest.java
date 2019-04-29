package com.journal.business.service;

import com.journal.data.entities.Week;
import com.journal.data.repository.WeekRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleServiceTest {

    @InjectMocks
    private ScheduleService scheduleService;

    @Mock
    private WeekRepository weekRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void filterWeek() {
        String weekType = "even";
        String filter = "dig";

        Week thursday = new Week("Digital signal processing (lec)","even",
                2L,"thursday");
        Week friday = new Week("Digital signal processing (pr)",
                "even",3L,"friday");
        List<Week> list = new ArrayList<>();
        list.add(thursday);
        list.add(friday);

        when(weekRepository.findBySubjectNameContainsIgnoreCaseAndWeekTypeIgnoreCase(filter,weekType)).
        thenReturn(list);

        List<Week> weeks = scheduleService.filterWeek(filter,weekType);

        assertEquals(list.size(),weeks.size());

        verify(weekRepository,times(1))
                .findBySubjectNameContainsIgnoreCaseAndWeekTypeIgnoreCase(filter,weekType);
    }
}