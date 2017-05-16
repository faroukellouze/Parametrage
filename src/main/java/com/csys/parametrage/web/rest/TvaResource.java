package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.Tva;
import com.csys.parametrage.dto.TvaDTO;
import com.csys.parametrage.service.TvaService;
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
 * REST controller for managing Tva.
 */
@RestController
@RequestMapping("/api/tvas")
public class TvaResource {

    private final Logger log = LoggerFactory.getLogger(TvaResource.class);

    private static final String ENTITY_NAME = "tva";
        
    private final TvaService tvaService;

    public TvaResource(TvaService tvaService) {
        this.tvaService = tvaService;
    }
    /**
     * GET  /tvas : get all the tvas.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of tvas in body
     */
    @GetMapping
    public List<TvaDTO> getAllTvas() {
        log.debug("REST request to get all Tvas");
        return tvaService.findAll();
    }

    /**
     * GET  /tvas/:id : get the "id" tva.
     *
     * @param id the id of the tva to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tva, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<TvaDTO> getTva(@PathVariable String id) {
        log.debug("REST request to get Tva : {}", id);
        TvaDTO tva = tvaService.findOne(id);
        return ResponseEntity.ok().body(tva);
    }

     @GetMapping("/actif")
    public ResponseEntity<Collection<TvaDTO>> findByActifIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get tvas by actif: {}", actif);
       Collection<TvaDTO> tvas= tvaService.findByActifIn(actif);
        return ResponseEntity.ok().body(tvas);
    }
    
}
