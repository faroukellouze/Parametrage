package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.ModeReglement;
import com.csys.parametrage.dto.ModeReglementDTO;
import com.csys.parametrage.dto.SecteurActiviteDTO;
import com.csys.parametrage.service.ModeReglementService;
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
 * REST controller for managing ModeReglement.
 */
@RestController
@RequestMapping("/api/mode-reglements")
public class ModeReglementResource {

    private final Logger log = LoggerFactory.getLogger(ModeReglementResource.class);
        
    private final ModeReglementService modeReglementService;

    public ModeReglementResource(ModeReglementService modeReglementService) {
        this.modeReglementService = modeReglementService;
    }

    /**
     * POST  /mode-reglements : Create a new modeReglement.
     *
     * @param modeReglement the modeReglement to create
     * @return the ResponseEntity with status 201 (Created) and with body the new modeReglement, or with status 400 (Bad Request) if the modeReglement has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping
    public ResponseEntity<ModeReglement> createModeReglement(@RequestBody @Valid ModeReglementDTO modeReglement) throws URISyntaxException {
       
        ModeReglement result = modeReglementService.save(modeReglement);
        return ResponseEntity.created(new URI("/api/mode-reglements/" + result.getCode()))
            .body(result);
    }

    /**
     * PUT  /mode-reglements : Updates an existing modeReglement.
     *
     * @param modeReglement the modeReglement to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated modeReglement,
     * or with status 400 (Bad Request) if the modeReglement is not valid,
     * or with status 500 (Internal Server Error) if the modeReglement couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping
    public ResponseEntity<ModeReglement> updateModeReglement(@RequestBody @Valid ModeReglementDTO modeReglement) throws URISyntaxException {
        
        ModeReglement result = modeReglementService.update(modeReglement);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * GET  /mode-reglements : get all the modeReglements.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of modeReglements in body
     */
    @GetMapping
    public List<ModeReglementDTO> getAllModeReglements() {
        log.debug("REST request to get all ModeReglements");
        return modeReglementService.findAll();
    }

    /**
     * GET  /mode-reglements/:id : get the "id" modeReglement.
     *
     * @param id the id of the modeReglement to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the modeReglement, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<ModeReglementDTO> getModeReglement(@PathVariable Integer id) {
        log.debug("REST request to get ModeReglement : {}", id);
        ModeReglementDTO modeReglement = modeReglementService.findOne(id);
        return ResponseEntity.ok().body(modeReglement);
    }

    /**
     * DELETE  /mode-reglements/:id : delete the "id" modeReglement.
     *
     * @param id the id of the modeReglement to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModeReglement(@PathVariable Integer id) {
        log.debug("REST request to delete ModeReglement : {}", id);
        modeReglementService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/actif")
    public ResponseEntity<Collection<ModeReglementDTO>> findByActifIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get ModeReglement by actif: {}", actif);
        Collection<ModeReglementDTO> modeReg = modeReglementService.findByActifIn(actif);
        return ResponseEntity.ok().body(modeReg);
    }
}
