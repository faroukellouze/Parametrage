package com.csys.parametrage.service;

import com.csys.parametrage.domain.Tva;
import com.csys.parametrage.domain.TypePrestation;
import com.csys.parametrage.dto.TvaDTO;
import com.csys.parametrage.dto.TypePrestationDTO;
import com.csys.parametrage.factory.TvaFactory;
import com.csys.parametrage.factory.TypePrestationFactory;
import com.csys.parametrage.repository.TvaRepository;
import com.google.common.base.Preconditions;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import org.mapstruct.factory.Mappers;

/**
 * Service Implementation for managing Tva.
 */
@Service
@Transactional
public class TvaService {

    private final Logger log = LoggerFactory.getLogger(TvaService.class);
    
    private final TvaRepository tvaRepository;

    public TvaService(TvaRepository tvaRepository) {
        this.tvaRepository = tvaRepository;
    }
    /**
     *  Get all the tvas.
     *  
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<TvaDTO> findAll() {
        log.debug("Request to get all Tvas");
        List<Tva> result = tvaRepository.findAll();
        return TvaFactory.listTvaTOlistTvaDTO(result);
    }

    /**
     *  Get one tva by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public TvaDTO findOne(String id) {
        log.debug("Request to get Tva : {}", id);
        Tva tva = tvaRepository.findOne(id);
        Preconditions.checkArgument((tva != null), "error.ressourceNotFound");
        return TvaFactory.tvaTOTvaDTO(tva);
    }
  
     @Transactional(readOnly = true)
    public Collection<TvaDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get Tva by actif : {}", actif);
        List<Tva> tva = tvaRepository.findByActifIn(actif);
        return TvaFactory.listTvaTOlistTvaDTO(tva);
    }
}
