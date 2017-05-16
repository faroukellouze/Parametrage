package com.csys.parametrage.repository;

import com.csys.parametrage.domain.TypePrestation;
import java.util.Collection;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the TypePrestation entity.
 */
@SuppressWarnings("unused")
public interface TypePrestationRepository extends JpaRepository<TypePrestation,Integer> {
    
    List<TypePrestation> findByActifIn( Collection<Boolean> actif);

}
