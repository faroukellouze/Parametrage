package com.csys.parametrage.repository;

import com.csys.parametrage.domain.EtatChambre;
import java.util.Collection;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the EtatChambre entity.
 */
@SuppressWarnings("unused")
public interface EtatChambreRepository extends JpaRepository<EtatChambre,Integer> {

    List<EtatChambre> findByActifIn( Collection<Boolean> actif);
    
    List<EtatChambre> findByActifAndEtat(Boolean actif,Boolean etat);
    
}
