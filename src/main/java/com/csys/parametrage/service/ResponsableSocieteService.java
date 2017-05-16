package com.csys.parametrage.service;

import com.csys.parametrage.domain.ResponsaleContacte;
import com.csys.parametrage.dto.ResponsableSocieteDTO;
import com.csys.parametrage.dto.ResponsaleContacteDTO;
import com.csys.parametrage.factory.ResponsableSocieteFactory;
import com.csys.parametrage.repository.ResponsableSocieteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Collection;

/**
 * Service Implementation for managing Banque.
 */
@Service("ResponsableSocieteService")
@Transactional
public class ResponsableSocieteService {

    private final Logger log = LoggerFactory.getLogger(ResponsableSocieteService.class);

    private final ResponsableSocieteRepository responsableSocieteRepository;


    public ResponsableSocieteService(ResponsableSocieteRepository responsableSocieteRepository) {
        this.responsableSocieteRepository = responsableSocieteRepository;
    }

    @Transactional(readOnly = true)
    public List<ResponsableSocieteDTO> findByCodeFonctionResponsableSociete(Integer codeResponsable) {
        return ResponsableSocieteFactory.listResponsableSocieteToListResponsableSocieteDTO(responsableSocieteRepository.findByCodeFonctionResponsableSocieteCode(codeResponsable));    
    }
}
