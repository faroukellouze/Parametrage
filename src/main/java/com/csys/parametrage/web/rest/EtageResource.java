package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.Etage;
import com.csys.parametrage.dto.EtageDTO;
import com.csys.parametrage.service.EtageService;
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
 * REST controller for managing Etage.
 */
@RestController
@RequestMapping("/api/etages")
public class EtageResource {

    private final Logger log = LoggerFactory.getLogger(EtageResource.class);

    private final EtageService etageService;

    public EtageResource(EtageService etageService) {
        this.etageService = etageService;
    }

    /**
     * POST  /etages : Create a new etage.
     *
     * @param etage the etage to create
     * @return the ResponseEntity with status 201 (Created) and with body the new etage, or with status 400 (Bad Request) if the etage has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping
    
    public ResponseEntity<Boolean> createEtage(@RequestBody @Valid EtageDTO etage) throws URISyntaxException {
        log.debug("REST request to save Etage : {}", etage);
        Boolean result = etageService.save(etage);
        return ResponseEntity.created(new URI("/api/etages/")).body(result);
    }

    /**
     * PUT  /etages : Updates an existing etage.
     *
     * @param etage the etage to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated etage,
     * or with status 400 (Bad Request) if the etage is not valid,
     * or with status 500 (Internal Server Error) if the etage couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping
    
    public ResponseEntity<Boolean> updateEtage(@RequestBody @Valid EtageDTO etage) throws URISyntaxException {
        log.debug("REST request to update Etage : {}", etage);
        Boolean result = etageService.update(etage);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET  /etages : get all the etages.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of etages in body
     */
    @GetMapping
    public ResponseEntity<Collection<EtageDTO>> getAllEtages() {
        log.debug("REST request to get all Etages");
        return ResponseEntity.ok().body(etageService.findAll());
    }

    /**
     * GET  /etages/:id : get the "id" etage.
     *
     * @param id the id of the etage to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the etage, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    
    public ResponseEntity<EtageDTO> getEtage(@PathVariable Integer id) {
        log.debug("REST request to get Etage : {}", id);
        EtageDTO etage = etageService.findOne(id);
        return ResponseEntity.ok().body(etage);
    }

    /**
     * DELETE  /etages/:id : delete the "id" etage.
     *
     * @param id the id of the etage to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/{id}")
    
    public ResponseEntity<Void> deleteEtage(@PathVariable Integer id) {
        log.debug("REST request to delete Etage : {}", id);
        etageService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
     @GetMapping("/actif")
    public ResponseEntity<Collection<EtageDTO>> findByActifIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get Prestation by actif: {}", actif);
       Collection<EtageDTO> etage= etageService.findByActifIn(actif);
        return ResponseEntity.ok().body(etage);
    }

}
