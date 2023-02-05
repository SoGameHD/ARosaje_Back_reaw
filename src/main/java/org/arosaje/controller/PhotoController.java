package org.arosaje.controller;

import org.arosaje.dto.PhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PhotoController {

    @Autowired
    private org.arosaje.repository.PhotoRepositoryImpl PhotoRepositoryImpl;

    @RequestMapping(method = RequestMethod.GET, value ="/v1/getPhotoByPlantId")
    public List<PhotoDTO> getPhotoByPlantId(@RequestParam(name="id") long id) {
        return PhotoRepositoryImpl.getPhotoByPlantId(id);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/v1/getPhotoById")
    public Object getPhotoById(@RequestParam(name="id") long id) {
        return PhotoRepositoryImpl.getPhotoById(id);
    }
}
