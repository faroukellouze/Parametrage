/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "Responsale_Contacte")
public class ResponsaleContacte implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResponsaleContactePK responsaleContactePK;

    @JoinColumn(name = "Code_Type_Contact", referencedColumnName = "Code", insertable = false, updatable = false)
    @ManyToOne
    private TypeContacte typeContacte;

    @MapsId(value = "codeResponsable")
    @JoinColumn(name = "CodeResponsable", referencedColumnName = "Code", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private ResponsableSociete responsableSociete;

    public ResponsaleContacte() {
    }

    public ResponsaleContacte(ResponsaleContactePK responsaleContactePK) {
        this.responsaleContactePK = responsaleContactePK;
    }

    public ResponsaleContactePK getResponsaleContactePK() {
        return responsaleContactePK;
    }

    public void setResponsaleContactePK(ResponsaleContactePK responsaleContactePK) {
        this.responsaleContactePK = responsaleContactePK;
    }

    public TypeContacte getTypeContacte() {
        return typeContacte;
    }

    public void setTypeContacte(TypeContacte typeContacte) {
        this.typeContacte = typeContacte;
    }

    public ResponsableSociete getResponsableSociete() {
        return responsableSociete;
    }

    public void setResponsableSociete(ResponsableSociete responsableSociete) {
        this.responsableSociete = responsableSociete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (responsaleContactePK != null ? responsaleContactePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ResponsaleContacte)) {
            return false;
        }
        ResponsaleContacte other = (ResponsaleContacte) object;
        if ((this.responsaleContactePK == null && other.responsaleContactePK != null) || (this.responsaleContactePK != null && !this.responsaleContactePK.equals(other.responsaleContactePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.ResponsableSociete[ responsaleContactePK=" + responsaleContactePK + " ]";
    }

}
