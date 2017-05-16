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

/**
 *
 * @author gh18
 */
@Embeddable
public class DetailsCouverturePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Code_Liste_Couverture")
    private int codeListeCouverture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Code_Prestation")
    private int codePrestation;

    public DetailsCouverturePK() {
    }

    public DetailsCouverturePK(int codeListeCouverture, int codePrestation) {
        this.codeListeCouverture = codeListeCouverture;
        this.codePrestation = codePrestation;
    }

    public int getCodeListeCouverture() {
        return codeListeCouverture;
    }

    public void setCodeListeCouverture(int codeListeCouverture) {
        this.codeListeCouverture = codeListeCouverture;
    }

    public int getCodePrestation() {
        return codePrestation;
    }

    public void setCodePrestation(int codePrestation) {
        this.codePrestation = codePrestation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codeListeCouverture;
        hash += (int) codePrestation;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailsCouverturePK)) {
            return false;
        }
        DetailsCouverturePK other = (DetailsCouverturePK) object;
        if (this.codeListeCouverture != other.codeListeCouverture) {
            return false;
        }
        if (this.codePrestation != other.codePrestation) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.DetailsCouverturePK[ codeListeCouverture=" + codeListeCouverture + ", codePrestation=" + codePrestation + " ]";
    }
    
}
