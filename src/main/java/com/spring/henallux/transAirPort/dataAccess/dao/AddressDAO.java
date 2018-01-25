package com.spring.henallux.transAirPort.dataAccess.dao;

import com.spring.henallux.transAirPort.dataAccess.entity.AddressEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.LocalityEntity;
import com.spring.henallux.transAirPort.dataAccess.repository.AddressRepository;
import com.spring.henallux.transAirPort.dataAccess.repository.LocalityRepository;
import com.spring.henallux.transAirPort.dataAccess.util.ProviderConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressDAO {
    private AddressRepository addressRepository;
    private LocalityRepository localityRepository;
    private static ProviderConverter providerConverter;

    public AddressDAO(AddressRepository addressRepository,ProviderConverter providerConverter, LocalityRepository localityRepository){
        this.providerConverter = providerConverter;
        this.addressRepository = addressRepository;
        this.localityRepository = localityRepository;
    }

    public AddressEntity findOne(Long id){
        return addressRepository.findOne(id);
    }

    public LocalityEntity saveLocality(LocalityEntity localityEntity){
        return localityRepository.save(localityEntity);
    }
    public void saveAddress(AddressEntity addressEntity){
        addressRepository.save(addressEntity);
    }
    public LocalityEntity findOneByNameAndPostalCode(String name, int postalCode){
        return localityRepository.findOneByNameAndPostalCode(name, postalCode);
    }
    public AddressEntity findOneByStreetAndHouseNumber(String street, String houseNumber){
        return addressRepository.findOneByStreetAndHouseNumber(street,houseNumber);
    }
    public AddressEntity findOneByStreetAndHouseNumberAndBoxNumber(String street,String houseNumber, String boxNumber){
        return addressRepository.findOneByStreetAndHouseNumberAndBoxNumber(street,houseNumber,boxNumber);
    }
}
