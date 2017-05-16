/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.dto;

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
public class SousFamillePrestationDTO {

    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String designationAr;
    private FamillePrestationDTO codeFamille;
    @NotNull
    private boolean actif;
    private String userCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    public SousFamillePrestationDTO() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public FamillePrestationDTO getCodeFamille() {
        return codeFamille;
    }

    public void setCodeFamille(FamillePrestationDTO codeFamille) {
        this.codeFamille = codeFamille;
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

    public String getDesignationAr() {
        return designationAr;
    }

    public void setDesignationAr(String designationAr) {
        this.designationAr = designationAr;
    }
    
}
