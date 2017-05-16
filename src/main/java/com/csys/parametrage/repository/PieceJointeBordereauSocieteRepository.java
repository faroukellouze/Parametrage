package com.csys.parametrage.repository;

import com.csys.parametrage.domain.PieceJointeBordereauSociete;
import com.csys.parametrage.domain.PieceJointeBordereauSocietePK;
import java.util.List;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the PieceJointeBordereauSociete entity.
 */
@SuppressWarnings("unused")
public interface PieceJointeBordereauSocieteRepository extends JpaRepository<PieceJointeBordereauSociete,PieceJointeBordereauSocietePK> {

    List<PieceJointeBordereauSociete> findByPieceJointeBordereauSocietePK_CodeTypePieceJointe(int codeTypePieceJointe) ;
    
    
}
