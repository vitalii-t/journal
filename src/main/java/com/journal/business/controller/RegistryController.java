package com.journal.business.controller;

import com.journal.business.service.RegistryService;
import com.journal.data.entities.Registry;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/registry")
@PreAuthorize("hasAnyAuthority('ADMIN','MONITOR','STUDENT')")
public class RegistryController {

    private final RegistryService registryService;

    public RegistryController(RegistryService registryService) {
        this.registryService = registryService;
    }

//    @GetMapping("{date}")
//    public String dateRegistry(@PathVariable LocalDate date, Model model){
//
//        /*List<Registry>*/Registry registry = registryService.registryByDate(date);
//
//        model.addAttribute("reg",registry);
//        return "records";
//    }

    @GetMapping("/insert")
    public String insertRecord(){
        return "addRecord";
    }


    @PostMapping("/insert")
    public String insertRecord(
            Registry registry, Model model,@RequestParam String date/*,
            Map<String, String> form*/
    ){
        if(!registryService.insert(registry,date)){
            model.addAttribute("msg","Record already exists");
        }
        return "addRecord";
    }
}