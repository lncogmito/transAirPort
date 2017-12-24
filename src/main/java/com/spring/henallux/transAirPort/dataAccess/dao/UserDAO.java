package com.spring.henallux.transAirPort.dataAccess.dao;

import com.spring.henallux.transAirPort.dataAccess.entity.UserEntity;
import com.spring.henallux.transAirPort.dataAccess.repository.UserRepository;
import com.spring.henallux.transAirPort.dataAccess.util.ProviderConverter;
import com.spring.henallux.transAirPort.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDAO {
    private UserRepository userRepository;
    private static ProviderConverter providerConverter;

    public UserDAO(UserRepository userRepository,ProviderConverter providerConverter){
        this.providerConverter = providerConverter;
        this.userRepository = userRepository;
    }

    public User findModelByUsername(String username){
        UserEntity userEntity = userRepository.findByUsername(username);
        return providerConverter.userEntitytoUserModel(userEntity);
    }

    public boolean save(UserEntity userEntity){
        if(userRepository.save(userEntity) != null)
            return true;
        else
            return false;
    }

    public UserEntity findEntityByUsername(String username){
        return userRepository.findByUsername(username);
    }


}
