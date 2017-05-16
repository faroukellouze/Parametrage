package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.SecteurActivite;
import com.csys.parametrage.dto.SecteurActiviteDTO;
import com.csys.parametrage.service.SecteurActiviteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.validation.Valid;

/**
 * REST controller for managing SecteurActivite.
 */
@RestController
@RequestMapping("/api/secteur-activites")
public class SecteurActiviteResource {

    private final Logger log = LoggerFactory.getLogger(SecteurActiviteResource.class);

    private final SecteurActiviteService secteurActiviteService;

    public SecteurActiviteResource(SecteurActiviteService secteurActiviteService) {
        this.secteurActiviteService = secteurActiviteService;
    }

    /**
     * POST /secteur-activites : Create a new secteurActivite.
     *
     * @param secteurActivite the secteurActivite to create
     * @return the ResponseEntity with status 201 (Created) and with body the
     * new secteurActivite, or with status 400 (Bad Request) if the
     * secteurActivite has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping
    public ResponseEntity<SecteurActivite> createSecteurActivite(@RequestBody @Valid SecteurActiviteDTO secteurActivite) throws URISyntaxException {
        log.debug("REST request to save SecteurActivite : {}", secteurActivite);
        SecteurActivite result = secteurActiviteService.save(secteurActivite);
        return ResponseEntity.created(new URI("/api/secteur-activites/" + result.getCode())).body(result);
    }

    /**
     * PUT /secteur-activites : Updates an existing secteurActivite.
     *
     * @param secteurActivite the secteurActivite to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated
     * secteurActivite, or with status 400 (Bad Request) if the secteurActivite
     * is not valid, or with status 500 (Internal Server Error) if the
     * secteurActivite couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping
    public ResponseEntity<SecteurActivite> updateSecteurActivite(@RequestBody @Valid SecteurActiviteDTO secteurActivite) throws URISyntaxException {
        log.debug("REST request to update SecteurActivite : {}", secteurActivite);
        SecteurActivite result = secteurActiviteService.update(secteurActivite);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * GET /secteur-activites : get all the secteurActivites.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of
     * secteurActivites in body
     */
    @GetMapping
    public List<SecteurActiviteDTO> getAllSecteurActivites() {
        log.debug("REST request to get all SecteurActivites");
        return secteurActiviteService.findAll();
    }

    /**
     * GET /secteur-activites/:id : get the "id" secteurActivite.
     *
     * @param id the id of the secteurActivite to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the
     * secteurActivite, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<SecteurActiviteDTO> getSecteurActivite(@PathVariable Integer id) {
        log.debug("REST request to get SecteurActivite : {}", id);
        SecteurActiviteDTO secteurActivite = secteurActiviteService.findOne(id);
        return ResponseEntity.ok().body(secteurActivite);
    }

    /**
     * DELETE /secteur-activites/:id : delete the "id" secteurActivite.
     *
     * @param id the id of the secteurActivite to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSecteurActivite(@PathVariable Integer id) {
        log.debug("REST request to delete SecteurActivite : {}", id);
        secteurActiviteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/actif")
    public ResponseEntity<Collection<SecteurActiviteDTO>> findByActifIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get SecteurActivite by actif: {}", actif);
        Collection<SecteurActiviteDTO> secteurActivite = secteurActiviteService.findByActifIn(actif);
        return ResponseEntity.ok().body(secteurActivite);
    }

}
