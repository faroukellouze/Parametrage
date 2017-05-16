/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Lit")
@NamedQueries({
    @NamedQuery(name = "Lit.findAll", query = "SELECT l FROM Lit l")})
public class Lit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NumLit")
    private String numLit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Coefficient")
    private BigDecimal coefficient;
    @JoinColumn(name = "numChambre", referencedColumnName = "Code")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Chambre numChambre;
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
    @JoinColumn(name = "EtatLit", referencedColumnName = "Code")
    @ManyToOne
    private EtatChambre etatLit;

    public Lit() {
    }

    public String getNumLit() {
        return numLit;
    }

    public void setNumLit(String numLit) {
        this.numLit = numLit;
    }

    public Chambre getNumChambre() {
        return numChambre;
    }

    public void setNumChambre(Chambre numChambre) {
        this.numChambre = numChambre;
    }

    public BigDecimal getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
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

    public EtatChambre getEtatLit() {
        return etatLit;
    }

    public void setEtatLit(EtatChambre etatLit) {
        this.etatLit = etatLit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numLit != null ? numLit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lit)) {
            return false;
        }
        Lit other = (Lit) object;
        if ((this.numLit == null && other.numLit != null) || (this.numLit != null && !this.numLit.equals(other.numLit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.Lit[ numLit=" + numLit + " ]";
    }

}
