package com.csys.parametrage.repository;

import com.csys.parametrage.domain.FamillePrestation;
import java.util.Collection;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the FamillePrestation entity.
 */
@SuppressWarnings("unused")
public interface FamillePrestationRepository extends JpaRepository<FamillePrestation, Integer> {

    List<FamillePrestation> findByActifIn(Collection<Boolean> actif);
}
