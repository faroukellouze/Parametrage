/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.factory;

import com.csys.parametrage.domain.Chambre;
import com.csys.parametrage.domain.Lit;
import com.csys.parametrage.dto.LitDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public final class LitFactory {

    public static Lit litDTOToLit(LitDTO litDTO, Lit lit) {
        lit.setNumLit(litDTO.getNumLit());
        lit.setCoefficient(litDTO.getCoefficient());
        lit.setActif(litDTO.isActif());
        lit.setEtatLit(EtatChambreFactory.createEtatChambreByCode(litDTO.getEtatLit().getCode()));
        return lit;
    }

    public static LitDTO litToLitDTO(Lit lit) {

        if (lit != null) {
            LitDTO litDTO = new LitDTO();
            litDTO.setNumLit(lit.getNumLit());
            litDTO.setCoefficient(lit.getCoefficient());
            litDTO.setActif(lit.isActif());
            litDTO.setNumChambre(lit.getNumChambre().getCode());
            litDTO.setUserCreation(lit.getUserCreation());
            litDTO.setDateCreation(lit.getDateCreation());
            litDTO.setEtatLit(EtatChambreFactory.etatChambreTOEtatChambreDTO(lit.getEtatLit()));
            return litDTO;
        } else {
            return null;
        }
    }

    public static List<LitDTO> listLitTolistLitDTO(Collection<Lit> Listlit) {
        List<LitDTO> listLitDTO = new ArrayList<>();
        for (Lit lit : Listlit) {
            listLitDTO.add(litToLitDTO(lit));
        }
        return listLitDTO;
    }

    public static Lit createLit(LitDTO litDTO, Chambre chambre) {
        if (litDTO == null) {
            return null;
        }
        Lit lit = new Lit();
        litDTOToLit(litDTO, lit);
        lit.setNumChambre(chambre);
        lit.setUserCreation(chambre.getUserCreate());
        lit.setDateCreation(new Date());
        return lit;
    }

    public static List<Lit> createListLit(Collection<LitDTO> Listlitdto, Chambre chambre) {
        List<Lit> listLit = new ArrayList<>();
        for (LitDTO litdto : Listlitdto) {
            listLit.add(createLit(litdto, chambre));
        }
        return listLit;
    }

}
