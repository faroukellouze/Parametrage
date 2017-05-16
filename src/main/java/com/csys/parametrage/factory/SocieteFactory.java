/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.factory;

import com.csys.parametrage.domain.Societe;
import com.csys.parametrage.dto.SocieteDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class SocieteFactory {

    public static Societe societeDTOToSociete(SocieteDTO societeDTO, Societe societe) {
        if (societeDTO == null) {
            return null;
        }
        societe.setActif(societeDTO.isActif());
        societe.setCodeBanque(BanqueFactory.banqueDTOToBanque(societeDTO.getCodeBanque()));
        societe.setCodeModeReglement(ModeReglementFactory.modeReglementDTOToModeReglement(societeDTO.getCodeModeReglement()));
        societe.setCodeSaisie(societeDTO.getCodeSaisie());
        societe.setCodeSecteurActivite(SecteurActiviteFactory.secteurActiviteDTOToSecteurActivite(societeDTO.getCodeSecteurActivite()));
        societe.setDelaisFacturation(societeDTO.getDelaisFacturation());
        societe.setDelaisReglement(societeDTO.getDelaisReglement());
        societe.setDesignation(societeDTO.getDesignation());
        societe.setNiveauBordereau(societeDTO.getNiveauBordereau());
        societe.setRib(societeDTO.getRib());
        societe.setSeuilCredit(societeDTO.getSeuilCredit());
        societe.setSeuilCreditAlerte(societeDTO.getSeuilCreditAlerte());
        societe.setTimbre(societeDTO.isTimbre());
        societe.setCalculDifferencePrix(societeDTO.getCalculDifferencePrix());
        societe.setObservation(societeDTO.getObservation());
        
        return societe;

    }

    public static SocieteDTO societeToSocieteDTO(Societe societe) {
        SocieteDTO societeDTO = new SocieteDTO();
        societeDTO.setActif(societe.getActif());
        societeDTO.setCode(societe.getCode());
        societeDTO.setCodeBanque(BanqueFactory.banqueToBanqueDTO(societe.getCodeBanque()));
        societeDTO.setCodeModeReglement(ModeReglementFactory.modeReglementToModeReglementDTO(societe.getCodeModeReglement()));
        societeDTO.setCodeSaisie(societe.getCodeSaisie());
        societeDTO.setCodeSecteurActivite(SecteurActiviteFactory.secteurActiviteToSecteurActiviteDTO(societe.getCodeSecteurActivite()));
        societeDTO.setContactSocieteCollection(ContactSocieteFactory.listContactSocieteToListContactSocieteDTO(societe.getContactSocieteCollection()));
        societeDTO.setDateCreation(societe.getDateCreation());
        societeDTO.setDelaisFacturation(societe.getDelaisFacturation());
        societeDTO.setDelaisReglement(societe.getDelaisReglement());
        societeDTO.setDesignation(societe.getDesignation());
        societeDTO.setNiveauBordereau(societe.getNiveauBordereau());
        societeDTO.setPieceJointeBordereauSocieteCollection(PieceJointeBordereauSocieteFactory.listPieceJointeBordereauSocieteToListPieceJointeBordereauSocieteDTO(societe.getPieceJointeBordereauSocieteCollection()));
        societeDTO.setResponsableSocieteCollection(ResponsableSocieteFactory.listResponsableSocieteToListResponsableSocieteDTO(societe.getResponsableSocieteCollection()));
        societeDTO.setRib(societe.getRib());
        societeDTO.setSeuilCredit(societe.getSeuilCredit());
        societeDTO.setSeuilCreditAlerte(societe.getSeuilCreditAlerte());
        societeDTO.setTimbre(societe.getTimbre());
        societeDTO.setUserCreation(societe.getUserCreation());
        societeDTO.setCalculDifferencePrix(societe.getCalculDifferencePrix());
        societeDTO.setObservation(societe.getObservation());
        return societeDTO;
    }

    public static List<SocieteDTO> listSocieteTolistSocieteDTO(List<Societe> listSociete) {
        List<SocieteDTO> listSocieteDTO = new ArrayList<>();
        for (Societe societe : listSociete) {
            listSocieteDTO.add(societeToSocieteDTO(societe));
        }
        return listSocieteDTO;
    }

}
