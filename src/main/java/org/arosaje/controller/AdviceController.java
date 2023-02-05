package org.arosaje.controller;

import org.arosaje.dto.AdviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AdviceController {

    @Autowired
    private org.arosaje.repository.AdviceRepositoryImpl AdviceRepositoryImpl;

    @RequestMapping(method = RequestMethod.GET, value ="/v1/getAdviceByPlantId")
    public List<AdviceDTO> getAdviceByPlantId(@RequestParam(name="id") long id) {
        return AdviceRepositoryImpl.getAdviceByPlantId(id);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/v1/getAdviceById")
    public Object getAdviceById(@RequestParam(name="id") long id) {
        return AdviceRepositoryImpl.getAdviceById(id);
    }
}
