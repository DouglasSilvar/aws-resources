package com.aws.cep.awscep.rds.service;

import com.aws.cep.awscep.dto.AddressDTO;
import com.aws.cep.awscep.entity.Address;
import com.aws.cep.awscep.rds.repository.AddressRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository repository;
    private final ModelMapper mapper;

    public AddressDTO findById(String cep){
        log.info("RDS - Starting get cep on RDS: "+ cep);
        var address = this.repository.findById(cep);
        if (address.isEmpty()){
            log.info("RDS - Cep on RDS Not Found : "+ cep);
            return null;
        } else {
            log.info("RDS - Find cep on RDS: "+ address.toString());
            return this.mapper.map(address,AddressDTO.class);
        }
    }

    public void insert(AddressDTO address){
        log.info("RDS - Starting save address on RDS: "+ address.toString());
        this.repository.save(mapper.map(address, Address.class));
        log.info("RDS - Finshing save address on RDS: "+ address.toString());
    }

}
