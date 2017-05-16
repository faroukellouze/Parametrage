package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.Societe;
import com.csys.parametrage.dto.SocieteDTO;
import com.csys.parametrage.service.SocieteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import javax.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * REST controller for managing Societe.
 */
@RestController
@RequestMapping("/api/societes")
public class SocieteResource {

    private final Logger log = LoggerFactory.getLogger(SocieteResource.class);
        
    private final SocieteService societeService;

    public SocieteResource(SocieteService societeService) {
        this.societeService = societeService;
    }

    /**
     * POST  /societes : Create a new societe.
     *
     * @param societe the societe to create
     * @param userConnected
     * @return the ResponseEntity with status 201 (Created) and with body the new societe, or with status 400 (Bad Request) if the societe has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping
    public ResponseEntity<Boolean> createSociete(@RequestBody @Valid SocieteDTO societe) throws URISyntaxException {
        log.debug("REST request to save Societe : {}", societe);
    String user= SecurityContextHolder.getContext().getAuthentication().getName();
        Boolean result = societeService.save(societe,user);
        return ResponseEntity.created(new URI("/api/societes/" )).body(result);
    }

    /**
     * PUT  /societes : Updates an existing societe.
     *
     * @param societe the societe to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated societe,
     * or with status 400 (Bad Request) if the societe is not valid,
     * or with status 500 (Internal Server Error) if the societe couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping
    public ResponseEntity<Boolean> updateSociete(@RequestBody @Valid SocieteDTO societe) throws URISyntaxException {
        log.debug("REST request to update Societe : {}", societe);
        Boolean result = societeService.update(societe);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET  /societes : get all the societes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of societes in body
     */
    @GetMapping
    public List<SocieteDTO> getAllSocietes() {
        log.debug("REST request to get all Societes");
        return societeService.findAll();
    }

    /**
     * GET  /societes/:id : get the "id" societe.
     *
     * @param id the id of the societe to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the societe, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<SocieteDTO> getSociete(@PathVariable Integer id) {
        log.debug("REST request to get Societe : {}", id);
        SocieteDTO societe = societeService.findOne(id);
        return ResponseEntity.ok().body(societe);
    }

    /**
     * DELETE  /societes/:id : delete the "id" societe.
     *
     * @param id the id of the societe to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSociete(@PathVariable Integer id) {
        log.debug("REST request to delete Societe : {}", id);
        societeService.delete(id);
        return ResponseEntity.noContent().build();
    }

     @GetMapping("/actif/{actif}")
    public ResponseEntity<List<SocieteDTO>> getSocieteByActif(@PathVariable Collection<Boolean> actif) {
        log.debug("REST request to get Societe by actif : {}", actif);
        List<SocieteDTO> societe = societeService.findByActifIn(actif);
        return ResponseEntity.ok().body(societe);
    }
    
}
