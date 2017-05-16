package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.SousFamillePrestation;
import com.csys.parametrage.dto.PrestationDTO;
import com.csys.parametrage.dto.SousFamillePrestationDTO;
import com.csys.parametrage.service.SousFamillePrestationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

/**
 * REST controller for managing SousFamillePrestation.
 */
@RestController
@RequestMapping("/api/sous-famille-prestations")
public class SousFamillePrestationResource {

    private final Logger log = LoggerFactory.getLogger(SousFamillePrestationResource.class);

    private final SousFamillePrestationService sousFamillePrestationService;

    public SousFamillePrestationResource(SousFamillePrestationService sousFamillePrestationService) {
        this.sousFamillePrestationService = sousFamillePrestationService;
    }

    /**
     * POST /sous-famille-prestations : Create a new sousFamillePrestation.
     *
     * @param sousFamillePrestation the sousFamillePrestation to create
     * @return the ResponseEntity with status 201 (Created) and with body the
     * new sousFamillePrestation, or with status 400 (Bad Request) if the
     * sousFamillePrestation has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping
    public ResponseEntity<Boolean> createSousFamillePrestation(@RequestBody @Valid SousFamillePrestationDTO sousFamillePrestation) throws URISyntaxException {
        log.debug("REST request to save SousFamillePrestation : {}", sousFamillePrestation);
        Boolean result = sousFamillePrestationService.save(sousFamillePrestation);
        return ResponseEntity.created(new URI("/api/sous-famille-prestations/"))
                .body(result);
    }

    /**
     * PUT /sous-famille-prestations : Updates an existing
     * sousFamillePrestation.
     *
     * @param sousFamillePrestation the sousFamillePrestation to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated
     * sousFamillePrestation, or with status 400 (Bad Request) if the
     * sousFamillePrestation is not valid, or with status 500 (Internal Server
     * Error) if the sousFamillePrestation couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping
    public ResponseEntity<Boolean> updateSousFamillePrestation(@RequestBody @Valid SousFamillePrestationDTO sousFamillePrestation) throws URISyntaxException {
        log.debug("REST request to update SousFamillePrestation : {}", sousFamillePrestation);
        Boolean result = sousFamillePrestationService.update(sousFamillePrestation);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET /sous-famille-prestations : get all the sousFamillePrestations.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of
     * sousFamillePrestations in body
     */
    @GetMapping
    public ResponseEntity<List<SousFamillePrestationDTO>> getAllSousFamillePrestations() {
        log.debug("REST request to get all SousFamillePrestations");
        return ResponseEntity.ok().body(sousFamillePrestationService.findAll());
    }

    /**
     * GET /sous-famille-prestations/:id : get the "id" sousFamillePrestation.
     *
     * @param id the id of the sousFamillePrestation to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the
     * sousFamillePrestation, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<SousFamillePrestationDTO> getSousFamillePrestation(@PathVariable Integer id) {
        log.debug("REST request to get SousFamillePrestation : {}", id);
        SousFamillePrestationDTO sousFamillePrestation = sousFamillePrestationService.findOne(id);
        return ResponseEntity.ok(sousFamillePrestation);
    }

    /**
     * DELETE /sous-famille-prestations/:id : delete the "id"
     * sousFamillePrestation.
     *
     * @param id the id of the sousFamillePrestation to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSousFamillePrestation(@PathVariable Integer id) {
        log.debug("REST request to delete SousFamillePrestation : {}", id);
        sousFamillePrestationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/actif")
    public ResponseEntity<List<SousFamillePrestationDTO>> findByActifIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get SousFamillePrestation by actif: {}", actif);
        List<SousFamillePrestationDTO> sousFamillePrestation = sousFamillePrestationService.findByActifIn(actif);
        return ResponseEntity.ok().body(sousFamillePrestation);
    }

    @GetMapping("/ActifCodeFamille/TypePrestation")
    public ResponseEntity<List<SousFamillePrestationDTO>> findByCodeFamilleCodeTypePrestationCodeAndActifIn(@RequestParam Collection<Boolean> actif, @RequestParam Integer codeTypePrestation) {
        log.debug("REST request to get SousFamillePrestation by codeTypePrestation and actif: {}", codeTypePrestation);
        List<SousFamillePrestationDTO> sousFamillePrestation = sousFamillePrestationService.findByCodeFamilleCodeTypePrestationCodeAndActifIn(codeTypePrestation, actif);
        return ResponseEntity.ok().body(sousFamillePrestation);
    }

}
