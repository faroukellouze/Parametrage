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
@Table(name = "Cathegorie")
@NamedQueries({
    @NamedQuery(name = "Cathegorie.findAll", query = "SELECT c FROM Cathegorie c")})
public class Cathegorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Designation_Ar")
    private String designationAr;
    @Size(max = 200)
    @Column(name = "Designation")
    private String designation;
    @JoinColumn(name = "PrestSejour", referencedColumnName = "Code", nullable = true)
    @ManyToOne(optional = true)
    private Prestation prestSejour;
    @JoinColumn(name = "PrestAccompagnat", referencedColumnName = "Code", nullable = true)
    @ManyToOne(optional = true)
    private Prestation prestAccompagnat;
    @JoinColumn(name = "PrestSuivie", referencedColumnName = "Code", nullable = true)
    @ManyToOne(optional = true)
    private Prestation prestSuivie;
    @JoinColumn(name = "PrestSurveillance", referencedColumnName = "Code", nullable = true)
    @ManyToOne(optional = true)
    private Prestation prestSurveillance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_ICU")
    private boolean isIcu;
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

    public Cathegorie() {
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

    public Prestation getPrestSejour() {
        return prestSejour;
    }

    public void setPrestSejour(Prestation prestSejour) {
        this.prestSejour = prestSejour;
    }

    public Prestation getPrestAccompagnat() {
        return prestAccompagnat;
    }

    public void setPrestAccompagnat(Prestation prestAccompagnat) {
        this.prestAccompagnat = prestAccompagnat;
    }

    public Prestation getPrestSuivie() {
        return prestSuivie;
    }

    public void setPrestSuivie(Prestation prestSuivie) {
        this.prestSuivie = prestSuivie;
    }

    public Prestation getPrestSurveillance() {
        return prestSurveillance;
    }

    public void setPrestSurveillance(Prestation prestSurveillance) {
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cathegorie)) {
            return false;
        }
        Cathegorie other = (Cathegorie) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.Cathegorie[ code=" + code + " ]";
    }

}
