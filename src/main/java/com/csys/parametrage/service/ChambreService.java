package com.csys.parametrage.service;

import com.csys.parametrage.domain.Cathegorie;
import com.csys.parametrage.domain.Chambre;
import com.csys.parametrage.dto.CathegorieDTO;
import com.csys.parametrage.dto.ChambreDTO;
import com.csys.parametrage.factory.CathegorieFactory;
import com.csys.parametrage.factory.ChambreFactory;
import com.csys.parametrage.factory.LitFactory;
import com.csys.parametrage.repository.ChambreRepository;
import com.google.common.base.Preconditions;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Service Implementation for managing Chambre.
 */
@Service
@Transactional
public class ChambreService {

    private final Logger log = LoggerFactory.getLogger(ChambreService.class);

    private final ChambreRepository chambreRepository;

    public ChambreService(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    /**
     * Save a chambre.
     *
     * @param chambredto the entity to save
     * @return the persisted entity
     */
    public Boolean save(ChambreDTO chambredto) {
        log.debug("Request to save Chambre : {}", chambredto);
        Chambre cha=chambreRepository.findByNumeroChambre(chambredto.getNumeroChambre());
        Preconditions.checkArgument(cha == null, "error.codeInvalide");
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Chambre chambre = ChambreFactory.createChambre(chambredto,user);
        chambreRepository.save(chambre);
        return true;
    }

    /**
     * Get all the chambres.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Collection<ChambreDTO> findAll() {
        log.debug("Request to get all Chambres");
        List<Chambre> result = chambreRepository.findAll();

        return ChambreFactory.chambreCollectionToChambreDTOCollection(result);
    }

    /**
     * Get one chambre by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public ChambreDTO findOne(Integer id) {
        log.debug("Request to get Chambre : {}", id);
        Chambre chambre = chambreRepository.findOne(id);
        Preconditions.checkArgument(chambre != null, "error.ressourceNotFound");
        return ChambreFactory.chambreTOChambreDTO(chambre);
    }

    /**
     * Delete the chambre by id.
     *
     * @param id the id of the entity
     */
    public void delete(Integer id) {
        log.debug("Request to delete Chambre : {}", id);
        Preconditions.checkArgument(id != null, "error.ressourceNotFound");
        Preconditions.checkArgument(chambreRepository.exists(id), "error.ressourceNotFound");
        chambreRepository.delete(id);
    }

    public Boolean update(ChambreDTO chambreDTO) {
        log.debug("Request to update chambre : {}", chambreDTO.getCode());
        Preconditions.checkArgument((chambreDTO.getCode() != null), "error.ressourceNotFound");
        Chambre chambre = chambreRepository.findOne(chambreDTO.getCode());
        Preconditions.checkArgument(chambre != null, "error.ressourceNotFound");
        chambre.getLitCollection().clear();
        chambre.getLitCollection().addAll(LitFactory.createListLit(chambreDTO.getLitCollection(), chambre));
        ChambreFactory.chambreDTOTOChambre(chambreDTO, chambre);
        chambreRepository.save(chambre);
        return true;
    }

    @Transactional(readOnly = true)
    public Collection<ChambreDTO> findByCodeServiceCode(Integer codeService) {
        log.debug("Request to get chambre by codeService : {}", codeService);
        List<Chambre> chambre = chambreRepository.findByCodeServiceCode(codeService);
        return ChambreFactory.chambreCollectionToChambreDTOCollection(chambre);
    }

    @Transactional(readOnly = true)
    public Collection<ChambreDTO> findByEtatChambreCode(Integer etatChambre) {
        log.debug("Request to get chambre by etatChambre : {}", etatChambre);
        List<Chambre> chambre = chambreRepository.findByEtatChambreCode(etatChambre);
        return ChambreFactory.chambreCollectionToChambreDTOCollection(chambre);
    }

    @Transactional(readOnly = true)
    public Collection<ChambreDTO> findByCodeEtageCode(Integer codeEtage) {
        log.debug("Request to get chambre by codeEtage : {}", codeEtage);
        List<Chambre> chambre = chambreRepository.findByCodeEtageCode(codeEtage);
        return ChambreFactory.chambreCollectionToChambreDTOCollection(chambre);
    }

    @Transactional(readOnly = true)
    public Collection<ChambreDTO> findByCodeCathegorieCode(Integer codeCathegorie) {
        log.debug("Request to get chambre by codeCathegorie : {}", codeCathegorie);
        List<Chambre> chambre = chambreRepository.findByCodeCathegorieCode(codeCathegorie);
        return ChambreFactory.chambreCollectionToChambreDTOCollection(chambre);
    }
    
    
    @Transactional(readOnly = true)
    public Chambre test(Integer id) {
        Chambre chambre = chambreRepository.findByCode(id);
        return chambre;
    }
    
    @Transactional(readOnly = true)
    public Collection<ChambreDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get Chambre by actif : {}", actif);
        List<Chambre> chambre = chambreRepository.findByActifIn(actif);
        return ChambreFactory.chambreCollectionToChambreDTOCollection(chambre);
    }
}
