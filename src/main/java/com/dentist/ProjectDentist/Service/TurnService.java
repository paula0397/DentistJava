package com.dentist.ProjectDentist.Service;

import com.dentist.ProjectDentist.entity.Turn;
import com.dentist.ProjectDentist.exceptions.BadRequestException;
import com.dentist.ProjectDentist.exceptions.ResourceNotFoundException;
import com.dentist.ProjectDentist.repository.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnService {

    private final TurnRepository turnRepository;

    @Autowired
    public TurnService(TurnRepository turnRepository) {
        this.turnRepository = turnRepository;
    }

    public Turn registerTurn (Turn turn){
        return turnRepository.save(turn);
    }

    public List<Turn> listTurn(){
        return turnRepository.findAll();
    }

    public Optional<Turn> searchTurn(Integer id) throws BadRequestException, ResourceNotFoundException {
        if(!turnRepository.existsById(id))
            throw new ResourceNotFoundException("There is not shift with ID: " + id);
        return turnRepository.findById(id);
    }

    public void deleteTurn(Integer id) throws ResourceNotFoundException, BadRequestException{
        if( searchTurn(id).isEmpty())
            throw new ResourceNotFoundException("There is not shift with ID: " + id);
        turnRepository.deleteById(id);
    }

    public Turn updateTurn(Turn turn) throws ResourceNotFoundException, BadRequestException {
        if(searchTurn(turn.getId()).isEmpty())
            throw new BadRequestException("There is not shift with ID: " + turn.getId());
        return turnRepository.save(turn);
    }
}
