package org.arosaje.controller;

import org.arosaje.entities.Picture;
import org.arosaje.service.PicturesService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@RestController
public class PictureController {

    @Autowired
    private PicturesService picturesService;

    @PostMapping( "/addPicture" )
    public void addPictures(@RequestParam(name = "id") Integer plantId,  @RequestParam(name = "file") MultipartFile file) throws IOException {
        picturesService.storePlantPictures(plantId,file);
    }

    @GetMapping("/plants/{plantId}/pictures/{pictureId}")
    @ResponseBody
    public ResponseEntity<byte[]> getPicture(@PathVariable Integer plantId , @PathVariable Integer pictureId){

        // Utilisez un service pour extraire l'image de la base de données en fonction de l'ID fourni
        byte[] pictureBytes = picturesService.getPicture(plantId,pictureId).getContent();

        // Configurez la réponse HTTP pour renvoyer les données de l'image
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(pictureBytes.length);
        System.out.println(picturesService.getPicture(plantId,pictureId).toString());
        return new ResponseEntity<byte[]>(pictureBytes, headers, HttpStatus.OK);
    }
}