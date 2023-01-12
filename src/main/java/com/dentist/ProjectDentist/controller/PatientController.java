package com.dentist.ProjectDentist.controller;


import com.dentist.ProjectDentist.Service.PatientService;
import com.dentist.ProjectDentist.entity.Patient;
import com.dentist.ProjectDentist.exceptions.BadRequestException;
import com.dentist.ProjectDentist.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> searchPatientAll(){
        return ResponseEntity.ok(patientService.searchAllPatient());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> searchByIdPatient (@PathVariable Integer id) throws BadRequestException, ResourceNotFoundException {
        Patient patient = patientService.searchPatient(id).orElse(null);
        return ResponseEntity.ok(patient);
    }

    @PostMapping()
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) throws BadRequestException, ResourceNotFoundException{
        patientService.savePatient(patient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Patient> updatePatient (@RequestBody Patient patient) throws BadRequestException, ResourceNotFoundException {
        return ResponseEntity.ok(patientService.updatePatient(patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePatientById(@PathVariable Integer id) throws ResourceNotFoundException, BadRequestException{
        patientService.deletePatient(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
