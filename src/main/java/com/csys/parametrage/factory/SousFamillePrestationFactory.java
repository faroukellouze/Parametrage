package com.csys.parametrage.factory;

import com.csys.parametrage.domain.FamillePrestation;
import com.csys.parametrage.domain.SousFamillePrestation;
import com.csys.parametrage.dto.SousFamillePrestationDTO;
import java.util.ArrayList;
import java.util.List;

public class SousFamillePrestationFactory {

    public static SousFamillePrestation sousFamillePrestationDTOTOSousFamillePrestation(SousFamillePrestationDTO sousFamillePrestationDto, SousFamillePrestation sousFamillePrestation) {
        if (sousFamillePrestationDto == null) {
            return null;
        }

        sousFamillePrestation.setCode(sousFamillePrestationDto.getCode());
        sousFamillePrestation.setDesignation(sousFamillePrestationDto.getDesignation());
        sousFamillePrestation.setDesignationAr(sousFamillePrestationDto.getDesignationAr());
        FamillePrestation fam = new FamillePrestation();
        fam.setCode(sousFamillePrestationDto.getCodeFamille().getCode());
        sousFamillePrestation.setCodeFamille(fam);
        sousFamillePrestation.setActif(sousFamillePrestationDto.isActif());
        return sousFamillePrestation;
    }

    public static SousFamillePrestationDTO sousFamillePrestationTOSousFamillePrestationDTO(SousFamillePrestation sousFamillePrestation) {
        if (sousFamillePrestation == null) {
            return null;
        }

        SousFamillePrestationDTO sousFamillePrestationDTO = new SousFamillePrestationDTO();
        sousFamillePrestationDTO.setCode(sousFamillePrestation.getCode());
        sousFamillePrestationDTO.setDesignation(sousFamillePrestation.getDesignation());
        sousFamillePrestationDTO.setDesignationAr(sousFamillePrestation.getDesignationAr());
        sousFamillePrestationDTO.setCodeFamille(FamillePrestationFactory.famillePrestationTOFamillePrestationDTO(sousFamillePrestation.getCodeFamille()));
        sousFamillePrestationDTO.setActif(sousFamillePrestation.isActif());
        return sousFamillePrestationDTO;
    }

    public static List<SousFamillePrestation> listSousFamillePrestationDTOTOlistSousFamillePrestation(List<SousFamillePrestationDTO> listSousFamillePrestationDto) {
        if (listSousFamillePrestationDto == null) {
            return null;
        }
        List<SousFamillePrestation> list = new ArrayList<SousFamillePrestation>();
        for (SousFamillePrestationDTO sousFamillePrestationDTO : listSousFamillePrestationDto) {
            SousFamillePrestation sousFamillePrestation = new SousFamillePrestation();
            list.add(sousFamillePrestationDTOTOSousFamillePrestation(sousFamillePrestationDTO, sousFamillePrestation));
        }
        return list;
    }

    public static List<SousFamillePrestationDTO> listSousFamillePrestationTOlistSousFamillePrestationDTO(List<SousFamillePrestation> listSousFamillePrestation) {
        if (listSousFamillePrestation == null) {
            return null;
        }
        List<SousFamillePrestationDTO> list = new ArrayList<SousFamillePrestationDTO>();
        for (SousFamillePrestation sousFamillePrestation : listSousFamillePrestation) {
            list.add(sousFamillePrestationTOSousFamillePrestationDTO(sousFamillePrestation));
        }
        return list;
    }
}
