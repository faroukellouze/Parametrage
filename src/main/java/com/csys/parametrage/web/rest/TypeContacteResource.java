/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.TypeContacte;
import com.csys.parametrage.dto.ModeReglementDTO;
import com.csys.parametrage.dto.TypeContacteDTO;
import com.csys.parametrage.service.TypeContacteService;
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
@RequestMapping("/api/type-contactes")
public class TypeContacteResource {
     private final Logger log = LoggerFactory.getLogger(TypeContacteResource.class);
        
    private final TypeContacteService typeContacteService;

    public TypeContacteResource(TypeContacteService typeContacteService) {
        this.typeContacteService = typeContacteService;
    }

    /**
     * POST  /typeContacte : Create a new typeContacte.
     *
     * @param typeContacteDTO the typeContacteDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new typeContacteDTO, or with status 400 (Bad Request) if the typeContacte has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping
    public ResponseEntity<TypeContacte> createTypeContacte(@Valid @RequestBody TypeContacteDTO typeContacteDTO) throws URISyntaxException {
        log.debug("REST request to save TypeContacte : {}", typeContacteDTO);
        TypeContacte result = typeContacteService.save(typeContacteDTO);
        return ResponseEntity.created(new URI("/api/typeContactes/" + result.getCode())).body(result);
    }

    /**
     * PUT  /typeContactes : Updates an existing typeContacte.
     *
     * @param typeContacteDTO the typeContacteDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated typeContacteDTO,
     * or with status 400 (Bad Request) if the typeContacteDTO is not valid,
     * or with status 500 (Internal Server Error) if the typeContacteDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping
    public ResponseEntity<TypeContacte> updateTypeContacte(@Valid @RequestBody TypeContacteDTO typeContacteDTO) throws URISyntaxException {
        log.debug("REST request to update TypeContacte : {}", typeContacteDTO);
        TypeContacte result = typeContacteService.update(typeContacteDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET  /typeContactes : get all the typeContactes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of typeContactes in body
     */
    @GetMapping
    public ResponseEntity<List<TypeContacteDTO>> getAllTypeContactes() {
        log.debug("REST request to get all TypeContactes");
        return ResponseEntity.ok().body(typeContacteService.findAll());
    }

    /**
     * GET  /typeContactes/:id : get the "id" typeContacte.
     *
     * @param id the id of the typeContacteDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the typeContacteDTO, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<TypeContacteDTO> getTypeContacte(@PathVariable Integer id) {
        log.debug("REST request to get TypeContacte : {}", id);
        TypeContacteDTO typeContacteDTO = typeContacteService.findOne(id);
        return ResponseEntity.ok().body(typeContacteDTO);
    }

    /**
     * DELETE  /typeContactes/:id : delete the "id" typeContacte.
     *
     * @param id the id of the typeContacteDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeContacte(@PathVariable Integer id) {
        log.debug("REST request to delete TypeContacte : {}", id);
        typeContacteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/actif")
    public ResponseEntity<Collection<TypeContacteDTO>> findByActifIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get TypeContacte by actif: {}", actif);
        Collection<TypeContacteDTO> type = typeContacteService.findByActifIn(actif);
        return ResponseEntity.ok().body(type);
    }
    
}
