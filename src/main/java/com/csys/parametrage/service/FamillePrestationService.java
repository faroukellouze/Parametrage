package com.csys.parametrage.service;

import com.csys.parametrage.domain.FamillePrestation;
import com.csys.parametrage.domain.TypePrestation;
import com.csys.parametrage.dto.FamillePrestationDTO;
import com.csys.parametrage.dto.SousFamillePrestationDTO;
import com.csys.parametrage.factory.FamillePrestationFactory;
import com.csys.parametrage.repository.FamillePrestationRepository;
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
 * Service Implementation for managing FamillePrestation.
 */
@Service
@Transactional
public class FamillePrestationService {

    private final Logger log = LoggerFactory.getLogger(FamillePrestationService.class);

    private final FamillePrestationRepository famillePrestationRepository;

    private final SousFamillePrestationService sousFamillePrestationService;

    public FamillePrestationService(FamillePrestationRepository famillePrestationRepository, SousFamillePrestationService sousFamillePrestationService) {
        this.famillePrestationRepository = famillePrestationRepository;
        this.sousFamillePrestationService = sousFamillePrestationService;
    }

    /**
     * Save a famillePrestation.
     *
     * @param famillePrestationDto the entity to save
     * @return the persisted entity
     */
    public Boolean save(FamillePrestationDTO famillePrestationDto) {
        log.debug("Request to save FamillePrestation : {}", famillePrestationDto);
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        famillePrestationDto.setCode(null);
        FamillePrestation famillePrestation = new FamillePrestation();
        TypePrestation typePrestation = new TypePrestation();
        famillePrestation.setCodeTypePrestation(typePrestation);
        famillePrestation = FamillePrestationFactory.famillePrestationDTOTOFamillePrestation(famillePrestationDto, famillePrestation);
        famillePrestation.setSuffixe(1);
        famillePrestation.setPrefixe("");
        famillePrestation.setUserCreation(user);
        famillePrestation.setDateCreation(new Date());
        famillePrestationRepository.save(famillePrestation);
        return true;
    }

    /**
     * Get all the famillePrestations.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<FamillePrestationDTO> findAll() {
        log.debug("Request to get all FamillePrestations");
        List<FamillePrestation> result = famillePrestationRepository.findAll();
        return FamillePrestationFactory.listFamillePrestationTOlistFamillePrestationDTO(result);
    }

    /**
     * Get one famillePrestation by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public FamillePrestationDTO findOne(Integer id) {
        log.debug("Request to get FamillePrestation : {}", id);
        FamillePrestation famillePrestation = famillePrestationRepository.findOne(id);
        Preconditions.checkArgument((famillePrestation != null), "error.ressourceNotFound");
        return FamillePrestationFactory.famillePrestationTOFamillePrestationDTO(famillePrestation);
    }

    /**
     * Delete the famillePrestation by id.
     *
     * @param id the id of the entity
     */
    public void delete(Integer id) {
        log.debug("Request to delete FamillePrestation : {}", id);
        Preconditions.checkArgument(id != null, "error.ressourceNotFound");
        Preconditions.checkArgument(famillePrestationRepository.exists(id), "error.ressourceNotFound");
        List<SousFamillePrestationDTO> sousFamille = sousFamillePrestationService.findByCodeFamilleCode(id);
        Preconditions.checkArgument(sousFamille.isEmpty(), "error.ressourceMouvmente");
        famillePrestationRepository.delete(id);
    }

    public Boolean update(FamillePrestationDTO famillePrestationDto) {
        log.debug("Request to update FamillePrestation : {}", famillePrestationDto);
        Preconditions.checkArgument((famillePrestationDto.getCode() != null), "error.ressourceNotFound");
        FamillePrestation famillePrestation = famillePrestationRepository.findOne(famillePrestationDto.getCode());
        Preconditions.checkArgument(famillePrestation != null, "error.ressourceNotFound");
        TypePrestation typePrestation = new TypePrestation();
        famillePrestation.setCodeTypePrestation(typePrestation);
        famillePrestation = FamillePrestationFactory.famillePrestationDTOTOFamillePrestation(famillePrestationDto, famillePrestation);
        famillePrestationRepository.save(famillePrestation);
        return true;
    }

    @Transactional(readOnly = true)
    public FamillePrestation findByCode(Integer code) {
        log.debug("Request to get FamillePrestation : {}", code);
        return famillePrestationRepository.findOne(code);
    }

    public Boolean updateSuffixe(FamillePrestation famillePrestation) {
        famillePrestationRepository.save(famillePrestation);
        return true;
    }

    @Transactional(readOnly = true)
    public List<FamillePrestationDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get FamillePrestation by actif : {}", actif);
        List<FamillePrestation> famillePrestation = famillePrestationRepository.findByActifIn(actif);
        return FamillePrestationFactory.listFamillePrestationTOlistFamillePrestationDTO(famillePrestation);
    }

}
