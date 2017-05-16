/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.factory;

import com.csys.parametrage.domain.Banque;
import com.csys.parametrage.dto.BanqueDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public final class BanqueFactory {

    public static Banque banqueDTOToBanque(BanqueDTO banqueDTO) {
        if (banqueDTO != null) {
            Banque banque = new Banque();
            banque.setCode(banqueDTO.getCode());
            banque.setDesignation(banqueDTO.getDesignation());
            banque.setActif(banqueDTO.isActif());
            return banque;
        } else {
            return null;
        }
    }

    public static BanqueDTO banqueToBanqueDTO(Banque banque) {
        
        if (banque != null) {
            BanqueDTO banqueDTO = new BanqueDTO();
            banqueDTO.setCode(banque.getCode());
            banqueDTO.setDesignation(banque.getDesignation());
            banqueDTO.setActif(banque.isActif());
            return banqueDTO;
        } else {
            return null;
        }
    }

    public static List<BanqueDTO> listBanqueTolistBanqueDTO(List<Banque> Listbanque) {
        List<BanqueDTO> listBanqueDTO = new ArrayList<>();
        for (Banque banque : Listbanque) {
            listBanqueDTO.add(banqueToBanqueDTO(banque));
        }
        return listBanqueDTO;
    }

}
