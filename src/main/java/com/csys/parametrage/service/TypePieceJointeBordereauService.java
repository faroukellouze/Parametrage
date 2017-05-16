/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.service;

import com.csys.parametrage.domain.TypePieceJointeBordereau;
import com.csys.parametrage.dto.PieceJointeBordereauSocieteDTO;
import com.csys.parametrage.dto.TypePieceJointeBordereauDTO;
import com.csys.parametrage.factory.TypePieceJointeBordereauFactory;
import com.csys.parametrage.repository.TypePieceJointeBordereauRepository;
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
@Service("TypePieceJointeBordereauService")
@Transactional
public class TypePieceJointeBordereauService {

    private final Logger log = LoggerFactory.getLogger(TypePieceJointeBordereauService.class);

    private final TypePieceJointeBordereauRepository typePieceJointeBordereauRepository;

    private final PieceJointBordereauService pieceJointBordereauService;

    public TypePieceJointeBordereauService(TypePieceJointeBordereauRepository typePieceJointeBordereauRepository, PieceJointBordereauService pieceJointBordereauService) {
        this.typePieceJointeBordereauRepository = typePieceJointeBordereauRepository;
        this.pieceJointBordereauService = pieceJointBordereauService;

    }

    /**
     * Save a typePieceJointeBordereau.
     *
     * @param typePieceJointeBordereauDTO the entity to save
     * @return the persisted entity
     */
    public TypePieceJointeBordereau save(TypePieceJointeBordereauDTO typePieceJointeBordereauDTO) {
        log.debug("Request to save TypePieceJointeBordereau : {}", typePieceJointeBordereauDTO);
        TypePieceJointeBordereau type = TypePieceJointeBordereauFactory.typePieceJointeBordereauDTOToTypePieceJointeBordereau(typePieceJointeBordereauDTO);
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        type.setUserCreation(user);
        type.setDateCreation(new Date());
        type.setCode(null);
        TypePieceJointeBordereau result = typePieceJointeBordereauRepository.save(type);
        return result;
    }

    /**
     * Get all the typePieceJointeBordereaux.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<TypePieceJointeBordereauDTO> findAll() {
        log.debug("Request to get all TypePieceJointeBordereaux");
        List<TypePieceJointeBordereau> result = typePieceJointeBordereauRepository.findAll();
        return TypePieceJointeBordereauFactory.listTypePieceJointeBordereauToListTypePieceJointeBordereauDTO(result);
    }

    /**
     * Get one TypePieceJointeBordereau by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public TypePieceJointeBordereauDTO findOne(Integer id) {
        log.debug("Request to get TypePieceJointeBordereau : {}", id);
        TypePieceJointeBordereau type = typePieceJointeBordereauRepository.findOne(id);
        Preconditions.checkArgument((type != null), "error.ressourceNotFound");
        return TypePieceJointeBordereauFactory.typePieceJointeBordereauToTypePieceJointeBordereauDTO(type);
    }

    /**
     * Delete the TypePieceJointeBordereau by id.
     *
     * @param id the id of the entity
     */
    public void delete(Integer id) {
        log.debug("Request to delete TypePieceJointeBordereau : {}", id);
        Preconditions.checkArgument(typePieceJointeBordereauRepository.exists(id), "error.ressourceNotFound");
        Collection<PieceJointeBordereauSocieteDTO> piece = pieceJointBordereauService.findByPieceJointeBordereauSocietePK_CodeTypePieceJointe(id);
        Preconditions.checkArgument(piece.isEmpty(), "error.ressourceMouvmente");
        typePieceJointeBordereauRepository.delete(id);
    }

    public TypePieceJointeBordereau update(TypePieceJointeBordereauDTO typePieceJointeBordereauDTO) {
        log.debug("Request to update TypePieceJointeBordereau : {}", typePieceJointeBordereauDTO);
        TypePieceJointeBordereau type = TypePieceJointeBordereauFactory.typePieceJointeBordereauDTOToTypePieceJointeBordereau(typePieceJointeBordereauDTO);
        Preconditions.checkArgument((typePieceJointeBordereauRepository.exists(type.getCode())), "error.ressourceNotFound");
        return typePieceJointeBordereauRepository.save(type);
    }

    @Transactional(readOnly = true)
    public Collection<TypePieceJointeBordereauDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get TypePieceJointeBordereau by actif : {}", actif);
        List<TypePieceJointeBordereau> type = typePieceJointeBordereauRepository.findByActifIn(actif);
        return TypePieceJointeBordereauFactory.listTypePieceJointeBordereauToListTypePieceJointeBordereauDTO(type);
    }
}
