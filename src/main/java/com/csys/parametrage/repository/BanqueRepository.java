package com.csys.parametrage.repository;

import com.csys.parametrage.domain.Banque;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Banque entity.
 */
@Repository("BanqueRepository")
public interface BanqueRepository extends JpaRepository<Banque, Integer> {

    public Banque findByCode(Integer code);
    
    List<Banque> findByActifIn(Collection<Boolean> actif);

}
