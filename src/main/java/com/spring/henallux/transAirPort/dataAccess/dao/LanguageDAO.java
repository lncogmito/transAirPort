package com.spring.henallux.transAirPort.dataAccess.dao;


import com.spring.henallux.transAirPort.dataAccess.entity.LanguageEntity;
import com.spring.henallux.transAirPort.dataAccess.repository.LanguageRepository;
import com.spring.henallux.transAirPort.dataAccess.util.ProviderConverter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Provider;

@Service
@Transactional
public class LanguageDAO {
    private static ProviderConverter providerConverter = new ProviderConverter();
    private LanguageRepository languageRepository;

    public LanguageDAO(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public LanguageEntity findEntityByName(String name){
        return languageRepository.findByName(name);
    }
}
