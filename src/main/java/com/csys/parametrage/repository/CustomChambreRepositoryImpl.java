/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.repository;

import com.csys.parametrage.domain.Chambre;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.EntityGraph;

/**
 *
 * @author Administrateur
 */
public class CustomChambreRepositoryImpl implements CustomChambreRepository {

    private EntityManager em;

    @Override
    public Chambre findByCode(int code) {

        EntityGraph graph = (EntityGraph) em.getEntityGraph("Chambre.code");
        Map hints = new HashMap();
        hints.put("javax.persistence.loadgraph", graph);
        return em.find(Chambre.class, code, hints);
    }

}
