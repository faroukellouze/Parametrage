package com.csys.parametrage.factory;

import com.csys.parametrage.domain.TypePrestation;
import com.csys.parametrage.dto.TypePrestationDTO;
import java.util.ArrayList;
import java.util.List;

public class TypePrestationFactory {

    public static TypePrestation typePrestationDTOTOTypePrestation(TypePrestationDTO typePrestationDto, TypePrestation typePrestation) {
        if (typePrestationDto == null) {
            return null;
        }
        typePrestation.setCode(typePrestationDto.getCode());
        typePrestation.setDesignation(typePrestationDto.getDesignation());
        typePrestation.setActif(typePrestationDto.isActif());
        return typePrestation;
    }

    public static TypePrestationDTO typePrestationTOTypePrestationDTO(TypePrestation typePrestation) {
        if (typePrestation == null) {
            return null;
        }

        TypePrestationDTO typePrestationDTO = new TypePrestationDTO();

        typePrestationDTO.setCode(typePrestation.getCode());
        typePrestationDTO.setDesignation(typePrestation.getDesignation());
        typePrestationDTO.setActif(typePrestation.isActif());
        return typePrestationDTO;
    }

    public static List<TypePrestation> listTypePrestationDTOTOlistTypePrestation(List<TypePrestationDTO> listTypePrestationDto) {
        if (listTypePrestationDto == null) {
            return null;
        }

        List<TypePrestation> list = new ArrayList<TypePrestation>();
        for (TypePrestationDTO typePrestationDTO : listTypePrestationDto) {
            TypePrestation typePrestation = new TypePrestation();
            list.add(typePrestationDTOTOTypePrestation(typePrestationDTO, typePrestation));
        }

        return list;
    }

    public static List<TypePrestationDTO> listTypePrestationTOlistTypePrestationDTO(List<TypePrestation> listTypePrestation) {
        if (listTypePrestation == null) {
            return null;
        }

        List<TypePrestationDTO> list = new ArrayList<TypePrestationDTO>();
        for (TypePrestation typePrestation : listTypePrestation) {
            list.add(typePrestationTOTypePrestationDTO(typePrestation));
        }

        return list;
    }
}
