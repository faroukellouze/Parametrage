/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.factory;

import com.csys.parametrage.domain.ModeReglement;
import com.csys.parametrage.dto.ModeReglementDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class ModeReglementFactory {

    public static ModeReglement modeReglementDTOToModeReglement(ModeReglementDTO modeRegDTO) {
        if (modeRegDTO != null) {
            ModeReglement modeReg = new ModeReglement();
            modeReg.setCode(modeRegDTO.getCode());
            modeReg.setDesignation(modeRegDTO.getDesignation());
            modeReg.setActif(modeRegDTO.isActif());
            return modeReg;
        } else {
            return null;
        }
    }

    public static ModeReglementDTO modeReglementToModeReglementDTO(ModeReglement modeReg) {
        if (modeReg != null) {
            ModeReglementDTO modeRegDTO = new ModeReglementDTO();
            modeRegDTO.setCode(modeReg.getCode());
            modeRegDTO.setDesignation(modeReg.getDesignation());
            modeRegDTO.setActif(modeReg.isActif());
            return modeRegDTO;
        } else {
            return null;
        }
    }

    public static List<ModeReglementDTO> listModeReglementToListModeReglementDTO(List<ModeReglement> listModeReg) {
        List<ModeReglementDTO> listModRegDTO = new ArrayList<>();
        for (ModeReglement modReg : listModeReg) {
            listModRegDTO.add(modeReglementToModeReglementDTO(modReg));
        }
        return listModRegDTO;
    }

}
