package com.csys.parametrage.service;

import com.csys.parametrage.domain.EtatChambre;
import com.csys.parametrage.dto.ChambreDTO;
import com.csys.parametrage.dto.EtatChambreDTO;
import com.csys.parametrage.factory.EtatChambreFactory;
import com.csys.parametrage.repository.EtatChambreRepository;
import com.google.common.base.Preconditions;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Service Implementation for managing EtatChambre.
 */
@Service
@Transactional
public class EtatChambreService {

    private final Logger log = LoggerFactory.getLogger(EtatChambreService.class);

    private final EtatChambreRepository etatChambreRepository;

    private final ChambreService chambreService;

    public EtatChambreService(EtatChambreRepository etatChambreRepository, ChambreService chambreService) {
        this.etatChambreRepository = etatChambreRepository;
        this.chambreService = chambreService;
    }

    /**
     * Save a etatChambre.
     *
     * @param etatChambredto the entity to save
     * @return the persisted entity
     */
    public Boolean save(EtatChambreDTO etatChambredto) {
        log.debug("Request to save EtatChambre : {}", etatChambredto);
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        EtatChambre etatChambre = EtatChambreFactory.createEtatChambre(etatChambredto, user);
        etatChambreRepository.save(etatChambre);
        return true;
    }

    /**
     * Get all the etatChambres.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Collection<EtatChambreDTO> findAll() {
        log.debug("Request to get all EtatChambres");
        List<EtatChambre> result = etatChambreRepository.findAll();
        return EtatChambreFactory.etatChambreCollectionToEtatChambreDTOCollection(result);
    }

    /**
     * Get one etatChambre by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public EtatChambreDTO findOne(Integer id) {
        log.debug("Request to get EtatChambre : {}", id);
        EtatChambre etatChambre = etatChambreRepository.findOne(id);
        Preconditions.checkArgument(etatChambre != null, "error.ressourceNotFound");
        return EtatChambreFactory.etatChambreTOEtatChambreDTO(etatChambre);
    }

    /**
     * Delete the etatChambre by id.
     *
     * @param id the id of the entity
     */
    public void delete(Integer id) {
        log.debug("Request to delete EtatChambre : {}", id);
        Preconditions.checkArgument(id != null, "error.ressourceNotFound");
        Preconditions.checkArgument(etatChambreRepository.exists(id), "error.ressourceNotFound");
        Collection<ChambreDTO> chambre = chambreService.findByEtatChambreCode(id);
        Preconditions.checkArgument(chambre.isEmpty(), "error.ressourceMouvmente");
        etatChambreRepository.delete(id);
    }

    public Boolean update(EtatChambreDTO etatChambreDTO) {
        log.debug("Request to update etatChambre : {}", etatChambreDTO);
        Preconditions.checkArgument((etatChambreDTO.getCode() != null), "error.ressourceNotFound");
        EtatChambre etatChambre = etatChambreRepository.findOne(etatChambreDTO.getCode());
        Preconditions.checkArgument(etatChambre != null, "error.ressourceNotFound");
        EtatChambreFactory.etatChambreDTOTOEtatChambre(etatChambreDTO, etatChambre);
        etatChambreRepository.save(etatChambre);
        return true;
    }

    @Transactional(readOnly = true)
    public Collection<EtatChambreDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get etatChambre by actif : {}", actif);
        List<EtatChambre> etatChambre = etatChambreRepository.findByActifIn(actif);
        return EtatChambreFactory.etatChambreCollectionToEtatChambreDTOCollection(etatChambre);
    }

    @Transactional(readOnly = true)
    public Collection<EtatChambreDTO> findByActifAndEtat(Boolean actif, Boolean etat) {
        log.debug("Request to get etatChambre by findByActifAndEtat ", actif, etat);
        List<EtatChambre> etatChambre = etatChambreRepository.findByActifAndEtat(actif, etat);
        return EtatChambreFactory.etatChambreCollectionToEtatChambreDTOCollection(etatChambre);
    }
}
