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
        assertEquals(1, advices.size());
    }

    @Test
    public void testFindById() {
        // Arrangement
        Advice advice = new Advice(1, "Example advice", this.defaultAdvice.getDate());
        // Acting
        Advice adviceFind = repository.findById(1).orElseThrow(() -> new RuntimeException("Conseil non trouvé"));
        // Asserting
        assertEquals(advice, adviceFind);
    }
}
