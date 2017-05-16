package com.csys.parametrage.repository;

import com.csys.parametrage.domain.SecteurActivite;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.*;

/**
 * Spring Data JPA repository for the SecteurActivite entity.
 */
@SuppressWarnings("unused")
public interface SecteurActiviteRepository extends JpaRepository<SecteurActivite, Integer> {

    List<SecteurActivite> findByActifIn(Collection<Boolean> actif);
}
