/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gh18
 */
@Entity
@Table(name = "Details_Couverture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailsCouverture.findAll", query = "SELECT d FROM DetailsCouverture d")})
public class DetailsCouverture implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailsCouverturePK detailsCouverturePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Taux_Couverture")
    private BigDecimal tauxCouverture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Is_Exception")
    private boolean isException;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Is_Exception_Famille")
    private boolean isExceptionFamille;

    public DetailsCouverture() {
    }

    public DetailsCouverture(DetailsCouverturePK detailsCouverturePK) {
        this.detailsCouverturePK = detailsCouverturePK;
    }

    public DetailsCouverture(DetailsCouverturePK detailsCouverturePK, BigDecimal tauxCouverture, boolean isException, boolean isExceptionFamille) {
        this.detailsCouverturePK = detailsCouverturePK;
        this.tauxCouverture = tauxCouverture;
        this.isException = isException;
        this.isExceptionFamille = isExceptionFamille;
    }

    public DetailsCouverture(int codeListeCouverture, int codePrestation) {
        this.detailsCouverturePK = new DetailsCouverturePK(codeListeCouverture, codePrestation);
    }

    public DetailsCouverturePK getDetailsCouverturePK() {
        return detailsCouverturePK;
    }

    public void setDetailsCouverturePK(DetailsCouverturePK detailsCouverturePK) {
        this.detailsCouverturePK = detailsCouverturePK;
    }

    public BigDecimal getTauxCouverture() {
        return tauxCouverture;
    }

    public void setTauxCouverture(BigDecimal tauxCouverture) {
        this.tauxCouverture = tauxCouverture;
    }

    public boolean getIsException() {
        return isException;
    }

    public void setIsException(boolean isException) {
        this.isException = isException;
    }

    public boolean getIsExceptionFamille() {
        return isExceptionFamille;
    }

    public void setIsExceptionFamille(boolean isExceptionFamille) {
        this.isExceptionFamille = isExceptionFamille;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailsCouverturePK != null ? detailsCouverturePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailsCouverture)) {
            return false;
        }
        DetailsCouverture other = (DetailsCouverture) object;
        if ((this.detailsCouverturePK == null && other.detailsCouverturePK != null) || (this.detailsCouverturePK != null && !this.detailsCouverturePK.equals(other.detailsCouverturePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.DetailsCouverture[ detailsCouverturePK=" + detailsCouverturePK + " ]";
    }
    
}
