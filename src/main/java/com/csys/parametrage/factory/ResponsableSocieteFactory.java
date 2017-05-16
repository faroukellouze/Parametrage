/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.factory;

import com.csys.parametrage.domain.ResponsableSociete;
import com.csys.parametrage.domain.Societe;
import com.csys.parametrage.dto.ResponsableSocieteDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class ResponsableSocieteFactory {

    public static ResponsableSociete responsableSocieteDTOToResponsableSociete(ResponsableSocieteDTO responsableDTO, Societe societe) {
        ResponsableSociete responsable = new ResponsableSociete();
        responsable.setCode(responsableDTO.getCode());
        responsable.setNomResponsable(responsableDTO.getNomResponsable());
        responsable.setCodeFonctionResponsableSociete(FonctionResponsableSocieteFactory.fonctionResponsableSocieteDTOToFonctionResponsableSociete(responsableDTO.getCodeFonctionResponsableSociete()));
        responsable.setSociete(societe);
        responsable.setActif(true);
        responsable.setUserCreation(societe.getUserCreation());
        responsable.setDateCreation(new Date());
        responsable.setResponsableContacteCollection(ResponsaleContacteFactory.listResponsableContacteDTOToListResponsableContacte(responsableDTO.getCodeTypeContact(), responsable));
        return responsable;
    }

    public static ResponsableSocieteDTO responsableSocieteTOResponsableSocieteDTO(ResponsableSociete responsable) {
        ResponsableSocieteDTO responsableDTO = new ResponsableSocieteDTO();
        responsableDTO.setCode(responsable.getCode());
        responsableDTO.setNomResponsable(responsable.getNomResponsable());
        responsableDTO.setCodeFonctionResponsableSociete(FonctionResponsableSocieteFactory.fonctionResponsableSocieteToFonctionResponsableSocieteDTO(responsable.getCodeFonctionResponsableSociete()));
//        responsableDTO.setActif(responsable.getActif());
        responsableDTO.setCodeSociete(responsable.getSociete().getCode());
        responsableDTO.setCodeTypeContact(ResponsaleContacteFactory.listResponsableSocieteToListResponsableSocieteDTO(responsable.getResponsableContacteCollection()));
        return responsableDTO;
    }

    public static Collection<ResponsableSociete> listResponsableSocieteDTOToListResponsableSociete(Collection<ResponsableSocieteDTO> responsableDTO, Societe societe) {
        List<ResponsableSociete> listResponsableSociete = new ArrayList<>();
        for (ResponsableSocieteDTO respdto : responsableDTO) {
            listResponsableSociete.add(responsableSocieteDTOToResponsableSociete(respdto, societe));
        }
        return listResponsableSociete;
    }

    public static List<ResponsableSocieteDTO> listResponsableSocieteToListResponsableSocieteDTO(Collection<ResponsableSociete> responsable) {
        List<ResponsableSocieteDTO> listResponsableSocietedto = new ArrayList<>();
        for (ResponsableSociete resp : responsable) {
            listResponsableSocietedto.add(responsableSocieteTOResponsableSocieteDTO(resp));
        }
        return listResponsableSocietedto;
    }

}
