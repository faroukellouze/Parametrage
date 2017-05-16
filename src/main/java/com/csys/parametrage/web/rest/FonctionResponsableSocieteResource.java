package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.FonctionResponsableSociete;
import com.csys.parametrage.dto.FonctionResponsableSocieteDTO;
import com.csys.parametrage.service.FonctionResponsableSocieteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import javax.validation.Valid;
/**
 * REST controller for managing FonctionResponsableSociete.
 */
@RestController
@RequestMapping("/api/fonction-responsable-societes")
public class FonctionResponsableSocieteResource {

    private final Logger log = LoggerFactory.getLogger(FonctionResponsableSocieteResource.class);
        
    private final FonctionResponsableSocieteService fonctionResponsableSocieteService;

    public FonctionResponsableSocieteResource(FonctionResponsableSocieteService fonctionResponsableSocieteService) {
        this.fonctionResponsableSocieteService = fonctionResponsableSocieteService;
    }

    /**
     * POST  /fonction-responsable-societes : Create a new fonctionResponsableSociete.
     *
     * @param fonctionResponsableSociete the fonctionResponsableSociete to create
     * @return the ResponseEntity with status 201 (Created) and with body the new fonctionResponsableSociete, or with status 400 (Bad Request) if the fonctionResponsableSociete has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping
    public ResponseEntity<FonctionResponsableSociete> createFonctionResponsableSociete(@RequestBody @Valid FonctionResponsableSocieteDTO fonctionResponsableSociete) throws URISyntaxException {
        log.debug("REST request to save FonctionResponsableSociete : {}", fonctionResponsableSociete);
        FonctionResponsableSociete result = fonctionResponsableSocieteService.save(fonctionResponsableSociete);
        return ResponseEntity.created(new URI("/api/fonction-responsable-societes/" + result.getCode()))
            .body(result);
    }

    /**
     * PUT  /fonction-responsable-societes : Updates an existing fonctionResponsableSociete.
     *
     * @param fonctionResponsableSociete the fonctionResponsableSociete to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated fonctionResponsableSociete,
     * or with status 400 (Bad Request) if the fonctionResponsableSociete is not valid,
     * or with status 500 (Internal Server Error) if the fonctionResponsableSociete couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping
    public ResponseEntity<FonctionResponsableSociete> updateFonctionResponsableSociete(@RequestBody @Valid FonctionResponsableSocieteDTO fonctionResponsableSociete) throws URISyntaxException {
        log.debug("REST request to update FonctionResponsableSociete : {}", fonctionResponsableSociete);
        FonctionResponsableSociete result = fonctionResponsableSocieteService.update(fonctionResponsableSociete);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * GET  /fonction-responsable-societes : get all the fonctionResponsableSocietes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of fonctionResponsableSocietes in body
     */
    @GetMapping
    public List<FonctionResponsableSocieteDTO> getAllFonctionResponsableSocietes() {
        log.debug("REST request to get all FonctionResponsableSocietes");
        return fonctionResponsableSocieteService.findAll();
    }

    /**
     * GET  /fonction-responsable-societes/:id : get the "id" fonctionResponsableSociete.
     *
     * @param id the id of the fonctionResponsableSociete to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the fonctionResponsableSociete, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<FonctionResponsableSocieteDTO> getFonctionResponsableSociete(@PathVariable Integer id) {
        log.debug("REST request to get FonctionResponsableSociete : {}", id);
        FonctionResponsableSocieteDTO fonctionResponsableSociete = fonctionResponsableSocieteService.findOne(id);
        return ResponseEntity.ok().body(fonctionResponsableSociete);
    }

    /**
     * DELETE  /fonction-responsable-societes/:id : delete the "id" fonctionResponsableSociete.
     *
     * @param id the id of the fonctionResponsableSociete to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFonctionResponsableSociete(@PathVariable Integer id) {
        log.debug("REST request to delete FonctionResponsableSociete : {}", id);
        fonctionResponsableSocieteService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @GetMapping("/actif")
    public ResponseEntity<Collection<FonctionResponsableSocieteDTO>> findByActifIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get FonctionResponsableSociete by actif: {}", actif);
       Collection<FonctionResponsableSocieteDTO> EtatChambre= fonctionResponsableSocieteService.findByActifIn(actif);
        return ResponseEntity.ok().body(EtatChambre);
    }

}
