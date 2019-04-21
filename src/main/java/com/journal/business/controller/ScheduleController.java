package com.journal.business.controller;

import com.journal.business.service.ScheduleService;
import com.journal.data.entities.Schedule;
import com.journal.data.entities.Week;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ScheduleController {

    private ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @RequestMapping("/schedule")
    public String getSchedule(Model model) {
        List<Schedule> schedules = scheduleService.getSchedule();
        model.addAttribute("schedules", schedules);
        return "schedule";
    }

    @RequestMapping("/odd")
    public String getOddWeek(@RequestParam(required = false, defaultValue = "") String filter, Model model) {

        List<Week> week = scheduleService.filterWeek(filter, "odd");
        model.addAttribute("list", week);
        model.addAttribute("filter", filter);
        return "odd";
    }

    @RequestMapping("/even")
    public String getEvenWeek(@RequestParam(required = false, defaultValue = "") String filter, Model model) {

        List<Week> week = scheduleService.filterWeek(filter, "even");
        model.addAttribute("list", week);
        model.addAttribute("filter", filter);
        return "even";
    }
}