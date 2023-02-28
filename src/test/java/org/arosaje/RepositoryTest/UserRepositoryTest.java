package org.arosaje.RepositoryTest;

import org.arosaje.entities.User;
import org.arosaje.entities.UserInfo;
import org.arosaje.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    public void testSaveNotNull() {
        // Arrangement
        User user = new User("example@example.com", "example", "user", new UserInfo("Example", "Example"));

        // Acting
        User savedUser = repository.save(user);

        // Asserting
        assertNotNull(savedUser);
    }

    @Test
    public void testFindAll() {
        // Arrangement
        List<User> users;
        // Acting
        users = (List<User>) repository.findAll();
        // Asserting
        assertEquals(1, users.size());
    }

    @Test
    public void testFindById() {
        // Arrangement
        User user =new User(1,"example@example.com");
        // Acting
        User userFind = repository.findById(1).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        // Asserting
        assertEquals(user, userFind);
    }
}
