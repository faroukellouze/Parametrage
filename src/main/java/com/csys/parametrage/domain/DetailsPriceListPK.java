/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gh18
 */
@Embeddable
public class DetailsPriceListPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Code_Prestation")
    private int codePrestation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Code_Type_Intervenant")
    private String codeTypeIntervenant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Code_Nature_Admission")
    private String codeNatureAdmission;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Code_Price_List")
    private int codePriceList;

    public DetailsPriceListPK() {
    }

    public DetailsPriceListPK(int codePrestation, String codeTypeIntervenant, String codeNatureAdmission, int codePriceList) {
        this.codePrestation = codePrestation;
        this.codeTypeIntervenant = codeTypeIntervenant;
        this.codeNatureAdmission = codeNatureAdmission;
        this.codePriceList = codePriceList;
    }

    public int getCodePrestation() {
        return codePrestation;
    }

    public void setCodePrestation(int codePrestation) {
        this.codePrestation = codePrestation;
    }

    public String getCodeTypeIntervenant() {
        return codeTypeIntervenant;
    }

    public void setCodeTypeIntervenant(String codeTypeIntervenant) {
        this.codeTypeIntervenant = codeTypeIntervenant;
    }

    public String getCodeNatureAdmission() {
        return codeNatureAdmission;
    }

    public void setCodeNatureAdmission(String codeNatureAdmission) {
        this.codeNatureAdmission = codeNatureAdmission;
    }

    public int getCodePriceList() {
        return codePriceList;
    }

    public void setCodePriceList(int codePriceList) {
        this.codePriceList = codePriceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codePrestation;
        hash += (codeTypeIntervenant != null ? codeTypeIntervenant.hashCode() : 0);
        hash += (codeNatureAdmission != null ? codeNatureAdmission.hashCode() : 0);
        hash += (int) codePriceList;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailsPriceListPK)) {
            return false;
        }
        DetailsPriceListPK other = (DetailsPriceListPK) object;
        if (this.codePrestation != other.codePrestation) {
            return false;
        }
        if ((this.codeTypeIntervenant == null && other.codeTypeIntervenant != null) || (this.codeTypeIntervenant != null && !this.codeTypeIntervenant.equals(other.codeTypeIntervenant))) {
            return false;
        }
        if ((this.codeNatureAdmission == null && other.codeNatureAdmission != null) || (this.codeNatureAdmission != null && !this.codeNatureAdmission.equals(other.codeNatureAdmission))) {
            return false;
        }
        if (this.codePriceList != other.codePriceList) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.DetailsPriceListPK[ codePrestation=" + codePrestation + ", codeTypeIntervenant=" + codeTypeIntervenant + ", codeNatureAdmission=" + codeNatureAdmission + ", codePriceList=" + codePriceList + " ]";
    }
    
}
