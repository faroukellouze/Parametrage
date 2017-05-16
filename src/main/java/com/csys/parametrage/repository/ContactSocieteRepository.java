package com.csys.parametrage.repository;

import com.csys.parametrage.domain.ContactSociete;
import com.csys.parametrage.domain.ContactSocietePK;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the ContactSociete entity.
 */
@SuppressWarnings("unused")
public interface ContactSocieteRepository extends JpaRepository<ContactSociete,ContactSocietePK> {

}
