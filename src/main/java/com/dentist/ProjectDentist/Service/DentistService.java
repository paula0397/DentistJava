package com.dentist.ProjectDentist.Service;

import com.dentist.ProjectDentist.entity.Dentist;
import com.dentist.ProjectDentist.entity.DentistDTO;
import com.dentist.ProjectDentist.exceptions.BadRequestException;
import com.dentist.ProjectDentist.exceptions.ResourceNotFoundException;
import com.dentist.ProjectDentist.repository.DentistRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService {

    private final DentistRepository dentistRepository;

    @Autowired
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Autowired
    ObjectMapper mapper;

    private void saveDentist(DentistDTO dentistDTO){
        Dentist dentist = mapper.convertValue(dentistDTO, Dentist.class);
        dentistRepository.save(dentist);
    }
    public void registerDentist(DentistDTO dentistDTO){
        saveDentist(dentistDTO);
    }

    public Dentist registerDentist(Dentist dentist){
        return dentistRepository.save(dentist);
    }

    public Optional<Dentist> searchDentist(Integer id) throws BadRequestException {
        if(!dentistRepository.existsById(id))
            throw new BadRequestException("There is no dentist with id " + id);
        return dentistRepository.findById(id);
    }

    public Dentist updateDentist (Dentist dentist) throws ResourceNotFoundException, BadRequestException{
        if (searchDentist(dentist.getId()).isEmpty())
            throw new ResourceNotFoundException("There is no dentist with id " + dentist.getId());
        return dentistRepository.save(dentist);
    }

    public void deleteDentist(Integer id) throws ResourceNotFoundException, BadRequestException {
        if (searchDentist(id).isEmpty())
            throw new ResourceNotFoundException("There is no dentist with id " + id);
        dentistRepository.deleteById(id);
    }

    public List<Dentist> searchAll(){
        return dentistRepository.findAll();
    }

    public Dentist searchByLastName(String lastName){
        return dentistRepository.dentistByLastName(lastName);
    }
}
