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
public class FamillePrestationDTO {

    private Integer code;
    @Size(max = 200)
    @NotNull
    private String designationAr;
    @Size(max = 200)
    private String designationEn;
    private String prefixe;
    private int suffixe;
    @NotNull
    private boolean actif;
    private String userCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    private TypePrestationDTO codeTypePrestation;

    public FamillePrestationDTO() {
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

    public String getPrefixe() {
        return prefixe;
    }

    public void setPrefixe(String prefixe) {
        this.prefixe = prefixe;
    }

    public int getSuffixe() {
        return suffixe;
    }

    public void setSuffixe(int suffixe) {
        this.suffixe = suffixe;
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

    public TypePrestationDTO getCodeTypePrestation() {
        return codeTypePrestation;
    }

    public void setCodeTypePrestation(TypePrestationDTO codeTypePrestation) {
        this.codeTypePrestation = codeTypePrestation;
    }

    public String getDesignationEn() {
        return designationEn;
    }

    public void setDesignationEn(String designationEn) {
        this.designationEn = designationEn;
    }

}
