package edu.apis.restTemplate.controller;

import edu.apis.restTemplate.model.UniversityDTO;
import edu.apis.restTemplate.service.UniversityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "universities")
@AllArgsConstructor
public class UniversityController {

    private final UniversityService service;

    @GetMapping
    public ResponseEntity<List<UniversityDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<UniversityDTO> getByName(@PathVariable String name) throws Exception {
        Optional<UniversityDTO> uni = service.getByName(name);
        if(uni.isPresent()) return new ResponseEntity<>(uni.get(), HttpStatus.OK);
        else throw new Exception("Uni Not Found");//improve exception

    }
}
