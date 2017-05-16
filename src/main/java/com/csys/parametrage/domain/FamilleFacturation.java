/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "Famille_Facturation")
@NamedQueries({
    @NamedQuery(name = "FamilleFacturation.findAll", query = "SELECT f FROM FamilleFacturation f")})
public class FamilleFacturation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Code_Famille_Saisie")
    private String codeFamilleSaisie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @JsonIgnore
    @Column(name = "Designation_En")
    private String designationEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @JsonIgnore
    @Column(name = "Designation_Fr")
    private String designationFr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Designation_Ar")
    private String designationAr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Memo")
    private String memo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ordre")
    private int ordre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Actif")
    private boolean actif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "UserCreation")
    private String userCreation;
    @Column(name = "DateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    
    public FamilleFacturation() {
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

    public String getDesignationEn() {
        return designationEn;
    }

    public void setDesignationEn(String designationEn) {
        this.designationEn = designationEn;
    }

    public String getDesignationFr() {
        return designationFr;
    }

    public void setDesignationFr(String designationFr) {
        this.designationFr = designationFr;
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

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof FamilleFacturation)) {
            return false;
        }
        FamilleFacturation other = (FamilleFacturation) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.FamilleFacturation[ code=" + code + " ]";
    }
    
}
