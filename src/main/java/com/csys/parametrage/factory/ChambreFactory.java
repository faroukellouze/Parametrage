package com.csys.parametrage.factory;

import com.csys.parametrage.domain.Chambre;
import com.csys.parametrage.dto.ChambreDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ChambreFactory {
    
    public static Chambre chambreDTOTOChambre(ChambreDTO chambreDTO, Chambre chambre) {
        
        chambre.setCode(chambreDTO.getCode());
        chambre.setNumeroChambre(chambreDTO.getNumeroChambre());
        chambre.setAutorisAccompagant(chambreDTO.getAutorisAccompagant());
        chambre.setVirtuelle(chambreDTO.getVirtuelle());
        chambre.setActif(chambreDTO.isActif());
        chambre.setCodeCathegorie(CathegorieFactory.createCathegorieByCode(chambreDTO.getCodeCathegorie().getCode()));
        chambre.setCodeEtage(EtageFactory.createEtageByCode(chambreDTO.getCodeEtage().getCode()));
        chambre.setEtatChambre(EtatChambreFactory.createEtatChambreByCode(chambreDTO.getEtatChambre().getCode()));
        chambre.setCodeService(ServiceFactory.createServiceByCode(chambreDTO.getCodeService().getCode()));
        chambre.setNbrLit(chambreDTO.getNbrLit());
        return chambre;
    }
    
    public static ChambreDTO chambreTOChambreDTO(Chambre chambre) {
        if (chambre == null) {
            return null;
        }
        
        ChambreDTO chambreDTO = new ChambreDTO();
        
        chambreDTO.setCode(chambre.getCode());
        chambreDTO.setNumeroChambre(chambre.getNumeroChambre());
        chambreDTO.setAutorisAccompagant(chambre.getAutorisAccompagant());
        chambreDTO.setVirtuelle(chambre.getVirtuelle());
        chambreDTO.setActif(chambre.isActif());
        chambreDTO.setUserCreate(chambre.getUserCreate());
        chambreDTO.setDateCreate(chambre.getDateCreate());
        chambreDTO.setCodeCathegorie(CathegorieFactory.cathegorieTOCathegorieDTO(chambre.getCodeCathegorie()));
        chambreDTO.setCodeEtage(EtageFactory.etageTOEtageDTO(chambre.getCodeEtage()));
        chambreDTO.setEtatChambre(EtatChambreFactory.etatChambreTOEtatChambreDTO(chambre.getEtatChambre()));
        chambreDTO.setCodeService(ServiceFactory.serviceTOServiceDTO(chambre.getCodeService()));
        chambreDTO.setLitCollection(LitFactory.listLitTolistLitDTO(chambre.getLitCollection()));
        chambreDTO.setNbrLit(chambre.getNbrLit());
        return chambreDTO;
    }
    
    public static Collection<Chambre> chambreDTOCollectionToChambreCollection(Collection<ChambreDTO> chambreDTOCollection) {
        if (chambreDTOCollection == null) {
            return null;
        }
        
        Collection<Chambre> collection = new ArrayList<Chambre>();
        for (ChambreDTO chambreDTO : chambreDTOCollection) {
            Chambre chambre = new Chambre();
            collection.add(chambreDTOTOChambre(chambreDTO, chambre));
        }
        
        return collection;
    }
    
    public static Collection<ChambreDTO> chambreCollectionToChambreDTOCollection(Collection<Chambre> chambreCollection) {
        if (chambreCollection == null) {
            return null;
        }
        Collection<ChambreDTO> collection = new ArrayList<ChambreDTO>();
        for (Chambre chambre : chambreCollection) {
            collection.add(chambreTOChambreDTO(chambre));
        }
        return collection;
    }
    
    public static Chambre createChambre(ChambreDTO chambreDTO, String user) {
        if (chambreDTO == null) {
            return null;
        }
        Chambre chambre = new Chambre();
        chambreDTOTOChambre(chambreDTO, chambre);
        chambre.setUserCreate(user);
        chambre.setDateCreate(new Date());
        chambre.setLitCollection(LitFactory.createListLit(chambreDTO.getLitCollection(), chambre));
        chambre.setCode(null);
        return chambre;
    }
    
    public static Chambre createChambreByCode(Integer code) {
        Chambre chambre = new Chambre();
        chambre.setCode(code);
        return chambre;
    }
    
}
