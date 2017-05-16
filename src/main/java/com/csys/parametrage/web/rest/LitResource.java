package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.Lit;
import com.csys.parametrage.dto.LitDTO;
import com.csys.parametrage.service.LitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.validation.Valid;

/**
 * REST controller for managing Lit.
 */
@RestController
@RequestMapping("/api/lits")
public class LitResource {

    private final Logger log = LoggerFactory.getLogger(LitResource.class);

    private final LitService litService;

    public LitResource(LitService litService) {
        this.litService = litService;
    }

    /**
     * GET  /lits : get all the lits.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of lits in body
     */
    @GetMapping
    public ResponseEntity<List<LitDTO>> getAllLits() {
        log.debug("REST request to get all Lits");
        return ResponseEntity.ok().body(litService.findAll());
    }

    /**
     * GET  /lits/:id : get the "id" lit.
     *
     * @param id the id of the lit to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the lit, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<LitDTO> getLit(@PathVariable String id) {
        log.debug("REST request to get Lit : {}", id);
        LitDTO lit = litService.findOne(id);
        return ResponseEntity.ok().body(lit);
    }

}
