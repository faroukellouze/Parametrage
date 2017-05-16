/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.factory;

import com.csys.parametrage.domain.SecteurActivite;
import com.csys.parametrage.dto.SecteurActiviteDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class SecteurActiviteFactory {

    public static SecteurActivite secteurActiviteDTOToSecteurActivite(SecteurActiviteDTO secteurActiviteDTO) {
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setCode(secteurActiviteDTO.getCode());
        secteurActivite.setDesignation(secteurActiviteDTO.getDesignation());
        secteurActivite.setActif(secteurActiviteDTO.isActif());
        return secteurActivite;
    }

    public static SecteurActiviteDTO secteurActiviteToSecteurActiviteDTO(SecteurActivite secteurActivite) {
        SecteurActiviteDTO secteurActiviteDTO = new SecteurActiviteDTO();
        secteurActiviteDTO.setCode(secteurActivite.getCode());
        secteurActiviteDTO.setDesignation(secteurActivite.getDesignation());
        secteurActiviteDTO.setActif(secteurActivite.isActif());
        return secteurActiviteDTO;
    }

    public static List<SecteurActiviteDTO> listSecteurActiviteToSecteurActiviteDTO(List<SecteurActivite> listSecteurActivite) {
        List<SecteurActiviteDTO> listSecteurActiviteDTO = new ArrayList<>();
        for (SecteurActivite secteurActivite : listSecteurActivite) {
            listSecteurActiviteDTO.add(secteurActiviteToSecteurActiviteDTO(secteurActivite));
        }
        return listSecteurActiviteDTO;
    }
}
