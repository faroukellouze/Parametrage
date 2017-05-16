package com.csys.parametrage.repository;

import com.csys.parametrage.domain.ModeReglement;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.*;

/**
 * Spring Data JPA repository for the ModeReglement entity.
 */
@SuppressWarnings("unused")
public interface ModeReglementRepository extends JpaRepository<ModeReglement, Integer> {

    List<ModeReglement> findByActifIn(Collection<Boolean> actif);
}
