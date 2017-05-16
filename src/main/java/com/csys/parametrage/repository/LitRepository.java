package com.csys.parametrage.repository;

import com.csys.parametrage.domain.Lit;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Lit entity.
 */
@SuppressWarnings("unused")
public interface LitRepository extends JpaRepository<Lit,String> {

}
