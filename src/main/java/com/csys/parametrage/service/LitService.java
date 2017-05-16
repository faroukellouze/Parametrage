package com.csys.parametrage.service;

import com.csys.parametrage.domain.Chambre;
import com.csys.parametrage.domain.Lit;
import com.csys.parametrage.dto.LitDTO;
import com.csys.parametrage.factory.LitFactory;
import com.csys.parametrage.repository.LitRepository;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Service Implementation for managing Lit.
 */
@Service
@Transactional
public class LitService {

    private final Logger log = LoggerFactory.getLogger(LitService.class);

    private final LitRepository litRepository;

    public LitService(LitRepository litRepository) {
        this.litRepository = litRepository;
    }
    /**
     * Get all the lits.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<LitDTO> findAll() {
        log.debug("Request to get all Lits");
        List<Lit> result = litRepository.findAll();
        return LitFactory.listLitTolistLitDTO(result);
    }

    /**
     * Get one lit by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public LitDTO findOne(String id) {
        log.debug("Request to get Lit : {}", id);
        Lit lit = litRepository.findOne(id);
        return LitFactory.litToLitDTO(lit);
    }

}
