/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.service;

import com.csys.parametrage.domain.TypePieceJointeBordereau;
import com.csys.parametrage.dto.PieceJointeBordereauSocieteDTO;
import com.csys.parametrage.dto.TypePieceJointeBordereauDTO;
import com.csys.parametrage.factory.PieceJointeBordereauSocieteFactory;
import com.csys.parametrage.factory.TypePieceJointeBordereauFactory;
import com.csys.parametrage.repository.PieceJointeBordereauSocieteRepository;
import com.csys.parametrage.repository.TypePieceJointeBordereauRepository;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrateur
 */
@Service("PieceJointBordereauService")
@Transactional
public class PieceJointBordereauService {
     private final Logger log = LoggerFactory.getLogger(PieceJointBordereauService.class);
    
    private final PieceJointeBordereauSocieteRepository pieceJointeBordereauSocieteRepository;

    public PieceJointBordereauService(PieceJointeBordereauSocieteRepository pieceJointeBordereauSocieteRepository) {
        this.pieceJointeBordereauSocieteRepository = pieceJointeBordereauSocieteRepository;
    }

    @Transactional(readOnly = true)
    public Collection<PieceJointeBordereauSocieteDTO> findByPieceJointeBordereauSocietePK_CodeTypePieceJointe(Integer id) {
        return PieceJointeBordereauSocieteFactory.listPieceJointeBordereauSocieteToListPieceJointeBordereauSocieteDTO(pieceJointeBordereauSocieteRepository.findByPieceJointeBordereauSocietePK_CodeTypePieceJointe(id));
    }
 
}
