package com.journal.business.service;

import com.journal.data.entities.Registry;
import com.journal.data.repository.RegistryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class RegistryService {

    private final RegistryRepository registryRepository;

    public RegistryService(RegistryRepository registryRepository) {
        this.registryRepository = registryRepository;
    }

    public void registry(){

    }

    public List<Registry> registryByDate(LocalDate date){
        return registryRepository.findByDate(date);
    }

    public boolean insert(Registry registry) {
//        Registry dbRecord = registryRepository.findByDate(registry.getDate());
//
//        if(null!=dbRecord){
//            return false;
//        }
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d-M-yyyy");
//
//        LocalDate studyDate = (LocalDate) dateFormat.parse(date);

        registry.setDate(LocalDate.now());

        registryRepository.save(registry);
        return true;
    }
}