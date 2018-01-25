package com.spring.henallux.transAirPort.dataAccess.repository;

import com.spring.henallux.transAirPort.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);
    UserEntity save(UserEntity userEntity);
}