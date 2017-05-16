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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gh18
 */
@Entity
@Table(name = "Details_Price_List")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailsPriceList.findAll", query = "SELECT d FROM DetailsPriceList d")})
public class DetailsPriceList implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailsPriceListPK detailsPriceListPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Code_Type_Intervenant_Remplacant")
    private String codeTypeIntervenantRemplacant;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Prix")
    private BigDecimal prix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Is_Exception")
    private boolean isException;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Is_Exception_Famille")
    private boolean isExceptionFamille;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Valeur")
    private BigDecimal valeur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Nature")
    private String nature;

    public DetailsPriceList() {
    }

    public DetailsPriceList(DetailsPriceListPK detailsPriceListPK) {
        this.detailsPriceListPK = detailsPriceListPK;
    }

    public DetailsPriceList(DetailsPriceListPK detailsPriceListPK, String codeTypeIntervenantRemplacant, BigDecimal prix, boolean isException, boolean isExceptionFamille, BigDecimal valeur, String nature) {
        this.detailsPriceListPK = detailsPriceListPK;
        this.codeTypeIntervenantRemplacant = codeTypeIntervenantRemplacant;
        this.prix = prix;
        this.isException = isException;
        this.isExceptionFamille = isExceptionFamille;
        this.valeur = valeur;
        this.nature = nature;
    }


    public DetailsPriceList(int codePrestation, String codeTypeIntervenant, String codeNatureAdmission, int codePriceList) {
        this.detailsPriceListPK = new DetailsPriceListPK(codePrestation, codeTypeIntervenant, codeNatureAdmission, codePriceList);
    }

    public DetailsPriceListPK getDetailsPriceListPK() {
        return detailsPriceListPK;
    }

    public void setDetailsPriceListPK(DetailsPriceListPK detailsPriceListPK) {
        this.detailsPriceListPK = detailsPriceListPK;
    }

    public String getCodeTypeIntervenantRemplacant() {
        return codeTypeIntervenantRemplacant;
    }

    public void setCodeTypeIntervenantRemplacant(String codeTypeIntervenantRemplacant) {
        this.codeTypeIntervenantRemplacant = codeTypeIntervenantRemplacant;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
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

    public BigDecimal getValeur() {
        return valeur;
    }

    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailsPriceListPK != null ? detailsPriceListPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailsPriceList)) {
            return false;
        }
        DetailsPriceList other = (DetailsPriceList) object;
        if ((this.detailsPriceListPK == null && other.detailsPriceListPK != null) || (this.detailsPriceListPK != null && !this.detailsPriceListPK.equals(other.detailsPriceListPK))) {
            return false;
        }
        return true;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.DetailsPriceList[ detailsPriceListPK=" + detailsPriceListPK + " ]";
    }
    
}
