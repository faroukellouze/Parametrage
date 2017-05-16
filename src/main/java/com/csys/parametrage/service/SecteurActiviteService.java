package com.csys.parametrage.service;

import com.csys.parametrage.domain.SecteurActivite;
import com.csys.parametrage.domain.Tva;
import com.csys.parametrage.dto.SecteurActiviteDTO;
import com.csys.parametrage.dto.SocieteDTO;
import com.csys.parametrage.dto.TvaDTO;
import com.csys.parametrage.factory.SecteurActiviteFactory;
import com.csys.parametrage.factory.TvaFactory;
import com.csys.parametrage.repository.SecteurActiviteRepository;
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
 * Service Implementation for managing SecteurActivite.
 */
@Service
@Transactional
public class SecteurActiviteService {

    private final Logger log = LoggerFactory.getLogger(SecteurActiviteService.class);

    private final SecteurActiviteRepository secteurActiviteRepository;
    
     private final SocieteService societeService;

    public SecteurActiviteService(SecteurActiviteRepository secteurActiviteRepository, SocieteService societeService) {
        this.secteurActiviteRepository = secteurActiviteRepository;
         this.societeService = societeService;
    }

    /**
     * Save a secteurActivite.
     *
     * @param secteurActiviteDTO the entity to save
     * @return the persisted entity
     */
    public SecteurActivite save(SecteurActiviteDTO secteurActiviteDTO) {
        log.debug("Request to save SecteurActivite : {}", secteurActiviteDTO);
        SecteurActivite secteurActivite = SecteurActiviteFactory.secteurActiviteDTOToSecteurActivite(secteurActiviteDTO);
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        secteurActivite.setUserCreation(user);
        secteurActivite.setDateCreation(new Date());
        secteurActivite.setCode(null);
        SecteurActivite result = secteurActiviteRepository.save(secteurActivite);
        return result;
    }

    /**
     * Get all the secteurActivites.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<SecteurActiviteDTO> findAll() {
        log.debug("Request to get all SecteurActivites");
        List<SecteurActivite> result = secteurActiviteRepository.findAll();
        return SecteurActiviteFactory.listSecteurActiviteToSecteurActiviteDTO(result);
    }

    /**
     * Get one secteurActivite by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public SecteurActiviteDTO findOne(Integer id) {
        log.debug("Request to get SecteurActivite : {}", id);
        SecteurActivite secteurActivite = secteurActiviteRepository.findOne(id);
        Preconditions.checkArgument((secteurActivite != null), "error.ressourceNotFound");
        return SecteurActiviteFactory.secteurActiviteToSecteurActiviteDTO(secteurActivite);
    }

    /**
     * Delete the secteurActivite by id.
     *
     * @param id the id of the entity
     */
    public void delete(Integer id) {
        log.debug("Request to delete SecteurActivite : {}", id);
         Preconditions.checkArgument(secteurActiviteRepository.exists(id), "error.ressourceNotFound");
         List<SocieteDTO> societe = societeService.findByCodeSecteurActivite(id);
         Preconditions.checkArgument(societe.isEmpty(), "error.ressourceMouvmente");
        secteurActiviteRepository.delete(id);
    }
    
      public SecteurActivite update(SecteurActiviteDTO secteurActiviteDTO) {
        log.debug("Request to update SecteurActivite : {}", secteurActiviteDTO);
        SecteurActivite secteurActivite = SecteurActiviteFactory.secteurActiviteDTOToSecteurActivite(secteurActiviteDTO);
        Preconditions.checkArgument((secteurActiviteRepository.exists(secteurActivite.getCode())), "error.ressourceNotFound");
        return secteurActiviteRepository.save(secteurActivite);
    }
      
      @Transactional(readOnly = true)
    public Collection<SecteurActiviteDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get SecteurActivite by actif : {}", actif);
        List<SecteurActivite> secteurActivite = secteurActiviteRepository.findByActifIn(actif);
        return SecteurActiviteFactory.listSecteurActiviteToSecteurActiviteDTO(secteurActivite);
    }
}
