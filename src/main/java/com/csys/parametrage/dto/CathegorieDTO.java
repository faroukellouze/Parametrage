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

public class CathegorieDTO {

    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String designationAr;
    @Size(max = 200)
    private String designation;
    private PrestationDTO prestSejour;
    private PrestationDTO prestAccompagnat;
    private PrestationDTO prestSuivie;
    private PrestationDTO prestSurveillance;
    @Basic(optional = false)
    @NotNull
    private boolean isIcu;
    @NotNull
    private boolean actif;
    private String userCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    

    public CathegorieDTO() {
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

    public PrestationDTO getPrestSejour() {
        return prestSejour;
    }

    public void setPrestSejour(PrestationDTO prestSejour) {
        this.prestSejour = prestSejour;
    }

    public PrestationDTO getPrestAccompagnat() {
        return prestAccompagnat;
    }

    public void setPrestAccompagnat(PrestationDTO prestAccompagnat) {
        this.prestAccompagnat = prestAccompagnat;
    }

    public PrestationDTO getPrestSuivie() {
        return prestSuivie;
    }

    public void setPrestSuivie(PrestationDTO prestSuivie) {
        this.prestSuivie = prestSuivie;
    }

    public PrestationDTO getPrestSurveillance() {
        return prestSurveillance;
    }

    public void setPrestSurveillance(PrestationDTO prestSurveillance) {
        this.prestSurveillance = prestSurveillance;
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

    public boolean isIsIcu() {
        return isIcu;
    }

    public void setIsIcu(boolean isIcu) {
        this.isIcu = isIcu;
    }

}
