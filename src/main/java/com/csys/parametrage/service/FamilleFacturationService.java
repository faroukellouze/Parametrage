package com.csys.parametrage.service;

import com.csys.parametrage.domain.FamilleFacturation;
import com.csys.parametrage.dto.FamilleFacturationDTO;
import com.csys.parametrage.factory.FamilleFacturationFactory;
import com.csys.parametrage.repository.FamilleFacturationRepository;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Implementation for managing FamilleFacturation.
 */
@Service
@Transactional
public class FamilleFacturationService {

    private final Logger log = LoggerFactory.getLogger(FamilleFacturationService.class);
    
    private final FamilleFacturationRepository familleFacturationRepository;

    public FamilleFacturationService(FamilleFacturationRepository familleFacturationRepository) {
        this.familleFacturationRepository = familleFacturationRepository;
    }

    /**
     *  Get all the familleFacturations.
     *  
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<FamilleFacturationDTO> findAll() {
        log.debug("Request to get all FamilleFacturations");
        List<FamilleFacturation> result = familleFacturationRepository.findAll();
        return FamilleFacturationFactory.listFamilleFacturationTOlistFamilleFacturationDTO(result);
    }

    /**
     *  Get one familleFacturation by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public FamilleFacturationDTO findOne(Integer id) {
        log.debug("Request to get FamilleFacturation : {}", id);
        FamilleFacturation familleFacturation = familleFacturationRepository.findOne(id);
        Preconditions.checkArgument((familleFacturation != null), "error.ressourceNotFound");
        return FamilleFacturationFactory.familleFacturationTOFamilleFacturationDTO(familleFacturation);
    }

}
