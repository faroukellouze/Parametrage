/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.repository;

import com.csys.parametrage.domain.Chambre;

/**
 *
 * @author Administrateur
 */
public interface CustomChambreRepository {
       public Chambre findByCode(int code);
}
