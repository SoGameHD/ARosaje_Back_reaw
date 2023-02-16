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
import java.util.*;

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

    public Picture getPicture(Integer plantId, Integer pictureId){
        Optional<Plant> plant  = plantRepository.findById( plantId );
        Plant actualPlant = plant.orElse(null);
        List<Picture> pictures  = pictureRepository.getAllByPlantId(plantId);
        //Optional<Picture> picture = pictureRepository.findById(actualPlant.);
        //Picture actuelPicture = pictures.orElse(null);
        for(Picture picture : pictures){
            if(picture.getId() == pictureId){
                return picture;
            }
        }


        return null;
    }

    public void deletePicture(Integer pictureId) {
        pictureRepository.deleteById(pictureId);
    }


}