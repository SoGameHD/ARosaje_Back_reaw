package org.arosaje.RepositoryTest;

import org.arosaje.entities.User;
import org.arosaje.entities.UserInfo;
import org.arosaje.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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
        assertNotNull(users);
    }

    @Test
    public void testFindByEmail() {
        // Arrangement
        String email = "example@example.com";
        // Acting
        Optional<User> userFind = repository.findByEmail("example@example.com");
        // Asserting
        assertEquals(email, userFind.get().getEmail());
        repository.delete(userFind.get());
    }
}
