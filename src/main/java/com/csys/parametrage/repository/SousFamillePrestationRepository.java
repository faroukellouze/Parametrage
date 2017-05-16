package com.csys.parametrage.repository;

import com.csys.parametrage.domain.SousFamillePrestation;
import java.util.Collection;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the SousFamillePrestation entity.
 */
@SuppressWarnings("unused")
public interface SousFamillePrestationRepository extends JpaRepository<SousFamillePrestation,Integer> {
    
    List<SousFamillePrestation> findByCodeFamilleCode(Integer codeFamille);
    
    List<SousFamillePrestation> findByCodeFamilleCodeTypePrestationCodeAndActifIn(Integer codeTypePrestation,Collection<Boolean> actif);
    
    List<SousFamillePrestation> findByActifIn( Collection<Boolean> actif);

}
