package org.arosaje.RepositoryTest;

import org.arosaje.entities.Picture;
import org.arosaje.repository.PictureRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PictureRepositoryTest {

    @Autowired
    PictureRepository repository;
    private Picture defaultPicture = new Picture("photo.jpg", java.time.LocalDateTime.now(), "image/jpeg", 1919651);
    @Test
    public void testSaveNotNull() {
        // Arrangement
        Picture picture = this.defaultPicture;

        // Acting
        Picture savedPicture = repository.save(picture);

        // Asserting
        assertNotNull(savedPicture);
    }

    @Test
    public void testFindAll() {
        // Arrangement
        List<Picture> pictures;
        // Acting
        pictures = (List<Picture>) repository.findAll();
        // Asserting
        assertNotNull(pictures);
    }

    @Test
    public void testFindById() {
        // Arrangement
        int id = 1;
        // Acting
        Picture pictureFind = repository.findById(1).orElse(null);
        // Asserting
        assertNotNull(pictureFind);
        assertEquals(id, pictureFind.getId());
    }
}
