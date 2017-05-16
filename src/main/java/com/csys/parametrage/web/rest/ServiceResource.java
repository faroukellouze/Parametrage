package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.Service;
import com.csys.parametrage.dto.ServiceDTO;
import com.csys.parametrage.service.ServiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;

/**
 * REST controller for managing Service.
 */
@RestController
@RequestMapping("/api/services")
public class ServiceResource {

    private final Logger log = LoggerFactory.getLogger(ServiceResource.class);

        
    private final ServiceService serviceService;

    public ServiceResource(ServiceService serviceService) {
        this.serviceService = serviceService;
    }


    /**
     * GET  /services : get all the services.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of services in body
     */
    @GetMapping
    
    public ResponseEntity<Collection<ServiceDTO>> getAllServices() {
        log.debug("REST request to get all Services");
        return ResponseEntity.ok().body(serviceService.findAll());
    }

    /**
     * GET  /services/:id : get the "id" service.
     *
     * @param id the id of the service to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the service, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    
    public ResponseEntity<ServiceDTO> getService(@PathVariable Integer id) {
        log.debug("REST request to get Service : {}", id);
        ServiceDTO service = serviceService.findOne(id);
        return ResponseEntity.ok().body(service);
    }

    @GetMapping("/actif")
    public ResponseEntity<Collection<ServiceDTO>> findByActifIn(@RequestParam Collection<Boolean> actif) {
        log.debug("REST request to get Service by actif: {}", actif);
       Collection<ServiceDTO> tvas= serviceService.findByActifIn(actif);
        return ResponseEntity.ok().body(tvas);
    }

}
