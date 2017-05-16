/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.factory;

import com.csys.parametrage.domain.ResponsableSociete;
import com.csys.parametrage.domain.ResponsaleContacte;
import com.csys.parametrage.domain.ResponsaleContactePK;
import com.csys.parametrage.dto.ResponsaleContacteDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class ResponsaleContacteFactory {

    public static ResponsaleContacte responsableContacteDTOToResponsableContacte(ResponsaleContacteDTO responsableDTO, ResponsableSociete respSoc) {
        ResponsaleContacte responsablecontacte = new ResponsaleContacte();
        ResponsaleContactePK responsablePK = new ResponsaleContactePK();
        responsablePK.setCodeTypeContact(responsableDTO.getCodeTypeContact().getCode());
        responsablePK.setValeur(responsableDTO.getValeur());
        responsablecontacte.setResponsaleContactePK(responsablePK);
        responsablecontacte.setResponsableSociete(respSoc);
        return responsablecontacte;
    }

    public static ResponsaleContacteDTO responsableContacteTOResponsableContacteDTO(ResponsaleContacte responsable) {
        ResponsaleContacteDTO responsableDTO = new ResponsaleContacteDTO();
        responsableDTO.setCodeResponsable(responsable.getResponsaleContactePK().getCodeResponsable());
        responsableDTO.setCodeTypeContact(TypeContacteFactory.typeContacteToTypeContacteDTO(responsable.getTypeContacte()));
        responsableDTO.setValeur(responsable.getResponsaleContactePK().getValeur());
        return responsableDTO;
    }

    public static List<ResponsaleContacte> listResponsableContacteDTOToListResponsableContacte(Collection<ResponsaleContacteDTO> responsableDTO, ResponsableSociete respSoc) {
        List<ResponsaleContacte> listResponsableContacte = new ArrayList<>();
        for (ResponsaleContacteDTO respdto : responsableDTO) {
            listResponsableContacte.add(responsableContacteDTOToResponsableContacte(respdto, respSoc));
        }
        return listResponsableContacte;
    }

    public static List<ResponsaleContacteDTO> listResponsableSocieteToListResponsableSocieteDTO(Collection<ResponsaleContacte> responsable) {
        List<ResponsaleContacteDTO> listResponsableContactedto = new ArrayList<>();
        for (ResponsaleContacte resp : responsable) {
            listResponsableContactedto.add(responsableContacteTOResponsableContacteDTO(resp));
        }
        return listResponsableContactedto;
    }

}
