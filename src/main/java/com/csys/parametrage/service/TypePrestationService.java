package com.csys.parametrage.service;

import com.csys.parametrage.domain.TypePrestation;
import com.csys.parametrage.dto.TypePrestationDTO;
import com.csys.parametrage.factory.TypePrestationFactory;
import com.csys.parametrage.repository.TypePrestationRepository;
import com.google.common.base.Preconditions;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Implementation for managing TypePrestation.
 */
@Service
@Transactional
public class TypePrestationService {

    private final Logger log = LoggerFactory.getLogger(TypePrestationService.class);

    private final TypePrestationRepository typePrestationRepository;

    public TypePrestationService(TypePrestationRepository typePrestationRepository) {
        this.typePrestationRepository = typePrestationRepository;
    }

    /**
     * Get all the typePrestations.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<TypePrestationDTO> findAll() {
        log.debug("Request to get all TypePrestations");
        List<TypePrestation> result = typePrestationRepository.findAll();
        return TypePrestationFactory.listTypePrestationTOlistTypePrestationDTO(result);
    }

    /**
     * Get one typePrestation by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public TypePrestationDTO findOne(Integer id) {
        log.debug("Request to get TypePrestation : {}", id);
        TypePrestation typePrestation = typePrestationRepository.findOne(id);
        Preconditions.checkArgument((typePrestation != null), "error.ressourceNotFound");
        return TypePrestationFactory.typePrestationTOTypePrestationDTO(typePrestation);
    }

    @Transactional(readOnly = true)
    public Collection<TypePrestationDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get TypePrestation by actif : {}", actif);
        List<TypePrestation> typePrestation = typePrestationRepository.findByActifIn(actif);
        return TypePrestationFactory.listTypePrestationTOlistTypePrestationDTO(typePrestation);
    }
}
