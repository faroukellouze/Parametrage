/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.service;

import com.csys.parametrage.dto.PrixDTO;
import com.csys.parametrage.repository.DetailsPriceListRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gh18
 */
@Service("PrixService")
@Transactional
public class DetailsPriceListService {
    
    private final DetailsPriceListRepository detailsPriceListRepository;
    
    public DetailsPriceListService(DetailsPriceListRepository detailsPriceListRepository) {
        this.detailsPriceListRepository = detailsPriceListRepository;
    }
    
    public List<PrixDTO> calculPrix(int codePrestation,int codeListeCouverture,int codePriceList,String codeNatureAdmission){
        return detailsPriceListRepository.calculPrix(codePrestation, codeListeCouverture, codePriceList, codeNatureAdmission);
    }
}
