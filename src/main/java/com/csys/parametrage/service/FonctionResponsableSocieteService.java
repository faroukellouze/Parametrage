package com.csys.parametrage.service;

import com.csys.parametrage.domain.FonctionResponsableSociete;
import com.csys.parametrage.dto.FonctionResponsableSocieteDTO;
import com.csys.parametrage.dto.ResponsableSocieteDTO;
import com.csys.parametrage.factory.FonctionResponsableSocieteFactory;
import com.csys.parametrage.repository.FonctionResponsableSocieteRepository;
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
 * Service Implementation for managing FonctionResponsableSociete.
 */
@Service
@Transactional
public class FonctionResponsableSocieteService {
    
    private final Logger log = LoggerFactory.getLogger(FonctionResponsableSocieteService.class);
    
    private final FonctionResponsableSocieteRepository fonctionResponsableSocieteRepository;
    
    private final ResponsableSocieteService responsableSocieteService;
    
    public FonctionResponsableSocieteService(FonctionResponsableSocieteRepository fonctionResponsableSocieteRepository, ResponsableSocieteService responsableSocieteService) {
        this.fonctionResponsableSocieteRepository = fonctionResponsableSocieteRepository;
        this.responsableSocieteService = responsableSocieteService;
    }

    /**
     * Save a fonctionResponsableSociete.
     *
     * @param fonctionResponsableSocieteDTO the entity to save
     * @return the persisted entity
     */
    public FonctionResponsableSociete save(FonctionResponsableSocieteDTO fonctionResponsableSocieteDTO) {
        log.debug("Request to save FonctionResponsableSociete : {}", fonctionResponsableSocieteDTO);
        FonctionResponsableSociete fonctionResponsableSociete = FonctionResponsableSocieteFactory.fonctionResponsableSocieteDTOToFonctionResponsableSociete(fonctionResponsableSocieteDTO);
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        fonctionResponsableSociete.setUserCreation(user);
        fonctionResponsableSociete.setDateCreation(new Date());
        fonctionResponsableSociete.setCode(null);
        return fonctionResponsableSocieteRepository.save(fonctionResponsableSociete);
    }

    /**
     * Get all the fonctionResponsableSocietes.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<FonctionResponsableSocieteDTO> findAll() {
        log.debug("Request to get all FonctionResponsableSocietes");
        List<FonctionResponsableSociete> result = fonctionResponsableSocieteRepository.findAll();
        return FonctionResponsableSocieteFactory.listFonctionResponsableSocieteToListFonctionResponsableSocieteDTO(result);
    }

    /**
     * Get one fonctionResponsableSociete by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public FonctionResponsableSocieteDTO findOne(Integer id) {
        log.debug("Request to get FonctionResponsableSociete : {}", id);
        FonctionResponsableSociete fonctionResponsableSociete = fonctionResponsableSocieteRepository.findOne(id);
        Preconditions.checkArgument((fonctionResponsableSociete != null), "error.ressourceNotFound");
        return FonctionResponsableSocieteFactory.fonctionResponsableSocieteToFonctionResponsableSocieteDTO(fonctionResponsableSociete);
    }

    /**
     * Delete the fonctionResponsableSociete by id.
     *
     * @param id the id of the entity
     */
    public void delete(Integer id) {
        log.debug("Request to delete FonctionResponsableSociete : {}", id);
        Preconditions.checkArgument(fonctionResponsableSocieteRepository.exists(id), "error.ressourceNotFound");
        Collection<ResponsableSocieteDTO> piece = responsableSocieteService.findByCodeFonctionResponsableSociete(id);
        Preconditions.checkArgument(piece.isEmpty(), "error.ressourceMouvmente");
        
        fonctionResponsableSocieteRepository.delete(id);
    }
    
    public FonctionResponsableSociete update(FonctionResponsableSocieteDTO fonctionResponsableDTO) {
        log.debug("Request to update FonctionResponsableSociete : {}", fonctionResponsableDTO);
        FonctionResponsableSociete fonctionResponsableSociete = FonctionResponsableSocieteFactory.fonctionResponsableSocieteDTOToFonctionResponsableSociete(fonctionResponsableDTO);
        Preconditions.checkArgument((fonctionResponsableSocieteRepository.exists(fonctionResponsableSociete.getCode())), "error.ressourceNotFound");
        return fonctionResponsableSocieteRepository.save(fonctionResponsableSociete);
    }
    
    @Transactional(readOnly = true)
    public Collection<FonctionResponsableSocieteDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get FonctionResponsableSociete by actif : {}", actif);
        List<FonctionResponsableSociete> modeReg = fonctionResponsableSocieteRepository.findByActifIn(actif);
        return FonctionResponsableSocieteFactory.listFonctionResponsableSocieteToListFonctionResponsableSocieteDTO(modeReg);
    }
    
}
