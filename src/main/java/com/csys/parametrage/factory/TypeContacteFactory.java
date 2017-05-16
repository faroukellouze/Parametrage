/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.factory;

import com.csys.parametrage.domain.TypeContacte;
import com.csys.parametrage.dto.TypeContacteDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class TypeContacteFactory {

    public static TypeContacte typeContacteDTOToTypeContacte(TypeContacteDTO typeContacteDTO) {
        TypeContacte typeContacte = new TypeContacte();
        typeContacte.setCode(typeContacteDTO.getCode());
        typeContacte.setDesignation(typeContacteDTO.getDesignation());
        typeContacte.setActif(typeContacteDTO.isActif());
        return typeContacte;
    }

    public static TypeContacteDTO typeContacteToTypeContacteDTO(TypeContacte typeContacte) {
        TypeContacteDTO typeContacteDTO = new TypeContacteDTO();
        typeContacteDTO.setCode(typeContacte.getCode());
        typeContacteDTO.setDesignation(typeContacte.getDesignation());
        typeContacteDTO.setActif(typeContacte.isActif());
        return typeContacteDTO;
    }

    public static List<TypeContacteDTO> listTypeContacteToListTypeContacteDTO(List<TypeContacte> listTypeContacte) {
        List<TypeContacteDTO> listTypeContacteDTO = new ArrayList<>();
        for (TypeContacte typeContacte : listTypeContacte) {
            listTypeContacteDTO.add(typeContacteToTypeContacteDTO(typeContacte));
        }
        return listTypeContacteDTO;
    }

}
