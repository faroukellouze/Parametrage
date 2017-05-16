package com.csys.parametrage.service;

import com.csys.parametrage.domain.Banque;
import com.csys.parametrage.domain.FonctionResponsableSociete;
import com.csys.parametrage.dto.BanqueDTO;
import com.csys.parametrage.dto.FonctionResponsableSocieteDTO;
import com.csys.parametrage.dto.SocieteDTO;
import com.csys.parametrage.factory.BanqueFactory;
import com.csys.parametrage.factory.FonctionResponsableSocieteFactory;
import com.csys.parametrage.repository.BanqueRepository;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;

/*import org.springframework.security.access.prepost.PreAuthorize;*/

/**
 * Service Implementation for managing Banque.
 */
@Service("BanqueService")
@Transactional
public class BanqueService {
    
    private final Logger log = LoggerFactory.getLogger(BanqueService.class);
    
    private final BanqueRepository banqueRepository;
    
    private final SocieteService societeService;
    
    public BanqueService(BanqueRepository banqueRepository, SocieteService societeService) {
        this.banqueRepository = banqueRepository;
        this.societeService = societeService;
    }

    /**
     * Save a banque.
     *
     * @param banqueDTO the entity to save
     * @return the persisted entity
     */
    public Banque save(BanqueDTO banqueDTO) {
        log.debug("Request to save Banque : {}", banqueDTO);
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        banqueDTO.setCode(null);
        Banque banque = BanqueFactory.banqueDTOToBanque(banqueDTO);
        banque.setUserCreation(user);
        banque.setDateCreation(new Date());
        return banqueRepository.save(banque);
    }

    /**
     * Get all the banques.
     *
     * @return the list of entities
     */
    /* @PreAuthorize("hasAuthority('Banques')")*/
    @Transactional(readOnly = true)
    public List<BanqueDTO> findAll() {
        log.debug("Request to get all Banques");
        return BanqueFactory.listBanqueTolistBanqueDTO(banqueRepository.findAll());
        
    }

    /**
     * Get one banque by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public BanqueDTO findOne(Integer id) {
        log.debug("Request to get Banque : {}", id);
        Banque banque = banqueRepository.findOne(id);
        Preconditions.checkArgument(banque != null, "error.ressourceNotFound");
        return BanqueFactory.banqueToBanqueDTO(banque);
    }

    /**
     * Delete the banque by id.
     *
     * @param id the id of the entity
     */
    public void delete(Integer id) {
        log.debug("Request to delete Banque : {}", id);
        Preconditions.checkArgument(banqueRepository.exists(id), "error.ressourceNotFound");
        List<SocieteDTO> societe = societeService.findByCodeBanque(id);
        Preconditions.checkArgument(societe.isEmpty(), "error.ressourceMouvmente");
        banqueRepository.delete(id);
    }
    
    public Banque update(BanqueDTO banqueDTO) {
        log.debug("Request to update Banque : {}", banqueDTO);
        Preconditions.checkArgument((banqueDTO.getCode() != null), "error.ressourceNotFound");
        Preconditions.checkArgument((banqueRepository.exists(banqueDTO.getCode())), "error.ressourceNotFound");
        Banque banque = BanqueFactory.banqueDTOToBanque(banqueDTO);
        return banqueRepository.save(banque);
    }
    
    @Transactional(readOnly = true)
    public Collection<BanqueDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get Banque by actif : {}", actif);
        List<Banque> banque = banqueRepository.findByActifIn(actif);
        return BanqueFactory.listBanqueTolistBanqueDTO(banque);
    }
    
}
