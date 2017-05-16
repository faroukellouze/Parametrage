package com.csys.parametrage.service;

import com.csys.parametrage.domain.ModeReglement;
import com.csys.parametrage.dto.ModeReglementDTO;
import com.csys.parametrage.dto.SocieteDTO;
import com.csys.parametrage.factory.ModeReglementFactory;
import com.csys.parametrage.repository.ModeReglementRepository;
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
 * Service Implementation for managing ModeReglement.
 */
@Service
@Transactional
public class ModeReglementService {
    
    private final Logger log = LoggerFactory.getLogger(ModeReglementService.class);
    
    private final ModeReglementRepository modeReglementRepository;
    
    private final SocieteService societeService;
    
    public ModeReglementService(ModeReglementRepository modeReglementRepository, SocieteService societeService) {
        this.modeReglementRepository = modeReglementRepository;
        this.societeService = societeService;
    }

    /**
     * Save a modeReglement.
     *
     * @param modeReglementDTO the entity to save
     * @return the persisted entity
     */
    public ModeReglement save(ModeReglementDTO modeReglementDTO) {
        log.debug("Request to save ModeReglement : {}", modeReglementDTO);
        ModeReglement modeReglement = ModeReglementFactory.modeReglementDTOToModeReglement(modeReglementDTO);
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        modeReglement.setUserCreation(user);
        modeReglement.setDateCreation(new Date());
        modeReglement.setCode(null);
        ModeReglement result = modeReglementRepository.save(modeReglement);
        return result;
    }

    /**
     * Get all the modeReglements.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<ModeReglementDTO> findAll() {
        log.debug("Request to get all ModeReglements");
        List<ModeReglement> result = modeReglementRepository.findAll();
        return ModeReglementFactory.listModeReglementToListModeReglementDTO(result);
    }

    /**
     * Get one modeReglement by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public ModeReglementDTO findOne(Integer id) {
        log.debug("Request to get ModeReglement : {}", id);
        ModeReglement modeReglement = modeReglementRepository.findOne(id);
        Preconditions.checkArgument((modeReglement != null), "error.ressourceNotFound");
        return ModeReglementFactory.modeReglementToModeReglementDTO(modeReglement);
    }

    /**
     * Delete the modeReglement by id.
     *
     * @param id the id of the entity
     */
    public void delete(Integer id) {
        log.debug("Request to delete ModeReglement : {}", id);
        Preconditions.checkArgument(modeReglementRepository.exists(id), "error.ressourceNotFound");
        List<SocieteDTO> societe = societeService.findByCodeModeReglement(id);
        Preconditions.checkArgument(societe.isEmpty(), "error.ressourceMouvmente");
        modeReglementRepository.delete(id);
    }
    
    public ModeReglement update(ModeReglementDTO modeReglementDTO) {
        log.debug("Request to update ModeReglement : {}", modeReglementDTO);
        ModeReglement modReg = ModeReglementFactory.modeReglementDTOToModeReglement(modeReglementDTO);
        Preconditions.checkArgument((modeReglementRepository.exists(modReg.getCode())), "error.ressourceNotFound");
        return modeReglementRepository.save(modReg);
    }
    
    @Transactional(readOnly = true)
    public Collection<ModeReglementDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get ModeReglement by actif : {}", actif);
        List<ModeReglement> modeReg = modeReglementRepository.findByActifIn(actif);
        return ModeReglementFactory.listModeReglementToListModeReglementDTO(modeReg);
    }
    
}
