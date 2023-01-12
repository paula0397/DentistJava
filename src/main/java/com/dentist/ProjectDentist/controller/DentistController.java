package com.dentist.ProjectDentist.controller;

import com.dentist.ProjectDentist.Service.DentistService;
import com.dentist.ProjectDentist.entity.Dentist;
import com.dentist.ProjectDentist.entity.DentistDTO;
import com.dentist.ProjectDentist.exceptions.BadRequestException;
import com.dentist.ProjectDentist.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    @Autowired
    private DentistService dentistService;

    @PostMapping()
    public ResponseEntity<?> registerDentist(@RequestBody DentistDTO dentistDTO) throws BadRequestException {
        dentistService.registerDentist(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Dentist>> searchAll(){

        return ResponseEntity.ok(dentistService.searchAll());
    }

    @PutMapping()
    public ResponseEntity<Dentist> updateDentist (@RequestBody Dentist dentist) throws BadRequestException, ResourceNotFoundException {
        return ResponseEntity.ok(dentistService.updateDentist(dentist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) throws ResourceNotFoundException, BadRequestException{
        dentistService.deleteDentist(id);
        return ResponseEntity.ok("Remove dentist with id " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentist> searchById (@PathVariable Integer id) throws BadRequestException, ResourceNotFoundException{
        Dentist dentist = dentistService.searchDentist(id).orElse(null);
        return ResponseEntity.ok(dentist);
    }

    @GetMapping("/bring/{lastName}")
    public ResponseEntity<Dentist> dentistLastName(@PathVariable String lastName){
        Dentist dentist = dentistService.searchByLastName(lastName);
        if (dentist != null){
            return  ResponseEntity.ok(dentist);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
