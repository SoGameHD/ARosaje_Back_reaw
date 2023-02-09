package org.arosaje.service;

import org.arosaje.entities.Advice;
import org.arosaje.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdviceService {

    @Autowired
    private AdviceRepository adviceRepository;

    public Optional<Advice> getAdviceById(Integer id) {
        return adviceRepository.findById(id);
    }
    public void createAdvice(Advice advice) {
        adviceRepository.save(advice);
    }
    public void saveAdvice(Advice advice) {
        adviceRepository.save(advice);
    }
    public void deleteAdviceById(Integer id) {
        adviceRepository.deleteById(id);
    }
}
