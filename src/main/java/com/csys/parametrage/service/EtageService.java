package com.csys.parametrage.service;

import com.csys.parametrage.domain.Etage;
import com.csys.parametrage.dto.ChambreDTO;
import com.csys.parametrage.dto.EtageDTO;
import com.csys.parametrage.factory.EtageFactory;
import com.csys.parametrage.repository.EtageRepository;
import com.google.common.base.Preconditions;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Service Implementation for managing Etage.
 */
@Service
@Transactional
public class EtageService {

    private final Logger log = LoggerFactory.getLogger(EtageService.class);

    private final EtageRepository etageRepository;

    private final ChambreService chambreService;

    public EtageService(EtageRepository etageRepository, ChambreService chambreService) {
        this.etageRepository = etageRepository;
        this.chambreService = chambreService;
    }

    /**
     * Save a etage.
     *
     * @param etagedto the entity to save
     * @return the persisted entity
     */
    public Boolean save(EtageDTO etagedto) {
        log.debug("Request to save Etage : {}", etagedto);
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Etage etage = EtageFactory.createEtage(etagedto,user);
        etageRepository.save(etage);
        return true;
    }

    /**
     * Get all the etages.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Collection<EtageDTO> findAll() {
        log.debug("Request to get all Etages");
        List<Etage> result = etageRepository.findAll();
        return EtageFactory.etageCollectionToEtageDTOCollection(result);
    }

    /**
     * Get one etage by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public EtageDTO findOne(Integer id) {
        log.debug("Request to get Etage : {}", id);
        Etage etage = etageRepository.findOne(id);
        Preconditions.checkArgument(etage != null, "error.ressourceNotFound");
        return EtageFactory.etageTOEtageDTO(etage);
    }

    /**
     * Delete the etage by id.
     *
     * @param id the id of the entity
     */
    public void delete(Integer id) {
        log.debug("Request to delete Etage : {}", id);
        Preconditions.checkArgument(id != null, "error.ressourceNotFound");
        Preconditions.checkArgument(etageRepository.exists(id), "error.ressourceNotFound");
        Collection<ChambreDTO> chambre = chambreService.findByCodeEtageCode(id);
        Preconditions.checkArgument(chambre.isEmpty(), "error.ressourceMouvmente");
        etageRepository.delete(id);
    }
    
     public Boolean update(EtageDTO etageDTO) {
        log.debug("Request to update etage : {}", etageDTO);
        Preconditions.checkArgument((etageDTO.getCode() != null), "error.ressourceNotFound");
        Etage etage = etageRepository.findOne(etageDTO.getCode());
        Preconditions.checkArgument(etage != null, "error.ressourceNotFound");
        EtageFactory.etageDTOTOEtage(etageDTO, etage);
        etageRepository.save(etage);
        return true;
    }
     
     
      @Transactional(readOnly = true)
    public Collection<EtageDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get etage by actif : {}", actif);
        List<Etage> etages = etageRepository.findByActifIn(actif);
        return EtageFactory.etageCollectionToEtageDTOCollection(etages);
    }
}
