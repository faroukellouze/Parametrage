package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.Chambre;
import com.csys.parametrage.dto.ChambreDTO;
import com.csys.parametrage.service.ChambreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import javax.validation.Valid;

/**
 * REST controller for managing Chambre.
 */
@RestController
@RequestMapping("/api/chambres")
public class ChambreResource {

    private final Logger log = LoggerFactory.getLogger(ChambreResource.class);

    private final ChambreService chambreService;

    public ChambreResource(ChambreService chambreService) {
        this.chambreService = chambreService;
    }

    /**
     * POST  /chambres : Create a new chambre.
     *
     * @param chambre the chambre to create
     * @return the ResponseEntity with status 201 (Created) and with body the new chambre, or with status 400 (Bad Request) if the chambre has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping
    public ResponseEntity<Boolean> createChambre(@RequestBody @Valid ChambreDTO chambre) throws URISyntaxException {
        log.debug("REST request to save Chambre : {}", chambre);
        Boolean result = chambreService.save(chambre);
        return ResponseEntity.created(new URI("/api/chambres/")).body(result);
    }

    /**
     * PUT  /chambres : Updates an existing chambre.
     *
     * @param chambre the chambre to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated chambre,
     * or with status 400 (Bad Request) if the chambre is not valid,
     * or with status 500 (Internal Server Error) if the chambre couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping
    
    public ResponseEntity<Boolean> updateChambre(@RequestBody @Valid ChambreDTO chambre) throws URISyntaxException {
        log.debug("REST request to update Chambre : {}", chambre.getCode());
       
        Boolean result = chambreService.update(chambre);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET  /chambres : get all the chambres.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of chambres in body
     */
    @GetMapping
    
    public ResponseEntity<Collection<ChambreDTO>> getAllChambres() {
        log.debug("REST request to get all Chambres");
        return ResponseEntity.ok().body(chambreService.findAll());
    }

    /**
     * GET  /chambres/:id : get the "id" chambre.
     *
     * @param id the id of the chambre to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the chambre, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    
    public ResponseEntity<ChambreDTO> getChambre(@PathVariable Integer id) {
        log.debug("REST request to get Chambre : {}", id);
        ChambreDTO chambre = chambreService.findOne(id);
        return ResponseEntity.ok().body(chambre);
    }

    /**
     * DELETE  /chambres/:id : delete the "id" chambre.
     *
     * @param id the id of the chambre to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/{id}")
    
    public ResponseEntity<Void> deleteChambre(@PathVariable Integer id) {
        log.debug("REST request to delete Chambre : {}", id);
        chambreService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @GetMapping("/test/{id}")
    
    public ResponseEntity<Chambre> test(@PathVariable Integer id) {
        log.debug("REST request to get Chambre : {}", id);
        Chambre chambre = chambreService.test(id);
        return ResponseEntity.ok().body(chambre);
    }

    @GetMapping("/actif")
    public ResponseEntity<Collection<ChambreDTO>> findByActifIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get chambre by actif: {}", actif);
        Collection<ChambreDTO> chambre = chambreService.findByActifIn(actif);
        return ResponseEntity.ok().body(chambre);
    }
    
}
