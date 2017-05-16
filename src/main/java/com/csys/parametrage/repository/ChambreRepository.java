package com.csys.parametrage.repository;

import com.csys.parametrage.domain.Chambre;
import java.util.Collection;

import org.springframework.data.jpa.repository.*;
import java.util.List;

/**
 * Spring Data JPA repository for the Chambre entity.
 */
@SuppressWarnings("unused")
public interface ChambreRepository extends JpaRepository<Chambre, Integer> ,CustomChambreRepository{

    List<Chambre> findByCodeServiceCode(Integer codeService);
    
    Chambre findByNumeroChambre(String numeroChambre);

    List<Chambre> findByEtatChambreCode(Integer etatChambre);

    List<Chambre> findByCodeEtageCode(Integer codeEtage);

    List<Chambre> findByCodeCathegorieCode(Integer codeCathegorie);
    
    List<Chambre> findByActifIn(Collection<Boolean> actif);

//    @EntityGraph(value = "Chambre.codeCathegorie", type = EntityGraphType.FETCH)
//    @QueryHint(name ="test",value="select c from chambre c")

//    @EntityGraph(value = "Chambre.code", type = EntityGraphType.FETCH)
//     @QueryHints(value = { @QueryHint(name = "name", value = "javax.persistence.fetchgraph")})
////             ,forCounting = false)
//    Chambre findByCode(Integer code);

}
