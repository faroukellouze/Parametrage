package com.csys.parametrage.factory;

import com.csys.parametrage.domain.Prestation;
import com.csys.parametrage.dto.PrestationDTO;
import java.util.ArrayList;
import java.util.List;

public class PrestationFactory {

    public static Prestation prestationDTOTOPrestation(PrestationDTO prestationDto, Prestation prestation) {
        if (prestationDto == null) {
            return null;
        }
        prestation.setCode(prestationDto.getCode());
        prestation.setCodeSaisie(prestationDto.getCodeSaisie());
        prestation.setDesignationEn(prestationDto.getDesignationEn());
        prestation.setDesignationFr(prestationDto.getDesignationEn());
        prestation.setDesignationAr(prestationDto.getDesignationAr());
        prestation.setCodeBeneficiere(prestationDto.getCodeBeneficiere());
        prestation.setAutorisModifierPrix(prestationDto.isAutorisModifierPrix());
        prestation.setDemandeObligatoire(prestationDto.isDemandeObligatoire());
        prestation.setCompteRendu(prestationDto.isCompteRendu());
        prestation.setEtage(prestationDto.isEtage());
        prestation.setFacturation(prestationDto.isFacturation());
        prestation.setSousTraitance(prestationDto.isSousTraitance());
        prestation.setActif(prestationDto.isActif());
        prestation.setCodeFamilleFacturation(FamilleFacturationFactory.familleFacturationDTOTOFamilleFacturation(prestationDto.getCodeFamilleFacturation(), prestation.getCodeFamilleFacturation()));
        prestation.setCodeSousFamille(SousFamillePrestationFactory.sousFamillePrestationDTOTOSousFamillePrestation(prestationDto.getCodeSousFamille(), prestation.getCodeSousFamille()));
        prestation.setTva(TvaFactory.tvaDTOTOTva(prestationDto.getTva(), prestation.getTva()));
        prestation.setCodeTypePrestation(TypePrestationFactory.typePrestationDTOTOTypePrestation(prestationDto.getCodeTypePrestation(), prestation.getCodeTypePrestation()));
        return prestation;
    }

    public static PrestationDTO prestationTOPrestationDTO(Prestation prestation) {
        if (prestation == null) {
            return null;
        }

        PrestationDTO prestationDTO = new PrestationDTO();

        prestationDTO.setCode(prestation.getCode());
        prestationDTO.setCodeSaisie(prestation.getCodeSaisie());
        prestationDTO.setDesignationEn(prestation.getDesignationEn());
        prestationDTO.setDesignationAr(prestation.getDesignationAr());
        prestationDTO.setCodeBeneficiere(prestation.getCodeBeneficiere());
        prestationDTO.setAutorisModifierPrix(prestation.getAutorisModifierPrix());
        prestationDTO.setDemandeObligatoire(prestation.getDemandeObligatoire());
        prestationDTO.setCompteRendu(prestation.getCompteRendu());
        prestationDTO.setEtage(prestation.getEtage());
        prestationDTO.setFacturation(prestation.getFacturation());
        prestationDTO.setSousTraitance(prestation.getSousTraitance());
        prestationDTO.setUserCreate(prestation.getUserCreate());
        prestationDTO.setDateCreate(prestation.getDateCreate());
        prestationDTO.setActif(prestation.getActif());
        prestationDTO.setCodeFamilleFacturation(FamilleFacturationFactory.familleFacturationTOFamilleFacturationDTO(prestation.getCodeFamilleFacturation()));
        prestationDTO.setCodeSousFamille(SousFamillePrestationFactory.sousFamillePrestationTOSousFamillePrestationDTO(prestation.getCodeSousFamille()));
        prestationDTO.setTva(TvaFactory.tvaTOTvaDTO(prestation.getTva()));
        prestationDTO.setCodeTypePrestation(TypePrestationFactory.typePrestationTOTypePrestationDTO(prestation.getCodeTypePrestation()));

        return prestationDTO;
    }

    public static List<Prestation> listPrestationDTOTOlistPrestation(List<PrestationDTO> listPrestationDto) {
        if (listPrestationDto == null) {
            return null;
        }

        List<Prestation> list = new ArrayList<Prestation>();
        for (PrestationDTO prestationDTO : listPrestationDto) {
            Prestation prestation = new Prestation();
            list.add(prestationDTOTOPrestation(prestationDTO, prestation));
        }

        return list;
    }

    public static List<PrestationDTO> listPrestationTOlistPrestationDTO(List<Prestation> listPrestation) {
        if (listPrestation == null) {
            return null;
        }

        List<PrestationDTO> list = new ArrayList<PrestationDTO>();
        for (Prestation prestation : listPrestation) {
            list.add(prestationTOPrestationDTO(prestation));
        }

        return list;
    }
}
