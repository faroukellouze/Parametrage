/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.factory;

import com.csys.parametrage.domain.TypePieceJointeBordereau;
import com.csys.parametrage.dto.TypePieceJointeBordereauDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class TypePieceJointeBordereauFactory {

    public static TypePieceJointeBordereau typePieceJointeBordereauDTOToTypePieceJointeBordereau(TypePieceJointeBordereauDTO typePieceJointeBordDTO) {
        TypePieceJointeBordereau typePieceJointeBord = new TypePieceJointeBordereau();
        typePieceJointeBord.setCode(typePieceJointeBordDTO.getCode());
        typePieceJointeBord.setDesignation(typePieceJointeBordDTO.getDesignation());
        typePieceJointeBord.setActif(typePieceJointeBordDTO.isActif());
        return typePieceJointeBord;
    }

    public static TypePieceJointeBordereauDTO typePieceJointeBordereauToTypePieceJointeBordereauDTO(TypePieceJointeBordereau typePieceJointeBord) {
        TypePieceJointeBordereauDTO typePieceJointeBordDTO = new TypePieceJointeBordereauDTO();
        typePieceJointeBordDTO.setCode(typePieceJointeBord.getCode());
        typePieceJointeBordDTO.setDesignation(typePieceJointeBord.getDesignation());
        typePieceJointeBordDTO.setActif(typePieceJointeBord.isActif());
        return typePieceJointeBordDTO;
    }

    public static List<TypePieceJointeBordereauDTO> listTypePieceJointeBordereauToListTypePieceJointeBordereauDTO(List<TypePieceJointeBordereau> listTypePieceJointeBord) {
        List<TypePieceJointeBordereauDTO> listTypePieceJointeBordDTO = new ArrayList<>();
        for (TypePieceJointeBordereau type : listTypePieceJointeBord) {
            listTypePieceJointeBordDTO.add(typePieceJointeBordereauToTypePieceJointeBordereauDTO(type));
        }
        return listTypePieceJointeBordDTO;
    }

}
