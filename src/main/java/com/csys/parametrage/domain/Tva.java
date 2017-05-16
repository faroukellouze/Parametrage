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
@Table(name = "TVA")
@NamedQueries({
    @NamedQuery(name = "Tva.findAll", query = "SELECT t FROM Tva t")})
public class Tva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "TVA")
    private String tva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Num_Compte_Comptable")
    private String numCompteComptable;
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

    public Tva() {
    }

    public Tva(String tva) {
        this.tva = tva;
    }

    public Tva(String tva, String numCompteComptable) {
        this.tva = tva;
        this.numCompteComptable = numCompteComptable;
    }

    public String getTva() {
        return tva;
    }

    public void setTva(String tva) {
        this.tva = tva;
    }

    public String getNumCompteComptable() {
        return numCompteComptable;
    }

    public void setNumCompteComptable(String numCompteComptable) {
        this.numCompteComptable = numCompteComptable;
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
        hash += (tva != null ? tva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Tva)) {
            return false;
        }
        Tva other = (Tva) object;
        if ((this.tva == null && other.tva != null) || (this.tva != null && !this.tva.equals(other.tva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.Tva[ tva=" + tva + " ]";
    }

}
