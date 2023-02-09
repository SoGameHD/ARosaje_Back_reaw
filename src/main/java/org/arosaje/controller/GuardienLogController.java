package org.arosaje.controller;

import org.arosaje.entities.Advice;
import org.arosaje.entities.GuardianLog;
import org.arosaje.service.GuardianLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GuardienLogController {

    @Autowired
    private GuardianLogService guardianLogService;

    @RequestMapping(method = RequestMethod.GET, value ="/getGuardianLogByPlantId")
    public List<GuardianLog> getGuardianLogByPlantId(@RequestParam(name = "id") Integer id) {
        return guardianLogService.getGuardianLogByPlantId(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/createGuardianLog")
    public void createGuardianLog(@RequestBody GuardianLog guardianLog) {
        guardianLogService.createGuardianLog(guardianLog);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateGuardianLog")
    public void updateGuardianLog(@RequestBody GuardianLog guardianLog) {
        guardianLogService.saveGuardianLog(guardianLog);
    }
    @RequestMapping(method = RequestMethod.DELETE, value ="/deleteGuardianLogById")
    public void deleteGuardianLogById(@RequestParam(name = "id") Integer id) {
        guardianLogService.deleteGuardianLogById(id);
    }
}
