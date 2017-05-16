package com.csys.parametrage.factory;

import com.csys.parametrage.domain.FamilleFacturation;
import com.csys.parametrage.dto.FamilleFacturationDTO;
import java.util.ArrayList;
import java.util.List;

public class FamilleFacturationFactory {

    public static FamilleFacturation familleFacturationDTOTOFamilleFacturation(FamilleFacturationDTO familleFacturationDto, FamilleFacturation familleFacturation) {
        if (familleFacturationDto == null) {
            return null;
        }
        familleFacturation.setCode(familleFacturationDto.getCode());
        familleFacturation.setCodeFamilleSaisie(familleFacturationDto.getCodeFamilleSaisie());
        familleFacturation.setDesignationAr(familleFacturationDto.getDesignationAr());
        familleFacturation.setMemo(familleFacturationDto.getMemo());
        familleFacturation.setOrdre(familleFacturationDto.getOrdre());
        familleFacturation.setActif(familleFacturationDto.isActif());

        return familleFacturation;
    }

    public static FamilleFacturationDTO familleFacturationTOFamilleFacturationDTO(FamilleFacturation familleFacturation) {
        if (familleFacturation == null) {
            return null;
        }

        FamilleFacturationDTO familleFacturationDTO = new FamilleFacturationDTO();

        familleFacturationDTO.setCode(familleFacturation.getCode());
        familleFacturationDTO.setCodeFamilleSaisie(familleFacturation.getCodeFamilleSaisie());
        familleFacturationDTO.setDesignationAr(familleFacturation.getDesignationAr());
        familleFacturationDTO.setMemo(familleFacturation.getMemo());
        familleFacturationDTO.setOrdre(familleFacturation.getOrdre());
        familleFacturationDTO.setActif(familleFacturation.isActif());
        return familleFacturationDTO;
    }

    public static List<FamilleFacturation> listFamilleFacturationDTOTOlistFamilleFacturation(List<FamilleFacturationDTO> listFamilleFacturationDto) {
        if (listFamilleFacturationDto == null) {
            return null;
        }

        List<FamilleFacturation> list = new ArrayList<FamilleFacturation>();
        for (FamilleFacturationDTO familleFacturationDTO : listFamilleFacturationDto) {
            FamilleFacturation familleFacturation = new FamilleFacturation();
            list.add(familleFacturationDTOTOFamilleFacturation(familleFacturationDTO, familleFacturation));
        }

        return list;
    }

    public static List<FamilleFacturationDTO> listFamilleFacturationTOlistFamilleFacturationDTO(List<FamilleFacturation> listFamilleFacturation) {
        if (listFamilleFacturation == null) {
            return null;
        }

        List<FamilleFacturationDTO> list = new ArrayList<FamilleFacturationDTO>();
        for (FamilleFacturation familleFacturation : listFamilleFacturation) {
            list.add(familleFacturationTOFamilleFacturationDTO(familleFacturation));
        }

        return list;
    }
}
