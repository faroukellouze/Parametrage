package com.csys.parametrage.repository;

import com.csys.parametrage.domain.Prestation;
import com.csys.parametrage.projection.PrestationCodeDes;
import java.util.Collection;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Prestation entity.
 */
@SuppressWarnings("unused")
public interface PrestationRepository extends JpaRepository<Prestation,Integer> {

     List<Prestation> findByActifIn( Collection<Boolean> actif);
     
     List<Prestation> findByCodeSousFamilleCode( Integer code);
     
     List<PrestationCodeDes> findByActifInAndCodeTypePrestationCodeIn( Collection<Boolean> actif,List<Integer> typePrestation);
     
     Prestation findByCodeSaisie( String codeSaisie);
}
