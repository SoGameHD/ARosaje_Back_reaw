package org.arosaje.controller;

import org.arosaje.entities.Advice;
import org.arosaje.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    @RequestMapping(method = RequestMethod.GET, value ="/getAdviceById")
    public Optional<Advice> getAdviceById(@RequestParam(name = "id") Integer id) {
        return adviceService.getAdviceById(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/createAdvice")
    public void createAdvice(@RequestParam(name = "advice") Advice advice) {
        adviceService.createAdvice(advice);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateAdvice")
    public void updateAdvice(@RequestParam(name = "advice") Advice advice) {
        adviceService.saveAdvice(advice);
    }
    @RequestMapping(method = RequestMethod.DELETE, value ="/deleteAdviceById")
    public void deleteAdviceById(@RequestParam(name = "id") Integer id) {
        adviceService.deleteAdviceById(id);
    }


}
