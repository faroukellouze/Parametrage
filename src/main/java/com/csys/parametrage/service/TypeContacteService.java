/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.service;

import com.csys.parametrage.domain.TypeContacte;
import com.csys.parametrage.dto.TypeContacteDTO;
import com.csys.parametrage.factory.TypeContacteFactory;
import com.csys.parametrage.repository.TypeContacteRepository;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrateur
 */
@Service("TypeContacteService")
@Transactional
public class TypeContacteService {
     private final Logger log = LoggerFactory.getLogger(TypeContacteService.class);
    
    private final TypeContacteRepository typeContacteRepository;

    public TypeContacteService(TypeContacteRepository typeContacteRepository) {
        this.typeContacteRepository = typeContacteRepository;
    }

    /**
     * Save a typeContacte.
     *
     * @param typeContacteDTO the entity to save
     * @return the persisted entity
     */
    public TypeContacte save(TypeContacteDTO typeContacteDTO) {
        log.debug("Request to save TypeContacte : {}", typeContacteDTO);
        TypeContacte typeContacte = TypeContacteFactory.typeContacteDTOToTypeContacte(typeContacteDTO);
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        typeContacte.setUserCreation(user);
        typeContacte.setDateCreation(new Date());
        typeContacte.setCode(null);
        TypeContacte result = typeContacteRepository.save(typeContacte);
        return result;
    }

    /**
     *  Get all the typeContactes.
     *  
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<TypeContacteDTO> findAll() {
        log.debug("Request to get all TypeContacte");
        List<TypeContacte> result = typeContacteRepository.findAll();
        return TypeContacteFactory.listTypeContacteToListTypeContacteDTO(result);
    }

    /**
     *  Get one typeContacte by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public TypeContacteDTO findOne(Integer id) {
        log.debug("Request to get TypeContacte : {}", id);
        TypeContacte typeContacte = typeContacteRepository.findOne(id);
        Preconditions.checkArgument((typeContacte != null), "error.ressourceNotFound");
        return TypeContacteFactory.typeContacteToTypeContacteDTO(typeContacte);
    }

    /**
     *  Delete the  typeContacte by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Integer id) {
        log.debug("Request to delete TypeContacte : {}", id);
        Preconditions.checkArgument(typeContacteRepository.exists(id), "error.ressourceNotFound");
        typeContacteRepository.delete(id);
    }
    
     public TypeContacte update(TypeContacteDTO typeContacteDTO) {
        log.debug("Request to update TypeContacte : {}", typeContacteDTO);
        TypeContacte typeContacte = TypeContacteFactory.typeContacteDTOToTypeContacte(typeContacteDTO);
        Preconditions.checkArgument((typeContacteRepository.exists(typeContacte.getCode())), "error.ressourceNotFound");
        return typeContacteRepository.save(typeContacte);
    }
     
     @Transactional(readOnly = true)
    public Collection<TypeContacteDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get TypeContacte by actif : {}", actif);
        List<TypeContacte> type = typeContacteRepository.findByActifIn(actif);
        return TypeContacteFactory.listTypeContacteToListTypeContacteDTO(type);
    }
}
