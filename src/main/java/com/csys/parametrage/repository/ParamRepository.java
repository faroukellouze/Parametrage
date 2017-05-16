package com.csys.parametrage.repository;

import com.csys.parametrage.domain.Param;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Param entity.
 */
@SuppressWarnings("unused")
public interface ParamRepository extends JpaRepository<Param,String> {

}
