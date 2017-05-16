package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.TypePrestation;
import com.csys.parametrage.dto.TypePrestationDTO;
import com.csys.parametrage.service.TypePrestationService;
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
 * REST controller for managing TypePrestation.
 */
@RestController
@RequestMapping("/api/type-prestations")
public class TypePrestationResource {

    private final Logger log = LoggerFactory.getLogger(TypePrestationResource.class);

    private static final String ENTITY_NAME = "typePrestation";
        
    private final TypePrestationService typePrestationService;

    public TypePrestationResource(TypePrestationService typePrestationService) {
        this.typePrestationService = typePrestationService;
    }
   
    /**
     * GET  /type-prestations : get all the typePrestations.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of typePrestations in body
     */
    @GetMapping
    public List<TypePrestationDTO> getAllTypePrestations() {
        log.debug("REST request to get all TypePrestations");
        return typePrestationService.findAll();
    }

    /**
     * GET  /type-prestations/:id : get the "id" typePrestation.
     *
     * @param id the id of the typePrestation to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the typePrestation, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<TypePrestationDTO> getTypePrestation(@PathVariable Integer id) {
        log.debug("REST request to get TypePrestation : {}", id);
        TypePrestationDTO typePrestation = typePrestationService.findOne(id);
        return ResponseEntity.ok().body(typePrestation);
    }
    
     @GetMapping("/actif")
    public ResponseEntity<Collection<TypePrestationDTO>> findByActifIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get TypePrestation by actif: {}", actif);
       Collection<TypePrestationDTO> EtatChambre= typePrestationService.findByActifIn(actif);
        return ResponseEntity.ok().body(EtatChambre);
    }

}
