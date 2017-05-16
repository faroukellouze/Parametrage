/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "Famille_Prestation")
@NamedQueries({
    @NamedQuery(name = "FamillePrestation.findAll", query = "SELECT f FROM FamillePrestation f")})
public class FamillePrestation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Size(max = 200)
    @Column(name = "Designation_En")
    private String designationEn;
    @Size(max = 200)
    @Column(name = "Designation_Fr")
    @JsonIgnore
    private String designationFr;
    @Size(max = 200)
    @Column(name = "Designation_Ar")
    private String designationAr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeFamille")
    private Collection<SousFamillePrestation> sousFamillePrestationCollection;
    @Basic(optional = false)
    @NotNull
    @Size( max = 10)
    @Column(name = "Prefixe")
    private String prefixe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Suffixe")
    private int suffixe;
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
    @JoinColumn(name = "Code_Type_Prestation", referencedColumnName = "Code")
    @ManyToOne(optional = false)
    private TypePrestation codeTypePrestation;

    public FamillePrestation() {
    }

    public FamillePrestation(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    public Collection<SousFamillePrestation> getSousFamillePrestationCollection() {
        return sousFamillePrestationCollection;
    }

    public void setSousFamillePrestationCollection(Collection<SousFamillePrestation> sousFamillePrestationCollection) {
        this.sousFamillePrestationCollection = sousFamillePrestationCollection;
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

    public TypePrestation getCodeTypePrestation() {
        return codeTypePrestation;
    }

    public void setCodeTypePrestation(TypePrestation codeTypePrestation) {
        this.codeTypePrestation = codeTypePrestation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof FamillePrestation)) {
            return false;
        }
        FamillePrestation other = (FamillePrestation) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.FamillePrestation[ code=" + code + " ]";
    }
    
}
