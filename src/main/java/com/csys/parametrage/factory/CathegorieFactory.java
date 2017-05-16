package com.csys.parametrage.factory;

import com.csys.parametrage.domain.Cathegorie;
import com.csys.parametrage.domain.Prestation;
import com.csys.parametrage.dto.CathegorieDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class CathegorieFactory {

    public static Cathegorie cathegorieDTOTOCathegorie(CathegorieDTO cathegorieDTO, Cathegorie cathegorie) {

        cathegorie.setDesignationAr(cathegorieDTO.getDesignationAr());
        cathegorie.setDesignation(cathegorieDTO.getDesignation());
        cathegorie.setActif(cathegorieDTO.isActif());
        cathegorie.setIsIcu(cathegorieDTO.isIsIcu());
        if (cathegorieDTO.getPrestSejour() != null) {
            Prestation prestSejour = new Prestation();
            prestSejour.setCode(cathegorieDTO.getPrestSejour().getCode());
            cathegorie.setPrestSejour(prestSejour);
        } else {
            cathegorie.setPrestSejour(null);
        }
        if (cathegorieDTO.getPrestAccompagnat() != null) {
            Prestation prestAcc = new Prestation();
            prestAcc.setCode(cathegorieDTO.getPrestAccompagnat().getCode());
            cathegorie.setPrestAccompagnat(prestAcc);
        } else {
            cathegorie.setPrestAccompagnat(null);
        }
        if (cathegorieDTO.getPrestSurveillance() != null) {
            Prestation prestSurv = new Prestation();
            prestSurv.setCode(cathegorieDTO.getPrestSurveillance().getCode());
            cathegorie.setPrestSurveillance(prestSurv);
        } else {
            cathegorie.setPrestSurveillance(null);
        }
        if (cathegorieDTO.getPrestSuivie() != null) {
            Prestation prestSuivit = new Prestation();
            prestSuivit.setCode(cathegorieDTO.getPrestSuivie().getCode());
            cathegorie.setPrestSuivie(prestSuivit);
        } else {
            cathegorie.setPrestSuivie(null);
        }
        return cathegorie;
    }

    public static CathegorieDTO cathegorieTOCathegorieDTO(Cathegorie cathegorie) {
        if (cathegorie == null) {
            return null;
        }

        CathegorieDTO cathegorieDTO = new CathegorieDTO();

        cathegorieDTO.setCode(cathegorie.getCode());
        cathegorieDTO.setDesignationAr(cathegorie.getDesignationAr());
        cathegorieDTO.setDesignation(cathegorie.getDesignation());
        cathegorieDTO.setActif(cathegorie.isActif());
        cathegorieDTO.setIsIcu(cathegorie.isIsIcu());
        cathegorieDTO.setPrestSejour(PrestationFactory.prestationTOPrestationDTO(cathegorie.getPrestSejour()));
        cathegorieDTO.setPrestAccompagnat(PrestationFactory.prestationTOPrestationDTO(cathegorie.getPrestAccompagnat()));
        cathegorieDTO.setPrestSuivie(PrestationFactory.prestationTOPrestationDTO(cathegorie.getPrestSuivie()));
        cathegorieDTO.setPrestSurveillance(PrestationFactory.prestationTOPrestationDTO(cathegorie.getPrestSurveillance()));
        cathegorieDTO.setUserCreation(cathegorie.getUserCreation());
        cathegorieDTO.setDateCreation(cathegorie.getDateCreation());
        return cathegorieDTO;
    }

    public static Collection<Cathegorie> cathegorieDTOCollectionToCathegorieCollection(Collection<CathegorieDTO> cathegorieDTOCollection) {
        if (cathegorieDTOCollection == null) {
            return null;
        }
        Collection<Cathegorie> collection = new ArrayList<Cathegorie>();
        for (CathegorieDTO cathegorieDTO : cathegorieDTOCollection) {
            Cathegorie cathegorie = new Cathegorie();
            collection.add(cathegorieDTOTOCathegorie(cathegorieDTO, cathegorie));
        }
        return collection;
    }

    public static Collection<CathegorieDTO> cathegorieCollectionToCathegorieDTOCollection(Collection<Cathegorie> cathegorieCollection) {
        if (cathegorieCollection == null) {
            return null;
        }
        Collection<CathegorieDTO> collection = new ArrayList<CathegorieDTO>();
        for (Cathegorie cathegorie : cathegorieCollection) {
            collection.add(cathegorieTOCathegorieDTO(cathegorie));
        }
        return collection;
    }

    public static Cathegorie createCathegorie(CathegorieDTO cathegorieDTO,String user) {
        if (cathegorieDTO == null) {
            return null;
        }
        Cathegorie cathegorie = new Cathegorie();
        cathegorieDTOTOCathegorie(cathegorieDTO, cathegorie);
        cathegorie.setCode(null);
        cathegorie.setDateCreation(new Date());
        cathegorie.setUserCreation(user);
        return cathegorie;
    }

        public static Cathegorie createCathegorieByCode(int code) {
        Cathegorie cathegorie = new Cathegorie();
        cathegorie.setCode(code);
        return cathegorie;
    }
    
}
