/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.repository;

import com.csys.parametrage.domain.ResponsableSociete;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Administrateur
 */
@SuppressWarnings("unused")
public interface ResponsableSocieteRepository extends JpaRepository<ResponsableSociete, Integer>{
    
    List<ResponsableSociete> findByCodeFonctionResponsableSocieteCode(int codeResponsable);
    
    List<ResponsableSociete> findByActifIn(List<Boolean> actif);
    
}
