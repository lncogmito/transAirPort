package com.spring.henallux.transAirPort.dataAccess.util;

import com.spring.henallux.transAirPort.dataAccess.entity.UserEntity;
import com.spring.henallux.transAirPort.model.User;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {
    private Mapper mapper = new DozerBeanMapper();

    public UserEntity userModeltoUserEntity(User user){
        return mapper.map(user,UserEntity.class);
    }

    public User userEntitytoUserModel(UserEntity userEntity){
        return mapper.map(userEntity, User.class);
    }

}
