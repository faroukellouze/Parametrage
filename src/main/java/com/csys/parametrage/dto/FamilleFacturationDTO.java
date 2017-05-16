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
public class FamilleFacturationDTO {

    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String codeFamilleSaisie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String designationAr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String memo;
    @Basic(optional = false)
    @NotNull
    private int ordre;
    @NotNull
    private boolean actif;
    private String userCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    public FamilleFacturationDTO() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeFamilleSaisie() {
        return codeFamilleSaisie;
    }

    public void setCodeFamilleSaisie(String codeFamilleSaisie) {
        this.codeFamilleSaisie = codeFamilleSaisie;
    }

    public String getDesignationAr() {
        return designationAr;
    }

    public void setDesignationAr(String designationAr) {
        this.designationAr = designationAr;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
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

}
