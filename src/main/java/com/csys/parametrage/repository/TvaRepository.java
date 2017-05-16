package com.csys.parametrage.repository;

import com.csys.parametrage.domain.Tva;
import java.util.Collection;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Tva entity.
 */
@SuppressWarnings("unused")
public interface TvaRepository extends JpaRepository<Tva,String> {
    
    List<Tva> findByActifIn( Collection<Boolean> actif);

}
