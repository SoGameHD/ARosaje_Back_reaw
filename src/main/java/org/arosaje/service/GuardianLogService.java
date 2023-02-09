package org.arosaje.service;

import org.arosaje.entities.Advice;
import org.arosaje.entities.GuardianLog;
import org.arosaje.repository.GuardianLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuardianLogService {

    @Autowired
    private GuardianLogRepository guardianLogRepository;

    public List<GuardianLog> getGuardianLogByPlantId(Integer id) {
        return guardianLogRepository.findByPlantId(id);
    }
    public void createGuardianLog(GuardianLog guardianLog) {
        guardianLogRepository.save(guardianLog);
    }
    public void saveGuardianLog(GuardianLog guardianLog) {
        guardianLogRepository.save(guardianLog);
    }
    public void deleteGuardianLogById(Integer id) {
        guardianLogRepository.deleteById(id);
    }
}
