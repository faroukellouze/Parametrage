/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.factory;

import com.csys.parametrage.domain.PieceJointeBordereauSociete;
import com.csys.parametrage.domain.PieceJointeBordereauSocietePK;
import com.csys.parametrage.domain.Societe;
import com.csys.parametrage.dto.PieceJointeBordereauSocieteDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class PieceJointeBordereauSocieteFactory {

    public static Collection<PieceJointeBordereauSociete> listPieceJointeBordereauSocieteDTOToListPieceJointeBordereauSociete(Collection<PieceJointeBordereauSocieteDTO> listPieceJointDTO, Societe societe) {
        List<PieceJointeBordereauSociete> listPieceJoint = new ArrayList<>();
        for (PieceJointeBordereauSocieteDTO pieceJointDTO : listPieceJointDTO) {
            PieceJointeBordereauSociete pieceJoint = new PieceJointeBordereauSociete();
            PieceJointeBordereauSocietePK pieceJointPK = new PieceJointeBordereauSocietePK();
//            pieceJointPK.setCodeSociete(societe.getCode());
            pieceJointPK.setCodeTypePieceJointe(pieceJointDTO.getCodeTypePieceJointe().getCode());
            pieceJoint.setPieceJointeBordereauSocietePK(pieceJointPK);
            pieceJoint.setNombre(pieceJointDTO.getNombre());
            pieceJoint.setSociete(societe);
            listPieceJoint.add(pieceJoint);
        }
        return listPieceJoint;
    }
    
        public static Collection<PieceJointeBordereauSociete> listPieceJointeBordereauSocieteDTOToListPieceJointeBordereauSocieteUpdate(Collection<PieceJointeBordereauSocieteDTO> listPieceJointDTO, Societe societe) {
        List<PieceJointeBordereauSociete> listPieceJoint = new ArrayList<>();
        for (PieceJointeBordereauSocieteDTO pieceJointDTO : listPieceJointDTO) {
            PieceJointeBordereauSociete pieceJoint = new PieceJointeBordereauSociete();
            PieceJointeBordereauSocietePK pieceJointPK = new PieceJointeBordereauSocietePK();
            pieceJointPK.setCodeSociete(societe.getCode());
            pieceJointPK.setCodeTypePieceJointe(pieceJointDTO.getCodeTypePieceJointe().getCode());
            pieceJoint.setPieceJointeBordereauSocietePK(pieceJointPK);
            pieceJoint.setNombre(pieceJointDTO.getNombre());
            pieceJoint.setSociete(societe);
            listPieceJoint.add(pieceJoint);
        }
        return listPieceJoint;
    }

    public static Collection<PieceJointeBordereauSocieteDTO> listPieceJointeBordereauSocieteToListPieceJointeBordereauSocieteDTO(Collection<PieceJointeBordereauSociete> listPieceJoint) {
        List<PieceJointeBordereauSocieteDTO> listPieceJointDTO = new ArrayList<>();
        for (PieceJointeBordereauSociete pieceJoint : listPieceJoint) {
            PieceJointeBordereauSocieteDTO pieceJointDTO = new PieceJointeBordereauSocieteDTO();
            pieceJointDTO.setCodeSociete(pieceJoint.getPieceJointeBordereauSocietePK().getCodeSociete());
            pieceJointDTO.setCodeTypePieceJointe(TypePieceJointeBordereauFactory.typePieceJointeBordereauToTypePieceJointeBordereauDTO(pieceJoint.getTypePieceJointeBordereau()));
            pieceJointDTO.setNombre(pieceJoint.getNombre());
            listPieceJointDTO.add(pieceJointDTO);
        }
        return listPieceJointDTO;
    }

}
