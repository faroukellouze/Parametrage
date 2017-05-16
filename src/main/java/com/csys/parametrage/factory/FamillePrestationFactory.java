package com.csys.parametrage.factory;

import com.csys.parametrage.domain.FamillePrestation;
import com.csys.parametrage.dto.FamillePrestationDTO;
import java.util.ArrayList;
import java.util.List;

public class FamillePrestationFactory {

    public static FamillePrestation famillePrestationDTOTOFamillePrestation(FamillePrestationDTO famillePrestationDto, FamillePrestation famillePrestation) {
        if (famillePrestationDto == null) {
            return null;
        }
        famillePrestation.setCode(famillePrestationDto.getCode());
        famillePrestation.setDesignationAr(famillePrestationDto.getDesignationAr());
        famillePrestation.setDesignationEn(famillePrestationDto.getDesignationEn());
        famillePrestation.setActif(famillePrestationDto.isActif());
        famillePrestation.setCodeTypePrestation(TypePrestationFactory.typePrestationDTOTOTypePrestation(famillePrestationDto.getCodeTypePrestation(), famillePrestation.getCodeTypePrestation()));
        return famillePrestation;
    }

    public static FamillePrestationDTO famillePrestationTOFamillePrestationDTO(FamillePrestation famillePrestation) {
        if (famillePrestation == null) {
            return null;
        }
        FamillePrestationDTO famillePrestationDTO = new FamillePrestationDTO();
        famillePrestationDTO.setCode(famillePrestation.getCode());
        famillePrestationDTO.setDesignationAr(famillePrestation.getDesignationAr());
        famillePrestationDTO.setDesignationEn(famillePrestation.getDesignationEn());
        famillePrestationDTO.setPrefixe(famillePrestation.getPrefixe());
        famillePrestationDTO.setSuffixe(famillePrestation.getSuffixe());
        famillePrestationDTO.setActif(famillePrestation.isActif());
        famillePrestationDTO.setCodeTypePrestation(TypePrestationFactory.typePrestationTOTypePrestationDTO(famillePrestation.getCodeTypePrestation()));
        return famillePrestationDTO;
    }

    public static List<FamillePrestation> listFamillePrestationDTOTOlistFamillePrestation(List<FamillePrestationDTO> listFamillePrestationDto) {
        if (listFamillePrestationDto == null) {
            return null;
        }
        List<FamillePrestation> list = new ArrayList<FamillePrestation>();
        for (FamillePrestationDTO famillePrestationDTO : listFamillePrestationDto) {
            FamillePrestation famillePrestation = new FamillePrestation();
            list.add(famillePrestationDTOTOFamillePrestation(famillePrestationDTO, famillePrestation));
        }
        return list;
    }

    public static List<FamillePrestationDTO> listFamillePrestationTOlistFamillePrestationDTO(List<FamillePrestation> listFamillePrestation) {
        if (listFamillePrestation == null) {
            return null;
        }
        List<FamillePrestationDTO> list = new ArrayList<FamillePrestationDTO>();
        for (FamillePrestation famillePrestation : listFamillePrestation) {
            list.add(famillePrestationTOFamillePrestationDTO(famillePrestation));
        }
        return list;
    }

}
