/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "Contact_Societe")
@NamedQueries({
    @NamedQuery(name = "ContactSociete.findAll", query = "SELECT c FROM ContactSociete c")})
public class ContactSociete implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContactSocietePK contactSocietePK;

    @MapsId(value = "codeSociete")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "Code_Societe", referencedColumnName = "Code")
    private Societe societe;

    @JoinColumn(name = "Code_Type_Contact", referencedColumnName = "Code", insertable = false, updatable = false, nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private TypeContacte typeContacte;

    public ContactSociete() {
    }

    public ContactSocietePK getContactSocietePK() {
        return contactSocietePK;
    }

    public void setContactSocietePK(ContactSocietePK contactSocietePK) {
        this.contactSocietePK = contactSocietePK;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public TypeContacte getTypeContacte() {
        return typeContacte;
    }

    public void setTypeContacte(TypeContacte typeContacte) {
        this.typeContacte = typeContacte;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.contactSocietePK);
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
        final ContactSociete other = (ContactSociete) obj;
        if (!Objects.equals(this.contactSocietePK, other.contactSocietePK)) {
            return false;
        }
        return true;
    }

   
    @Override
    public String toString() {
        return "com.csys.parametrage.domain.ContactSociete[ contactSocietePK=" + contactSocietePK + " ]";
    }

}
