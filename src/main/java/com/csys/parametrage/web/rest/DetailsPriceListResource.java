/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.web.rest;

import com.csys.parametrage.dto.PrixDTO;
import com.csys.parametrage.service.DetailsPriceListService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gh18
 */
@RestController
class DetailsPriceListResource {
    private final Logger log = LoggerFactory.getLogger(DetailsPriceListResource.class);
    private final DetailsPriceListService prixService;
    public DetailsPriceListResource(DetailsPriceListService prixService) {
        this.prixService = prixService;
    }
    @RequestMapping(value = "/api/prix", method = RequestMethod.GET)
    public List<PrixDTO> getCalcul(@RequestParam("CodePrestation") Integer CodePrestation,@RequestParam("CodeListeCouverture") Integer CodeListeCouverture,@RequestParam("CodePriceList") Integer CodePriceList,@RequestParam("CodeNatureAdmission") String CodeNatureAdmission) {
        return prixService.calculPrix(CodePrestation, CodeListeCouverture, CodePriceList, CodeNatureAdmission);
    }
}
