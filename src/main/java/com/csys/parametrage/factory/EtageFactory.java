package com.csys.parametrage.factory;

import com.csys.parametrage.domain.Etage;
import com.csys.parametrage.dto.EtageDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class EtageFactory {

    public static Etage etageDTOTOEtage(EtageDTO etageDTO, Etage etage) {

        etage.setDesignationAr(etageDTO.getDesignationAr());
        etage.setDesignation(etageDTO.getDesignation());
        etage.setActif(etageDTO.isActif());
        return etage;
    }

    public static EtageDTO etageTOEtageDTO(Etage etage) {
        if (etage == null) {
            return null;
        }

        EtageDTO etageDTO = new EtageDTO();

        etageDTO.setCode(etage.getCode());
        etageDTO.setDesignationAr(etage.getDesignationAr());
        etageDTO.setDesignation(etage.getDesignation());
        etageDTO.setActif(etage.isActif());
        etageDTO.setUserCreation(etage.getUserCreation());
        etageDTO.setDateCreation(etage.getDateCreation());

        return etageDTO;
    }

    public static Collection<Etage> etageDTOCollectionToEtageCollection(Collection<EtageDTO> etageDTOCollection) {
        if (etageDTOCollection == null) {
            return null;
        }

        Collection<Etage> collection = new ArrayList<Etage>();
        for (EtageDTO etageDTO : etageDTOCollection) {
            Etage etage = new Etage();
            collection.add(etageDTOTOEtage(etageDTO, etage));
        }

        return collection;
    }

    public static Collection<EtageDTO> etageCollectionToEtageDTOCollection(Collection<Etage> etageCollection) {
        if (etageCollection == null) {
            return null;
        }
        Collection<EtageDTO> collection = new ArrayList<EtageDTO>();
        for (Etage etage : etageCollection) {
            collection.add(etageTOEtageDTO(etage));
        }
        return collection;
    }

    public static Etage createEtage(EtageDTO etageDTO,String user) {
        if (etageDTO == null) {
            return null;
        }
        Etage etage = new Etage();
        etageDTOTOEtage(etageDTO, etage);
        etage.setCode(null);
        etage.setUserCreation(user);
        etage.setDateCreation(new Date());
        return etage;
    }
    
    public static Etage createEtageByCode(int code) {
        Etage etage = new Etage();
        etage.setCode(code);
        return etage;
    }
}
