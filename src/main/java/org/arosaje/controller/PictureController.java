package org.arosaje.controller;

import org.arosaje.entities.Picture;
import org.arosaje.entities.User;
import org.arosaje.repository.PictureRepository;
import org.arosaje.service.PicturesService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RestController
public class PictureController {

    @Autowired
    private PicturesService picturesService;

    @PostMapping( "/addPicture" )
    public void addPictures(@RequestParam(name = "id") Integer plantId,  @RequestParam(name = "file") MultipartFile file) throws IOException {
        picturesService.storePlantPictures(plantId,file);
    }


}