package com.csys.parametrage.repository;

import com.csys.parametrage.domain.Service;
import java.util.Collection;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Service entity.
 */
@SuppressWarnings("unused")
public interface ServiceRepository extends JpaRepository<Service,Integer> {
    
    List<Service> findByActifIn( Collection<Boolean> actif);

}
