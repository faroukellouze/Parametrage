package com.csys.parametrage.repository;

import com.csys.parametrage.domain.Cathegorie;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.*;

/**
 * Spring Data JPA repository for the Cathegorie entity.
 */
@SuppressWarnings("unused")
public interface CathegorieRepository extends JpaRepository<Cathegorie,Integer> {

     List<Cathegorie> findByActifIn(Collection<Boolean> actif);
}
