package com.csys.parametrage.repository;

import com.csys.parametrage.domain.Societe;
import java.util.Collection;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Societe entity.
 */
@SuppressWarnings("unused")
public interface SocieteRepository extends JpaRepository<Societe,Integer> {
    
   List<Societe> findByActifIn( Collection<Boolean> actif);
   
   List<Societe> findByCodeBanqueCode( int codeBanque);
   
   Societe findByCodeSaisie(String codeSaisie);
   
   List<Societe> findByCodeSecteurActiviteCode( int codeSecteurActivite);
   
   List<Societe> findByCodeModeReglementCode( int codeModeReglement);

}
