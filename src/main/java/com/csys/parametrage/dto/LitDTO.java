/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.dto;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
public class LitDTO {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String numLit;
    @Basic(optional = false)
    @NotNull
    private int numChambre;
    @Basic(optional = false)
    @NotNull
    private BigDecimal coefficient;
    @NotNull
    private boolean actif;
    private String userCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    private EtatChambreDTO etatLit;

    public LitDTO() {
    }

    public String getNumLit() {
        return numLit;
    }

    public void setNumLit(String numLit) {
        this.numLit = numLit;
    }

    public int getNumChambre() {
        return numChambre;
    }

    public void setNumChambre(int numChambre) {
        this.numChambre = numChambre;
    }

    public BigDecimal getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public EtatChambreDTO getEtatLit() {
        return etatLit;
    }

    public void setEtatLit(EtatChambreDTO etatLit) {
        this.etatLit = etatLit;
    }
}
