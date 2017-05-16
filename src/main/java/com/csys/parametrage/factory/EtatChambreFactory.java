package com.csys.parametrage.factory;

import com.csys.parametrage.domain.EtatChambre;
import com.csys.parametrage.dto.EtatChambreDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class EtatChambreFactory {

    public static EtatChambre etatChambreDTOTOEtatChambre(EtatChambreDTO etatChambreDTO, EtatChambre etatChambre) {

        etatChambre.setDesignationAr(etatChambreDTO.getDesignationAr());
        etatChambre.setDesignation(etatChambreDTO.getDesignation());
        etatChambre.setActif(etatChambreDTO.isActif());
        etatChambre.setEtat(etatChambreDTO.isEtat());
        etatChambre.setColeur(etatChambreDTO.getCouleur());

        return etatChambre;
    }

    public static EtatChambreDTO etatChambreTOEtatChambreDTO(EtatChambre etatChambre) {
        if (etatChambre == null) {
            return null;
        }

        EtatChambreDTO etatChambreDTO = new EtatChambreDTO();

        etatChambreDTO.setCode(etatChambre.getCode());
        etatChambreDTO.setDesignationAr(etatChambre.getDesignationAr());
        etatChambreDTO.setDesignation(etatChambre.getDesignation());
        etatChambreDTO.setActif(etatChambre.isActif());
        etatChambreDTO.setUserCreation(etatChambre.getUserCreation());
        etatChambreDTO.setDateCreation(etatChambre.getDateCreation());
        etatChambreDTO.setEtat(etatChambre.isEtat());
        etatChambreDTO.setCouleur(etatChambre.getColeur());

        return etatChambreDTO;
    }

    public static Collection<EtatChambre> etatChambreDTOCollectionToEtatChambreCollection(Collection<EtatChambreDTO> etatChambreDTOCollection) {
        if (etatChambreDTOCollection == null) {
            return null;
        }

        Collection<EtatChambre> collection = new ArrayList<EtatChambre>();
        for (EtatChambreDTO etatChambreDTO : etatChambreDTOCollection) {
            EtatChambre etatChambre = new EtatChambre();
            collection.add(etatChambreDTOTOEtatChambre(etatChambreDTO,etatChambre));
        }

        return collection;
    }

    public static Collection<EtatChambreDTO> etatChambreCollectionToEtatChambreDTOCollection(Collection<EtatChambre> etatChambreCollection) {
        if (etatChambreCollection == null) {
            return null;
        }

        Collection<EtatChambreDTO> collection = new ArrayList<EtatChambreDTO>();
        for (EtatChambre etatChambre : etatChambreCollection) {
            collection.add(etatChambreTOEtatChambreDTO(etatChambre));
        }

        return collection;
    }

    public static EtatChambre createEtatChambre(EtatChambreDTO etatChambreDTO,String user) {
        if (etatChambreDTO == null) {
            return null;
        }
        EtatChambre etatChambre = new EtatChambre();
        etatChambreDTOTOEtatChambre(etatChambreDTO, etatChambre);
        etatChambre.setCode(null);
        etatChambre.setDateCreation(new Date());
        etatChambre.setUserCreation(user);
        return etatChambre;
    }
    
       public static EtatChambre createEtatChambreByCode(int code) {
       
        EtatChambre etatChambre = new EtatChambre();
        etatChambre.setCode(code);
        return etatChambre;
    }

}
