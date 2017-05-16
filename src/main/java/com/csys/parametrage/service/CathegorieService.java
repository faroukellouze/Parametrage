package com.csys.parametrage.service;

import com.csys.parametrage.domain.Cathegorie;
import com.csys.parametrage.dto.CathegorieDTO;
import com.csys.parametrage.dto.ChambreDTO;
import com.csys.parametrage.factory.CathegorieFactory;
import com.csys.parametrage.repository.CathegorieRepository;
import com.google.common.base.Preconditions;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Service Implementation for managing Cathegorie.
 */
@Service
@Transactional
public class CathegorieService {

    private final Logger log = LoggerFactory.getLogger(CathegorieService.class);

    private final CathegorieRepository cathegorieRepository;

    private final ChambreService chambreService;

    public CathegorieService(CathegorieRepository cathegorieRepository, ChambreService chambreService) {
        this.cathegorieRepository = cathegorieRepository;
        this.chambreService = chambreService;
    }

    /**
     * Save a cathegorie.
     *
     * @param cathegoriedto the entity to save
     * @return the persisted entity
     */
    public Boolean save(CathegorieDTO cathegoriedto) {
        log.debug("Request to save Cathegorie : {}", cathegoriedto);
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Cathegorie cathegorie = CathegorieFactory.createCathegorie(cathegoriedto,user);
        cathegorieRepository.save(cathegorie);
        return true;
    }

    /**
     * Get all the cathegories.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Collection<CathegorieDTO> findAll() {
        log.debug("Request to get all Cathegories");
        List<Cathegorie> result = cathegorieRepository.findAll();
        return CathegorieFactory.cathegorieCollectionToCathegorieDTOCollection(result);
    }

    /**
     * Get one cathegorie by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public CathegorieDTO findOne(Integer id) {
        log.debug("Request to get Cathegorie : {}", id);
        Cathegorie cathegorie = cathegorieRepository.findOne(id);
        Preconditions.checkArgument(cathegorie != null, "error.ressourceNotFound");
        return CathegorieFactory.cathegorieTOCathegorieDTO(cathegorie);
    }

    /**
     * Delete the cathegorie by id.
     *
     * @param id the id of the entity
     */
    public void delete(Integer id) {
        log.debug("Request to delete Cathegorie : {}", id);
        Preconditions.checkArgument(id != null, "error.ressourceNotFound");
        Preconditions.checkArgument(cathegorieRepository.exists(id), "error.ressourceNotFound");
        Collection<ChambreDTO> chambre = chambreService.findByCodeCathegorieCode(id);
        Preconditions.checkArgument(chambre.isEmpty(), "error.ressourceMouvmente");
        cathegorieRepository.delete(id);
    }

    public Boolean update(CathegorieDTO cathegorieDTO) {
        log.debug("Request to update cathegorie : {}", cathegorieDTO);
        Preconditions.checkArgument((cathegorieDTO.getCode() != null), "error.ressourceNotFound");
        Cathegorie cathegorie = cathegorieRepository.findOne(cathegorieDTO.getCode());
        Preconditions.checkArgument(cathegorie != null, "error.ressourceNotFound");
        CathegorieFactory.cathegorieDTOTOCathegorie(cathegorieDTO, cathegorie);
        cathegorieRepository.save(cathegorie);
        return true;
    }
    
    
    @Transactional(readOnly = true)
    public Collection<CathegorieDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get Chambre by actif : {}", actif);
        List<Cathegorie> cathegorie = cathegorieRepository.findByActifIn(actif);
        return CathegorieFactory.cathegorieCollectionToCathegorieDTOCollection(cathegorie);
    }
}
