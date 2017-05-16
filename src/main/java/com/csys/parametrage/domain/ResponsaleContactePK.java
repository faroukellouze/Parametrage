/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
@Embeddable
public class ResponsaleContactePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CodeResponsable")
    private int codeResponsable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Code_Type_Contact")
    private int codeTypeContact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Valeur")
    private String valeur;

    public ResponsaleContactePK() {
    }

    public ResponsaleContactePK( int codeResponsable, int codeTypeContact, String valeur) {
        this.codeResponsable = codeResponsable;
        this.codeTypeContact = codeTypeContact;
        this.valeur = valeur;
    }

    public int getCodeResponsable() {
        return codeResponsable;
    }

    public void setCodeResponsable(int codeResponsable) {
        this.codeResponsable = codeResponsable;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public int getCodeTypeContact() {
        return codeTypeContact;
    }

    public void setCodeTypeContact(int codeTypeContact) {
        this.codeTypeContact = codeTypeContact;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.codeResponsable;
        hash = 61 * hash + this.codeTypeContact;
        hash = 61 * hash + Objects.hashCode(this.valeur);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResponsaleContactePK other = (ResponsaleContactePK) obj;
        if (this.codeResponsable != other.codeResponsable) {
            return false;
        }
        if (this.codeTypeContact != other.codeTypeContact) {
            return false;
        }
        if (!Objects.equals(this.valeur, other.valeur)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ResponsaleContactePK{" + "codeResponsable=" + codeResponsable + ", codeTypeContact=" + codeTypeContact + ", valeur=" + valeur + '}';
    }
    
    
    

}
