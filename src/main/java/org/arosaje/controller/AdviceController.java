package org.arosaje.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.arosaje.entities.Advice;
import org.arosaje.repository.AdviceRepository;
import org.arosaje.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    @Autowired
    private AdviceRepository adviceRepository;

    @PostMapping( "/advice" )
    public void addAdvice(@RequestParam Integer plantId, @RequestParam Integer botanistId, @RequestParam String advice) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Advice tempAdvice = objectMapper.readValue(advice, Advice.class);
        adviceService.storePlantAdvice(plantId, botanistId, tempAdvice);
    }


}
