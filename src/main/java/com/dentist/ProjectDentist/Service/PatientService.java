package com.dentist.ProjectDentist.Service;

import com.dentist.ProjectDentist.entity.Address;
import com.dentist.ProjectDentist.entity.Patient;
import com.dentist.ProjectDentist.exceptions.BadRequestException;
import com.dentist.ProjectDentist.exceptions.ResourceNotFoundException;
import com.dentist.ProjectDentist.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Optional<Patient> searchPatient(Integer id) throws BadRequestException{
        if (!patientRepository.existsById(id))
            throw new BadRequestException("The patient with ID does not exist " + id);
        return patientRepository.findById(id);
    }

    public List<Patient> searchAllPatient(){
        return patientRepository.findAll();
    }

    public void deletePatient(Integer id) throws ResourceNotFoundException, BadRequestException{
        if(searchPatient(id).isEmpty())
            throw new ResourceNotFoundException("The patient with ID does not exist " + id);
        patientRepository.deleteById(id);
    }

    public Patient updatePatient(Patient patient) throws ResourceNotFoundException, BadRequestException{
        if(searchPatient(patient.getId()).isEmpty())
            throw new ResourceNotFoundException("The patient with ID does not exist " + patient.getId());
        return patientRepository.save(patient);
    }
}
