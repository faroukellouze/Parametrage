package com.csys.parametrage.service;

import com.csys.parametrage.domain.FamillePrestation;
import com.csys.parametrage.domain.Prestation;
import com.csys.parametrage.domain.SousFamillePrestation;
import com.csys.parametrage.dto.PrestationDTO;
import com.csys.parametrage.dto.SousFamillePrestationDTO;
import com.csys.parametrage.factory.SousFamillePrestationFactory;
import com.csys.parametrage.repository.SousFamillePrestationRepository;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Service Implementation for managing SousFamillePrestation.
 */
@Service
@Transactional
public class SousFamillePrestationService {
    
    private final Logger log = LoggerFactory.getLogger(SousFamillePrestationService.class);
    
    private final SousFamillePrestationRepository sousFamillePrestationRepository;
    
    private final PrestationService prestationService;
    
    public SousFamillePrestationService(SousFamillePrestationRepository sousFamillePrestationRepository, PrestationService prestationService) {
        this.sousFamillePrestationRepository = sousFamillePrestationRepository;
        this.prestationService = prestationService;
    }

    /**
     * Save a sousFamillePrestation.
     *
     * @param sousFamillePrestationDTO the entity to save
     * @return the persisted entity
     */
    public Boolean save(SousFamillePrestationDTO sousFamillePrestationDTO) {
        log.debug("Request to save SousFamillePrestation : {}", sousFamillePrestationDTO);
        
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        sousFamillePrestationDTO.setCode(null);
        SousFamillePrestation sousFamillePrestation = new SousFamillePrestation();
        sousFamillePrestation = SousFamillePrestationFactory.sousFamillePrestationDTOTOSousFamillePrestation(sousFamillePrestationDTO, sousFamillePrestation);
        sousFamillePrestation.setUserCreation(user);
        sousFamillePrestation.setDateCreation(new Date());
        sousFamillePrestationRepository.save(sousFamillePrestation);
        return true;
    }

    /**
     * Get all the sousFamillePrestations.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<SousFamillePrestationDTO> findAll() {
        log.debug("Request to get all SousFamillePrestations");
        List<SousFamillePrestation> result = sousFamillePrestationRepository.findAll();
        return SousFamillePrestationFactory.listSousFamillePrestationTOlistSousFamillePrestationDTO(result);
    }

    /**
     * Get one sousFamillePrestation by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public SousFamillePrestationDTO findOne(Integer id) {
        log.debug("Request to get SousFamillePrestation : {}", id);
        SousFamillePrestation sousFamillePrestation = sousFamillePrestationRepository.findOne(id);
        Preconditions.checkArgument((sousFamillePrestation != null), "error.ressourceNotFound");
        return SousFamillePrestationFactory.sousFamillePrestationTOSousFamillePrestationDTO(sousFamillePrestation);
    }

    /**
     * Delete the sousFamillePrestation by id.
     *
     * @param id the id of the entity
     */
    public void delete(Integer id) {
        log.debug("Request to delete SousFamillePrestation : {}", id);
        Preconditions.checkArgument(sousFamillePrestationRepository.exists(id), "error.ressourceNotFound");
        List<PrestationDTO> prestation = prestationService.findByCodeSousFamilleCode(id);
        Preconditions.checkArgument(prestation.isEmpty(), "error.ressourceMouvmente");
        sousFamillePrestationRepository.delete(id);
    }
    
    public Boolean update(SousFamillePrestationDTO sousFamillePrestationDTO) {
        log.debug("Request to update SousFamillePrestation : {}", sousFamillePrestationDTO);
        Preconditions.checkArgument((sousFamillePrestationDTO.getCode() != null), "error.ressourceNotFound");
        SousFamillePrestation sousFamillePrestation = sousFamillePrestationRepository.findOne(sousFamillePrestationDTO.getCode());
        Preconditions.checkArgument(sousFamillePrestation != null, "error.ressourceNotFound");
        SousFamillePrestationFactory.sousFamillePrestationDTOTOSousFamillePrestation(sousFamillePrestationDTO, sousFamillePrestation);
        sousFamillePrestationRepository.save(sousFamillePrestation);
        return true;
    }
    
    @Transactional(readOnly = true)
    public List<SousFamillePrestationDTO> findByCodeFamilleCode(Integer codeFamille) {
        log.debug("Request to get SousFamillePrestation : {}", codeFamille);
        List<SousFamillePrestation> sousFamillePrestation = sousFamillePrestationRepository.findByCodeFamilleCode(codeFamille);
        return SousFamillePrestationFactory.listSousFamillePrestationTOlistSousFamillePrestationDTO(sousFamillePrestation);
    }
    
     @Transactional(readOnly = true)
    public List<SousFamillePrestationDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get SousFamillePrestation by actif : {}", actif);
        List<SousFamillePrestation> souFam = sousFamillePrestationRepository.findByActifIn(actif);
        return SousFamillePrestationFactory.listSousFamillePrestationTOlistSousFamillePrestationDTO(souFam);
    }
    
    
    @Transactional(readOnly = true)
    public List<SousFamillePrestationDTO> findByCodeFamilleCodeTypePrestationCodeAndActifIn(Integer codeTypePrestation,Collection<Boolean> actif) {
        log.debug("Request to get SousFamillePrestation by codeTypePrestation and actif: {}", codeTypePrestation);
        List<SousFamillePrestation> sousFamillePrestation = sousFamillePrestationRepository.findByCodeFamilleCodeTypePrestationCodeAndActifIn(codeTypePrestation ,actif);
        return SousFamillePrestationFactory.listSousFamillePrestationTOlistSousFamillePrestationDTO(sousFamillePrestation);
    }
}
