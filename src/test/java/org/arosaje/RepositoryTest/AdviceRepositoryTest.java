package org.arosaje.RepositoryTest;

import org.arosaje.entities.Advice;
import org.arosaje.repository.AdviceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AdviceRepositoryTest {

    @Autowired
    private AdviceRepository repository;

    private Advice defaultAdvice = new Advice("Example advice");
    @Test
    public void testSaveNotNull() {
        // Arrangement
        Advice advice = this.defaultAdvice;

        // Acting
        Advice savedAdvice = repository.save(advice);

        // Asserting
        assertNotNull(savedAdvice);
    }

    @Test
    public void testFindAll() {
        // Arrangement
        List<Advice> advices;
        // Acting
        advices = (List<Advice>) repository.findAll();
        // Asserting
        assertNotNull(advices);
    }

    @Test
    public void testFindById() {
        // Arrangement
        int id  = 1;
        // Acting
        Advice adviceFind = repository.findById(1).orElse(null);
        // Asserting
        assertNotNull(adviceFind);
        assertEquals(id, adviceFind.getId());
    }
}
