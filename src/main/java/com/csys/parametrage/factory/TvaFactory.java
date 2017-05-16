package com.csys.parametrage.factory;

import com.csys.parametrage.domain.Tva;
import com.csys.parametrage.dto.TvaDTO;
import java.util.ArrayList;
import java.util.List;

public class TvaFactory {
    
    public static Tva tvaDTOTOTva(TvaDTO tvaDto, Tva tva) {
        if (tvaDto == null) {
            return null;
        }
        tva.setTva(tvaDto.getTva());
        tva.setNumCompteComptable(tvaDto.getNumCompteComptable());
        tva.setActif(tvaDto.isActif());
        return tva;
    }
    
    public static TvaDTO tvaTOTvaDTO(Tva tva) {
        if (tva == null) {
            return null;
        }
        
        TvaDTO tvaDTO = new TvaDTO();
        
        tvaDTO.setTva(tva.getTva());
        tvaDTO.setNumCompteComptable(tva.getNumCompteComptable());
        tvaDTO.setActif(tva.isActif());
        return tvaDTO;
    }
    
    public static List<Tva> listTvaDTOTOlistTva(List<TvaDTO> listTvaDto) {
        if (listTvaDto == null) {
            return null;
        }
        
        List<Tva> list = new ArrayList<Tva>();
        for (TvaDTO tvaDTO : listTvaDto) {
            Tva tva = new Tva();
            list.add(tvaDTOTOTva(tvaDTO, tva));
        }
        
        return list;
    }
    
    public static List<TvaDTO> listTvaTOlistTvaDTO(List<Tva> listTva) {
        if (listTva == null) {
            return null;
        }
        
        List<TvaDTO> list = new ArrayList<TvaDTO>();
        for (Tva tva : listTva) {
            list.add(tvaTOTvaDTO(tva));
        }
        
        return list;
    }
}
