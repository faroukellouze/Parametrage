package com.csys.parametrage.service;

import com.csys.parametrage.domain.Param;
import com.csys.parametrage.repository.ParamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Implementation for managing Param.
 */
@Service
@Transactional
public class ParamService {

    private final Logger log = LoggerFactory.getLogger(ParamService.class);
    
    private final ParamRepository paramRepository;

    public ParamService(ParamRepository paramRepository) {
        this.paramRepository = paramRepository;
    }

    /**
     *  Get one param by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Param findOne(String id) {
        log.debug("Request to get Param : {}", id);
        Param param = paramRepository.findOne(id);
        return param;
    }

}
