package com.csys.parametrage.repository;

import com.csys.parametrage.domain.Etage;
import java.util.Collection;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Etage entity.
 */
@SuppressWarnings("unused")
public interface EtageRepository extends JpaRepository<Etage,Integer> {
    
    List<Etage> findByActifIn( Collection<Boolean> actif);

}
