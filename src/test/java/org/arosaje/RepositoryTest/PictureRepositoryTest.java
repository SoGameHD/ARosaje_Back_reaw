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
        assertEquals(1, pictures.size());
    }

    @Test
    public void testFindById() {
        // Arrangement
        Picture picture = new Picture(1, "photo.jpg", this.defaultPicture.getDate(), "image/jpeg", 1919651);
        // Acting
        Picture pictureFind = repository.findById(1).orElseThrow(() -> new RuntimeException("Photo non trouvée"));
        // Asserting
        assertEquals(picture, pictureFind);
    }
}
