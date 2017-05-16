package com.csys.parametrage.web.rest;

import com.csys.parametrage.dto.CathegorieDTO;
import com.csys.parametrage.service.CathegorieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import javax.validation.Valid;

/**
 * REST controller for managing Cathegorie.
 */
@RestController
@RequestMapping("/api/cathegories")
public class CathegorieResource {

    private final Logger log = LoggerFactory.getLogger(CathegorieResource.class);

    private final CathegorieService cathegorieService;

    public CathegorieResource(CathegorieService cathegorieService) {
        this.cathegorieService = cathegorieService;
    }

    /**
     * POST /cathegories : Create a new cathegorie.
     *
     * @param cathegorie the cathegorie to create
     * @return the ResponseEntity with status 201 (Created) and with body the
     * new cathegorie, or with status 400 (Bad Request) if the cathegorie has
     * already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping
    public ResponseEntity<Boolean> createCathegorie(@RequestBody @Valid CathegorieDTO cathegorie) throws URISyntaxException {
        log.debug("REST request to save Cathegorie : {}", cathegorie);
        Boolean result = cathegorieService.save(cathegorie);
        return ResponseEntity.created(new URI("/api/cathegories/"))
                .body(result);
    }

    /**
     * PUT /cathegories : Updates an existing cathegorie.
     *
     * @param cathegorie the cathegorie to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated
     * cathegorie, or with status 400 (Bad Request) if the cathegorie is not
     * valid, or with status 500 (Internal Server Error) if the cathegorie
     * couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping
    public ResponseEntity<Boolean> updateCathegorie(@RequestBody @Valid CathegorieDTO cathegorie) throws URISyntaxException {
        log.debug("REST request to update Cathegorie : {}", cathegorie);
        Boolean result = cathegorieService.update(cathegorie);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET /cathegories : get all the cathegories.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of
     * cathegories in body
     */
    @GetMapping
    public ResponseEntity<Collection<CathegorieDTO>> getAllCathegories() {
        log.debug("REST request to get all Cathegories");
        return ResponseEntity.ok().body(cathegorieService.findAll());
    }

    /**
     * GET /cathegories/:id : get the "id" cathegorie.
     *
     * @param id the id of the cathegorie to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the
     * cathegorie, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<CathegorieDTO> getCathegorie(@PathVariable Integer id) {
        log.debug("REST request to get Cathegorie : {}", id);
        CathegorieDTO cathegorie = cathegorieService.findOne(id);
        return ResponseEntity.ok().body(cathegorie);
    }

    /**
     * DELETE /cathegories/:id : delete the "id" cathegorie.
     *
     * @param id the id of the cathegorie to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCathegorie(@PathVariable Integer id) {
        log.debug("REST request to delete Cathegorie : {}", id);
        cathegorieService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/actif")
    public ResponseEntity<Collection<CathegorieDTO>> findByActifIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get cathegorie by actif: {}", actif);
        Collection<CathegorieDTO> cathegorie = cathegorieService.findByActifIn(actif);
        return ResponseEntity.ok().body(cathegorie);
    }
}
