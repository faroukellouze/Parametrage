package com.csys.parametrage.repository;

import com.csys.parametrage.domain.FonctionResponsableSociete;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the FonctionResponsableSociete entity.
 */
@SuppressWarnings("unused")
public interface FonctionResponsableSocieteRepository extends JpaRepository<FonctionResponsableSociete,Integer> {

    List<FonctionResponsableSociete> findByActifIn(Collection<Boolean> actif);
    
}
