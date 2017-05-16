package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.FamilleFacturation;
import com.csys.parametrage.dto.FamilleFacturationDTO;
import com.csys.parametrage.service.FamilleFacturationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.validation.Valid;

/**
 * REST controller for managing FamilleFacturation.
 */
@RestController
@RequestMapping("/api/famille-facturations")
public class FamilleFacturationResource {

    private final Logger log = LoggerFactory.getLogger(FamilleFacturationResource.class);

    private static final String ENTITY_NAME = "familleFacturation";
        
    private final FamilleFacturationService familleFacturationService;

    public FamilleFacturationResource(FamilleFacturationService familleFacturationService) {
        this.familleFacturationService = familleFacturationService;
    }

    /**
     * GET  /famille-facturations : get all the familleFacturations.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of familleFacturations in body
     */
    @GetMapping
    public List<FamilleFacturationDTO> getAllFamilleFacturations() {
        log.debug("REST request to get all FamilleFacturations");
        return familleFacturationService.findAll();
    }

    /**
     * GET  /famille-facturations/:id : get the "id" familleFacturation.
     *
     * @param id the id of the familleFacturation to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the familleFacturation, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<FamilleFacturationDTO> getFamilleFacturation(@PathVariable Integer id) {
        log.debug("REST request to get FamilleFacturation : {}", id);
        FamilleFacturationDTO familleFacturation = familleFacturationService.findOne(id);
        return ResponseEntity.ok().body(familleFacturation);
    }
}
