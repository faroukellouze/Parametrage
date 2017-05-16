package com.csys.parametrage.repository;

import com.csys.parametrage.domain.FamilleFacturation;
import java.util.Collection;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the FamilleFacturation entity.
 */
@SuppressWarnings("unused")
public interface FamilleFacturationRepository extends JpaRepository<FamilleFacturation,Integer> {

    
    List<FamilleFacturation> findByActifIn( Collection<Boolean> actif);
}
