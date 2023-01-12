package com.dentist.ProjectDentist.Service;

import com.dentist.ProjectDentist.entity.Address;
import com.dentist.ProjectDentist.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address saveAddress( Address address){
        addressRepository.save(address);
        return address;
    }

    public Optional<Address> searchAddress(Integer id){
        return Optional.of(addressRepository.getOne(Integer.valueOf(id)));
    }

    public List<Address> searchAddressAll(){
        return addressRepository.findAll();
    }

    public void deleteAddress(Integer id){
        addressRepository.deleteById(Integer.valueOf(id));
    }

}
