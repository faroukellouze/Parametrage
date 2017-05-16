package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.FamillePrestation;
import com.csys.parametrage.dto.FamillePrestationDTO;
import com.csys.parametrage.dto.PrestationDTO;
import com.csys.parametrage.service.FamillePrestationService;
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
 * REST controller for managing FamillePrestation.
 */
@RestController
@RequestMapping("/api/famille-prestations")
public class FamillePrestationResource {

    private final Logger log = LoggerFactory.getLogger(FamillePrestationResource.class);

    private final FamillePrestationService famillePrestationService;

    public FamillePrestationResource(FamillePrestationService famillePrestationService) {
        this.famillePrestationService = famillePrestationService;
    }

    /**
     * POST  /famille-prestations : Create a new famillePrestation.
     *
     * @param famillePrestation the famillePrestation to create
     * @return the ResponseEntity with status 201 (Created) and with body the new famillePrestation, or with status 400 (Bad Request) if the famillePrestation has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping
    public ResponseEntity<Boolean> createFamillePrestation(@RequestBody  @Valid FamillePrestationDTO famillePrestation) throws URISyntaxException {
        log.debug("REST request to save FamillePrestation : {}", famillePrestation);
        Boolean result = famillePrestationService.save(famillePrestation);
        return ResponseEntity.created(new URI("/api/famille-prestations/")).body(result);
    }

    /**
     * PUT  /famille-prestations : Updates an existing famillePrestation.
     *
     * @param famillePrestation the famillePrestation to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated famillePrestation,
     * or with status 400 (Bad Request) if the famillePrestation is not valid,
     * or with status 500 (Internal Server Error) if the famillePrestation couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping
    public ResponseEntity<Boolean> updateFamillePrestation(@RequestBody  @Valid FamillePrestationDTO famillePrestation) throws URISyntaxException {
        log.debug("REST request to update FamillePrestation : {}", famillePrestation);
        Boolean result = famillePrestationService.update(famillePrestation);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET  /famille-prestations : get all the famillePrestations.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of famillePrestations in body
     */
    @GetMapping
    public ResponseEntity<List<FamillePrestationDTO>> getAllFamillePrestations() {
        log.debug("REST request to get all FamillePrestations");
        return ResponseEntity.ok().body(famillePrestationService.findAll());
    }

    /**
     * GET  /famille-prestations/:id : get the "id" famillePrestation.
     *
     * @param id the id of the famillePrestation to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the famillePrestation, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<FamillePrestationDTO> getFamillePrestation(@PathVariable Integer id) {
        log.debug("REST request to get FamillePrestation : {}", id);
        FamillePrestationDTO famillePrestation = famillePrestationService.findOne(id);
        return ResponseEntity.ok().body(famillePrestation);
    }

    /**
     * DELETE  /famille-prestations/:id : delete the "id" famillePrestation.
     *
     * @param id the id of the famillePrestation to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFamillePrestation(@PathVariable Integer id) {
        log.debug("REST request to delete FamillePrestation : {}", id);
        famillePrestationService.delete(id);
        return ResponseEntity.noContent().build();
    }

     @GetMapping("/actif")
    public ResponseEntity<List<FamillePrestationDTO>> findByActifIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get FamillePrestation by actif: {}", actif);
       List<FamillePrestationDTO> famillePrestation= famillePrestationService.findByActifIn(actif);
        return ResponseEntity.ok().body(famillePrestation);
    }
    
}
