package com.journal.business.controller;

import com.journal.business.service.JournalService;
import com.journal.data.entities.EvenWeek;
import com.journal.data.entities.OddWeek;
import com.journal.data.entities.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class JournalController {

    private JournalService journalService;

    @Autowired
    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @RequestMapping("/schedule")
    public String getSchedule(Model model) {
        List<Schedule> schedules = journalService.getSchedule();
        model.addAttribute("schedules", schedules);
        return "schedule";
    }

    @RequestMapping("/even")
    public String getEvenWeek(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        //List<EvenWeek> week = journalService.getEvenWeek();
        //model.addAttribute("even", week);
        List<EvenWeek> weekList = journalService.filterEven(filter);
        model.addAttribute("subjects", weekList);
        model.addAttribute("filter", filter);
        return "even";
    }

    @RequestMapping("/odd")
    public String getOddWeek(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        //List<OddWeek> week = journalService.getOddWeek();
        List<OddWeek> weekIterable = journalService.filterOdd(filter);
        model.addAttribute("subjects", weekIterable);
        model.addAttribute("filter", filter);

       // model.addAttribute("odd", week);
        return "odd";
    }

    @RequestMapping("/")
    public String index() {
        return "main";
    }

//    @PostMapping("/odd")
//    public String filterOdd(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
//        List<OddWeek> weekIterable = journalService.filterOdd(filter);
//        model.addAttribute("subjects", weekIterable);
//        model.addAttribute("filter", filter);
//        return "odd";
//    }
}