package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.Param;
import com.csys.parametrage.service.ParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * REST controller for managing Param.
 */
@RestController
@RequestMapping("/api")
public class ParamResource {

    private final Logger log = LoggerFactory.getLogger(ParamResource.class);
 
    private final ParamService paramService;

    public ParamResource(ParamService paramService) {
        this.paramService = paramService;
    }
    @GetMapping("/params/{id}")
    public ResponseEntity<Param> getParam(@PathVariable String id) {
        log.debug("REST request to get Param : {}", id);
        Param param = paramService.findOne(id);
        return ResponseEntity.ok().body(param);
    }

}
