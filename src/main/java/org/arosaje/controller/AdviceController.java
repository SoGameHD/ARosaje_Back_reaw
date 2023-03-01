package org.arosaje.controller;

import org.arosaje.entities.Advice;
import org.arosaje.repository.AdviceRepository;
import org.arosaje.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    @Autowired
    private AdviceRepository adviceRepository;

    @PostMapping( "/addAdvice" )
    public void addPictures(@RequestParam Integer plantId, @RequestParam Integer botanistId, @RequestBody Advice advice) {
        adviceService.storePlantAdvice(plantId,botanistId,advice);
    }


}
