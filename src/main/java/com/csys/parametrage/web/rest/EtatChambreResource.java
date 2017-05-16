package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.EtatChambre;
import com.csys.parametrage.dto.EtatChambreDTO;
import com.csys.parametrage.service.EtatChambreService;
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
 * REST controller for managing EtatChambre.
 */
@RestController
@RequestMapping("/api/etat-chambres")
public class EtatChambreResource {

    private final Logger log = LoggerFactory.getLogger(EtatChambreResource.class);

    private final EtatChambreService etatChambreService;

    public EtatChambreResource(EtatChambreService etatChambreService) {
        this.etatChambreService = etatChambreService;
    }

    /**
     * POST /etat-chambres : Create a new etatChambre.
     *
     * @param etatChambre the etatChambre to create
     * @return the ResponseEntity with status 201 (Created) and with body the
     * new etatChambre, or with status 400 (Bad Request) if the etatChambre has
     * already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping

    public ResponseEntity<Boolean> createEtatChambre(@RequestBody @Valid EtatChambreDTO etatChambre) throws URISyntaxException {
        log.debug("REST request to save EtatChambre : {}", etatChambre);
        Boolean result = etatChambreService.save(etatChambre);
        return ResponseEntity.created(new URI("/api/etat-chambres/")).body(result);
    }

    /**
     * PUT /etat-chambres : Updates an existing etatChambre.
     *
     * @param etatChambre the etatChambre to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated
     * etatChambre, or with status 400 (Bad Request) if the etatChambre is not
     * valid, or with status 500 (Internal Server Error) if the etatChambre
     * couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping

    public ResponseEntity<Boolean> updateEtatChambre(@RequestBody @Valid EtatChambreDTO etatChambre) throws URISyntaxException {
        log.debug("REST request to update EtatChambre : {}", etatChambre);
        Boolean result = etatChambreService.update(etatChambre);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET /etat-chambres : get all the etatChambres.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of
     * etatChambres in body
     */
    @GetMapping

    public ResponseEntity<Collection<EtatChambreDTO>> getAllEtatChambres() {
        log.debug("REST request to get all EtatChambres");
        return ResponseEntity.ok().body(etatChambreService.findAll());
    }

    /**
     * GET /etat-chambres/:id : get the "id" etatChambre.
     *
     * @param id the id of the etatChambre to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the
     * etatChambre, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")

    public ResponseEntity<EtatChambreDTO> getEtatChambre(@PathVariable Integer id) {
        log.debug("REST request to get EtatChambre : {}", id);
        EtatChambreDTO etatChambre = etatChambreService.findOne(id);
        return ResponseEntity.ok().body(etatChambre);
    }

    /**
     * DELETE /etat-chambres/:id : delete the "id" etatChambre.
     *
     * @param id the id of the etatChambre to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteEtatChambre(@PathVariable Integer id) {
        log.debug("REST request to delete EtatChambre : {}", id);
        etatChambreService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/actif")
    public ResponseEntity<Collection<EtatChambreDTO>> findByActifIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get EtatChambre by actif: {}", actif);
        Collection<EtatChambreDTO> EtatChambre = etatChambreService.findByActifIn(actif);
        return ResponseEntity.ok().body(EtatChambre);
    }

    @GetMapping("/ActifAndEtat")
    public ResponseEntity<Collection<EtatChambreDTO>> findByActifAndEtat(@RequestParam Boolean actif, @RequestParam Boolean etat) {
        log.debug("REST request to get EtatChambre by ActifAndEtat: {}", actif, etat);
        Collection<EtatChambreDTO> EtatChambre = etatChambreService.findByActifAndEtat(actif, etat);
        return ResponseEntity.ok().body(EtatChambre);
    }

}
