package com.csys.parametrage.web.rest;

//import com.codahale.metrics.annotation.Timed;
import com.csys.parametrage.domain.Banque;
import com.csys.parametrage.dto.BanqueDTO;
import com.csys.parametrage.dto.TypePieceJointeBordereauDTO;
import com.csys.parametrage.service.BanqueService;
import com.google.common.base.Preconditions;

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
 * REST controller for managing Banque.
 */
@RestController
@RequestMapping("/api/banques")
public class BanqueResource {

    private final Logger log = LoggerFactory.getLogger(BanqueResource.class);

    private final BanqueService banqueService;

    public BanqueResource(BanqueService banqueService) {
        this.banqueService = banqueService;
    }

    /**
     * POST  /banques : Create a new banque.
     *
     * @param banqueDTO the banqueDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new banqueDTO, or with status 400 (Bad Request) if the banque has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping
    public ResponseEntity<Banque> createBanque(@RequestBody @Valid BanqueDTO banqueDTO) throws URISyntaxException {
        log.debug("REST request to save Banque : {}", banqueDTO);
        Banque result = banqueService.save(banqueDTO);
        return ResponseEntity.created(new URI("/api/banques/" + result.getCode())).body(result);
    }

    /**
     * PUT  /banques : Updates an existing banque.
     *
     * @param banqueDTO the banqueDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated banqueDTO,
     * or with status 400 (Bad Request) if the banqueDTO is not valid,
     * or with status 500 (Internal Server Error) if the banqueDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping
    public ResponseEntity<Banque> updateBanque(@RequestBody @Valid BanqueDTO banqueDTO) throws URISyntaxException {
        log.debug("REST request to update Banque : {}", banqueDTO);
       
        Banque result = banqueService.update(banqueDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET  /banques : get all the banques.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of banques in body
     */
    @GetMapping
    public ResponseEntity<List<BanqueDTO>> getAllBanques() {
        log.debug("REST request to get all Banques");
        return ResponseEntity.ok().body(banqueService.findAll());
    }

    /**
     * GET  /banques/:id : get the "id" banque.
     *
     * @param id the id of the banqueDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the banqueDTO, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<BanqueDTO> getBanque(@PathVariable Integer id) {
        log.debug("REST request to get Banque : {}", id);
        BanqueDTO banqueDTO = banqueService.findOne(id);
        return ResponseEntity.ok().body(banqueDTO);
    }

    /**
     * DELETE  /banques/:id : delete the "id" banque.
     *
     * @param id the id of the banqueDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBanque(@PathVariable Integer id) {
        log.debug("REST request to delete Banque : {}", id);
        banqueService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    
     @GetMapping("/actif")
    public ResponseEntity<Collection<BanqueDTO>> findByActifIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get Banque by actif: {}", actif);
        Collection<BanqueDTO> banque = banqueService.findByActifIn(actif);
        return ResponseEntity.ok().body(banque);
    }

}
