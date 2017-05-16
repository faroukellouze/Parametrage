/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.TypePieceJointeBordereau;
import com.csys.parametrage.dto.TypeContacteDTO;
import com.csys.parametrage.dto.TypePieceJointeBordereauDTO;
import com.csys.parametrage.service.TypePieceJointeBordereauService;
import com.google.common.base.Preconditions;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrateur
 */

@RestController
@RequestMapping("/api/type-piece-jointe-bordereaux")
public class TypePieceJointeBordereauResource {
     private final Logger log = LoggerFactory.getLogger(TypePieceJointeBordereauResource.class);
        
    private final TypePieceJointeBordereauService typePieceJointeBordereauService;

    public TypePieceJointeBordereauResource(TypePieceJointeBordereauService typePieceJointeBordereauService) {
        this.typePieceJointeBordereauService = typePieceJointeBordereauService;
    }

    /**
     * POST  /type-piece-jointe-bordereaux : Create a new typePieceJointeBordereau.
     *
     * @param typePieceJointeBordereauDTO the typePieceJointeBordereauDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new typePieceJointeBordereauDTO, or with status 400 (Bad Request) if the typePieceJointeBordereau has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping
    public ResponseEntity<TypePieceJointeBordereau> createTypePieceJointeBordereau(@RequestBody @Valid TypePieceJointeBordereauDTO typePieceJointeBordereauDTO) throws URISyntaxException {
        log.debug("REST request to save TypePieceJointeBordereau : {}", typePieceJointeBordereauDTO);
        TypePieceJointeBordereau result = typePieceJointeBordereauService.save(typePieceJointeBordereauDTO);
        return ResponseEntity.created(new URI("/api/type-piece-jointe-bordereaux/" + result.getCode())).body(result);
    }

    /**
     * PUT  /type-piece-jointe-bordereaux : Updates an existing typePieceJointeBordereau.
     *
     * @param typePieceJointeBordereauDTO the typePieceJointeBordereauDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated typePieceJointeBordereauDTO,
     * or with status 400 (Bad Request) if the typePieceJointeBordereauDTO is not valid,
     * or with status 500 (Internal Server Error) if the typePieceJointeBordereauDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping
    public ResponseEntity<TypePieceJointeBordereau> updateTypePieceJointeBordereau(@RequestBody @Valid TypePieceJointeBordereauDTO typePieceJointeBordereauDTO) throws URISyntaxException {
        log.debug("REST request to update TypePieceJointeBordereau : {}", typePieceJointeBordereauDTO);
        Preconditions.checkArgument((typePieceJointeBordereauDTO.getCode() != null), "le code du typePieceJointeBordereau doit etre différent de null");
        TypePieceJointeBordereau result = typePieceJointeBordereauService.update(typePieceJointeBordereauDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET  /type-piece-jointe-bordereaux : get all the typePieceJointeBordereaux.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of TypePieceJointeBordereaux in body
     */
    @GetMapping
    public ResponseEntity<List<TypePieceJointeBordereauDTO>> getAllTypePieceJointeBordereaux() {
        log.debug("REST request to get all TypePieceJointeBordereaux");
        return ResponseEntity.ok().body(typePieceJointeBordereauService.findAll());
    }

    /**
     * GET  /type-piece-jointe-bordereaux/:id : get the "id" typePieceJointeBordereau.
     *
     * @param id the id of the typePieceJointeBordereauDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the typePieceJointeBordereauDTO, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<TypePieceJointeBordereauDTO> getTypePieceJointeBordereau(@PathVariable Integer id) {
        log.debug("REST request to get TypePieceJointeBordereau : {}", id);
        TypePieceJointeBordereauDTO typePieceJointeBordereauDTO = typePieceJointeBordereauService.findOne(id);
        return ResponseEntity.ok().body(typePieceJointeBordereauDTO);
    }

    /**
     * DELETE  /type-piece-jointe-bordereaux/:id : delete the "id" typePieceJointeBordereau.
     *
     * @param id the id of the typePieceJointeBordereauDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypePieceJointeBordereau(@PathVariable Integer id) {
        log.debug("REST request to delete TypePieceJointeBordereau : {}", id);
        typePieceJointeBordereauService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @GetMapping("/actif")
    public ResponseEntity<Collection<TypePieceJointeBordereauDTO>> findByActifIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get TypePieceJointeBordereau by actif: {}", actif);
        Collection<TypePieceJointeBordereauDTO> type = typePieceJointeBordereauService.findByActifIn(actif);
        return ResponseEntity.ok().body(type);
    }

}
