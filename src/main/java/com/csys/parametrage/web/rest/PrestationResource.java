package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.Prestation;
import com.csys.parametrage.projection.PrestationCodeDes;
import com.csys.parametrage.dto.PrestationDTO;
import com.csys.parametrage.service.PrestationService;
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
 * REST controller for managing Prestation.
 */
@RestController
@RequestMapping("/api/prestations")
public class PrestationResource {

    private final Logger log = LoggerFactory.getLogger(PrestationResource.class);

    private final PrestationService prestationService;

    public PrestationResource(PrestationService prestationService) {
        this.prestationService = prestationService;
    }

    /**
     * POST  /prestations : Create a new prestation.
     *
     * @param prestation the prestation to create
     * @return the ResponseEntity with status 201 (Created) and with body the new prestation, or with status 400 (Bad Request) if the prestation has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping
    public ResponseEntity<Boolean> createPrestation(@RequestBody  @Valid PrestationDTO prestation) throws URISyntaxException {
        log.debug("REST request to save Prestation : {}", prestation);
        
        Boolean result = prestationService.save(prestation);
        return ResponseEntity.created(new URI("/api/prestations/" )).body(result);
    }

    /**
     * PUT  /prestations : Updates an existing prestation.
     *
     * @param prestation the prestation to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated prestation,
     * or with status 400 (Bad Request) if the prestation is not valid,
     * or with status 500 (Internal Server Error) if the prestation couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping
    public ResponseEntity<Boolean> updatePrestation(@RequestBody  @Valid PrestationDTO prestation) throws URISyntaxException {
        log.debug("REST request to update Prestation : {}", prestation);
        Boolean result = prestationService.update(prestation);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET  /prestations : get all the prestations.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of prestations in body
     */
    @GetMapping
    public ResponseEntity<List<PrestationDTO>> getAllPrestations() {
        log.debug("REST request to get all Prestations");
        return ResponseEntity.ok().body(prestationService.findAll());
    }

    /**
     * GET  /prestations/:id : get the "id" prestation.
     *
     * @param id the id of the prestation to retrieve
     * @return the ResponseEntity with status 204 (no content) and with body the prestation, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<PrestationDTO> getPrestation(@PathVariable Integer id) {
        log.debug("REST request to get Prestation : {}", id);
        PrestationDTO prestation = prestationService.findOne(id);
        return ResponseEntity.ok().body(prestation);
    }

    @GetMapping("/actif")
    public ResponseEntity<List<PrestationDTO>> findByActifIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get Prestation by actif: {}", actif);
       List<PrestationDTO> prestation= prestationService.findByActifIn(actif);
        return ResponseEntity.ok().body(prestation);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestation(@PathVariable Integer id) {
        log.debug("REST request to delete Prestation : {}", id);
        prestationService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/actifAndPrestationSejour")
    public ResponseEntity<List<PrestationCodeDes>> findByActifInCodeTypePrestationCodeIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get Prestation");
       List<PrestationCodeDes> prestation= prestationService.findByActifInCodeTypePrestationCodeIn(actif);
        return ResponseEntity.ok().body(prestation);
    }

}
