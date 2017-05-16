/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.factory;

import com.csys.parametrage.domain.FonctionResponsableSociete;
import com.csys.parametrage.dto.FonctionResponsableSocieteDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class FonctionResponsableSocieteFactory {

    public static FonctionResponsableSociete fonctionResponsableSocieteDTOToFonctionResponsableSociete(FonctionResponsableSocieteDTO fctRespSocDTO) {
        FonctionResponsableSociete fctRespSoc = new FonctionResponsableSociete();
        fctRespSoc.setCode(fctRespSocDTO.getCode());
        fctRespSoc.setDesignation(fctRespSocDTO.getDesignation());
        fctRespSoc.setActif(fctRespSocDTO.isActif());
        return fctRespSoc;
    }

    public static FonctionResponsableSocieteDTO fonctionResponsableSocieteToFonctionResponsableSocieteDTO(FonctionResponsableSociete fctRespSoc) {
        FonctionResponsableSocieteDTO fctRespSocDTO = new FonctionResponsableSocieteDTO();
        fctRespSocDTO.setCode(fctRespSoc.getCode());
        fctRespSocDTO.setDesignation(fctRespSoc.getDesignation());
         fctRespSocDTO.setActif(fctRespSoc.isActif());
        return fctRespSocDTO;
    }

    public static List<FonctionResponsableSocieteDTO> listFonctionResponsableSocieteToListFonctionResponsableSocieteDTO(List<FonctionResponsableSociete> listFctRespSoc) {
        List<FonctionResponsableSocieteDTO> listFctRespSocDTO = new ArrayList<>();
        for (FonctionResponsableSociete fctRespSoc : listFctRespSoc) {
            listFctRespSocDTO.add(fonctionResponsableSocieteToFonctionResponsableSocieteDTO(fctRespSoc));
        }
        return listFctRespSocDTO;
    }

}
