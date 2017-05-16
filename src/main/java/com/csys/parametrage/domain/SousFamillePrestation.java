/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Sous_Famille_Prestation")
@NamedQueries({
    @NamedQuery(name = "SousFamillePrestation.findAll", query = "SELECT s FROM SousFamillePrestation s")})
public class SousFamillePrestation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(max = 200)
    @Column(name = "Designation_Ar")
     private String designationAr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Designation")
    private String designation;
    @Size(max = 20)
    @Column(name = "Num_Cost_Center")
    private String numCostCenter;
    @JoinColumn(name = "Code_Famille", referencedColumnName = "Code")
    @ManyToOne(optional = false)
    private FamillePrestation codeFamille;
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

    public SousFamillePrestation() {
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

    public String getNumCostCenter() {
        return numCostCenter;
    }

    public void setNumCostCenter(String numCostCenter) {
        this.numCostCenter = numCostCenter;
    }

    public FamillePrestation getCodeFamille() {
        return codeFamille;
    }

    public void setCodeFamille(FamillePrestation codeFamille) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SousFamillePrestation)) {
            return false;
        }
        SousFamillePrestation other = (SousFamillePrestation) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.SousFamillePrestation[ code=" + code + " ]";
    }
    
}
