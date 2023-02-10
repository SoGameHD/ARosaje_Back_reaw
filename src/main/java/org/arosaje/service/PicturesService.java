package org.arosaje.service;

import org.arosaje.entities.Picture;
import org.arosaje.entities.Plant;
import org.arosaje.repository.PictureRepository;
import org.arosaje.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class PicturesService {

    @Autowired
     PlantRepository plantRepository;
    @Autowired
    PictureRepository pictureRepository;


    public void storePlantPictures(Integer plantId, MultipartFile file ) throws IOException {
         Picture picture= null;
        Optional<Plant> plant  = plantRepository.findById( plantId );
        Plant actualPlant = plant.orElse(null);
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        picture = new Picture(fileName, LocalDateTime.now(),file.getContentType(), file.getSize(), file.getBytes(), actualPlant);

        pictureRepository.save(picture);

    }


}