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
public class ContactSocietePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Code_Societe")
    private Integer codeSociete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Code_Type_Contact")
    private int codeTypeContact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Valeur")
    private String valeur;

    public ContactSocietePK() {
    }

    public Integer getCodeSociete() {
        return codeSociete;
    }

    public void setCodeSociete(Integer codeSociete) {
        this.codeSociete = codeSociete;
    }

    public int getCodeTypeContact() {
        return codeTypeContact;
    }

    public void setCodeTypeContact(int codeTypeContact) {
        this.codeTypeContact = codeTypeContact;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.codeSociete;
        hash = 23 * hash + this.codeTypeContact;
        hash = 23 * hash + Objects.hashCode(this.valeur);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactSocietePK)) {
            return false;
        }
        ContactSocietePK other = (ContactSocietePK) object;
        if (this.codeSociete != other.codeSociete) {
            return false;
        }
        if (this.codeTypeContact != other.codeTypeContact) {
            return false;
        }
        if (!this.valeur.equals( other.valeur)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.ContactSocietePK[ codeSociete=" + codeSociete + ", codeTypeContact=" + codeTypeContact +  ", valeur=" + valeur + " ]";
    }

}
