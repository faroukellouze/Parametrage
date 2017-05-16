/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.repository;

import com.csys.parametrage.domain.DetailsPriceList;
import com.csys.parametrage.domain.DetailsPriceListPK;
import com.csys.parametrage.dto.PrixDTO;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 *
 * @author gh18
 */
@Repository("DetailsPriceListRepository")
public interface DetailsPriceListRepository extends JpaRepository<DetailsPriceList,DetailsPriceListPK>  {
    @Query("SELECT NEW com.csys.parametrage.dto.PrixDTO(a.prix, c.tauxCouverture,a.detailsPriceListPK.codeTypeIntervenant)" +
" FROM DetailsPriceList a INNER JOIN DetailsCouverture c ON a.detailsPriceListPK.codePrestation = c.detailsCouverturePK.codePrestation" +
" WHERE (a.detailsPriceListPK.codePrestation = :codePrestation) AND (c.detailsCouverturePK.codeListeCouverture = :codeListeCouverture) AND (a.detailsPriceListPK.codePriceList = :codePriceList) AND (a.detailsPriceListPK.codeNatureAdmission = :codeNatureAdmission)")
    List<PrixDTO> calculPrix(@Param("codePrestation") int codePrestation,@Param("codeListeCouverture") int codeListeCouverture,@Param("codePriceList") int codePriceList,@Param("codeNatureAdmission") String codeNatureAdmission);
}
