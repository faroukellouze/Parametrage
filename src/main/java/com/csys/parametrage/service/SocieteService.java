package com.csys.parametrage.service;

import com.csys.parametrage.domain.ResponsableSociete;
import com.csys.parametrage.domain.Societe;
import com.csys.parametrage.dto.SocieteDTO;
import com.csys.parametrage.factory.ContactSocieteFactory;
import com.csys.parametrage.factory.PieceJointeBordereauSocieteFactory;
import com.csys.parametrage.factory.ResponsableSocieteFactory;
import com.csys.parametrage.factory.SocieteFactory;
import com.csys.parametrage.repository.SocieteRepository;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Implementation for managing Societe.
 */
@Service
@Transactional
public class SocieteService {

    private final Logger log = LoggerFactory.getLogger(SocieteService.class);

    private final SocieteRepository societeRepository;

    public SocieteService(SocieteRepository societeRepository) {
        this.societeRepository = societeRepository;
    }

    /**
     * Save a societe.
     *
     * @param societeDTO the entity to save
     * @param user
     * @return the persisted entity
     */
    public Boolean save(SocieteDTO societeDTO, String user) {
        log.debug("Request to save Societe : {}", societeDTO);
        Societe soc = societeRepository.findByCodeSaisie(societeDTO.getCodeSaisie());
        Preconditions.checkArgument(soc == null, "error.codeInvalide");
        
        Societe societe = new Societe();
         societe.setUserCreation(user);
        societe.setDateCreation(new Date());
        societe = SocieteFactory.societeDTOToSociete(societeDTO, societe);
        societe.setPieceJointeBordereauSocieteCollection(PieceJointeBordereauSocieteFactory.listPieceJointeBordereauSocieteDTOToListPieceJointeBordereauSociete(societeDTO.getPieceJointeBordereauSocieteCollection(), societe));
        societe.setContactSocieteCollection(ContactSocieteFactory.listContactSocieteDTOToListContactSociete(societeDTO.getContactSocieteCollection(), societe));
        societe.setResponsableSocieteCollection(ResponsableSocieteFactory.listResponsableSocieteDTOToListResponsableSociete(societeDTO.getResponsableSocieteCollection(), societe));
//        societe.setCode(null);
       
        societeRepository.save(societe);
        return true;
    }

    /**
     * Get all the societes.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<SocieteDTO> findAll() {
        log.debug("Request to get all Societes");
        List<SocieteDTO> result = SocieteFactory.listSocieteTolistSocieteDTO(societeRepository.findAll());
        return result;
    }

    /**
     * Get one societe by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public SocieteDTO findOne(Integer id) {
        log.debug("Request to get Societe : {}", id);
        Societe societe = societeRepository.findOne(id);
        Preconditions.checkArgument((societe != null), "error.ressourceNotFound");
        return SocieteFactory.societeToSocieteDTO(societe);
    }

    /**
     * Delete the societe by id.
     *
     * @param id the id of the entity
     */
    public void delete(Integer id) {
        log.debug("Request to delete Societe : {}", id);
        Preconditions.checkArgument(societeRepository.exists(id), "error.ressourceNotFound");
        societeRepository.delete(id);
    }

    public Boolean update(SocieteDTO societeDTO) {
        log.debug("Request to update Societe : {}", societeDTO);
        Preconditions.checkArgument(societeDTO.getCode() != null, "error.ressourceNotFound");
        Preconditions.checkArgument((societeRepository.exists(societeDTO.getCode())), "error.ressourceNotFound");

        Societe societe = societeRepository.findOne(societeDTO.getCode());
        societe.getContactSocieteCollection().clear();
        societe.getPieceJointeBordereauSocieteCollection().clear();
        societe.getResponsableSocieteCollection().clear();

        societe.getPieceJointeBordereauSocieteCollection().addAll(PieceJointeBordereauSocieteFactory.listPieceJointeBordereauSocieteDTOToListPieceJointeBordereauSocieteUpdate(societeDTO.getPieceJointeBordereauSocieteCollection(), societe));
        societe.getContactSocieteCollection().addAll(ContactSocieteFactory.listContactSocieteDTOToListContactSocieteUpdate(societeDTO.getContactSocieteCollection(), societe));
        societe.getResponsableSocieteCollection().addAll(ResponsableSocieteFactory.listResponsableSocieteDTOToListResponsableSociete(societeDTO.getResponsableSocieteCollection(), societe));
      
        SocieteFactory.societeDTOToSociete(societeDTO, societe);
                
        societeRepository.save(societe);
        return true;
    }

    @Transactional(readOnly = true)
    public List<SocieteDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get Societe by actif : {}", actif);
        List<Societe> societe = societeRepository.findByActifIn(actif);
        return SocieteFactory.listSocieteTolistSocieteDTO(societe);
    }

    @Transactional(readOnly = true)
    public List<SocieteDTO> findByCodeBanque(Integer codeBanque) {
        log.debug("Request to get Societe by codeBanque : {}", codeBanque);
        Preconditions.checkArgument((codeBanque != null), "eerror.codeInvalide");
        List<Societe> societe = societeRepository.findByCodeBanqueCode(codeBanque);
        return SocieteFactory.listSocieteTolistSocieteDTO(societe);
    }

    @Transactional(readOnly = true)
    public List<SocieteDTO> findByCodeSecteurActivite(Integer codeSecteurActivite) {
        log.debug("Request to get Societe by codeSecteurActivite : {}", codeSecteurActivite);
        Preconditions.checkArgument((codeSecteurActivite != null), "eerror.codeInvalide");
        List<Societe> societe = societeRepository.findByCodeSecteurActiviteCode(codeSecteurActivite);
        return SocieteFactory.listSocieteTolistSocieteDTO(societe);
    }

    @Transactional(readOnly = true)
    public List<SocieteDTO> findByCodeModeReglement(Integer codeModeReglement) {
        log.debug("Request to get Societe by codeBanque : {}", codeModeReglement);
        Preconditions.checkArgument((codeModeReglement != null), "eerror.codeInvalide");
        List<Societe> societe = societeRepository.findByCodeModeReglementCode(codeModeReglement);
        return SocieteFactory.listSocieteTolistSocieteDTO(societe);
    }

}
