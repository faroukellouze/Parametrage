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

public class EtatChambreDTO {

    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String designationAr;
    @Size(max = 200)
    private String designation;
     @NotNull
    private boolean actif;
    private String userCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Basic(optional = false)
    @NotNull
    private String couleur;
    @Basic(optional = false)
    @NotNull
    private boolean etat;

    public EtatChambreDTO() {
    }
    
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesignationAr() {
        return designationAr;
    }

    public void setDesignationAr(String designationAr) {
        this.designationAr = designationAr;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String coleur) {
        this.couleur = coleur;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
}
