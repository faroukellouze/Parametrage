/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.dto;

import java.math.BigDecimal;

/**
 *
 * @author gh18
 */
public class PrixDTO {
    private BigDecimal prix;
    private BigDecimal tauxCouverture;
    private String codeTypeIntervenant;

    public PrixDTO() {
    }

    public PrixDTO(BigDecimal prix, BigDecimal tauxCouverture, String codeTypeIntervenant) {
        this.prix = prix;
        this.tauxCouverture = tauxCouverture;
        this.codeTypeIntervenant = codeTypeIntervenant;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public BigDecimal getTauxCouverture() {
        return tauxCouverture;
    }

    public void setTauxCouverture(BigDecimal tauxCouverture) {
        this.tauxCouverture = tauxCouverture;
    }

    public String getCodeTypeIntervenant() {
        return codeTypeIntervenant;
    }

    public void setCodeTypeIntervenant(String codeTypeIntervenant) {
        this.codeTypeIntervenant = codeTypeIntervenant;
    }
    
    
}
