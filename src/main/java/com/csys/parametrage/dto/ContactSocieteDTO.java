/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.dto;

import javax.persistence.Basic;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
public class ContactSocieteDTO {
    
    private int codeSociete;
    @Basic(optional = false)
    @NotNull
    private TypeContacteDTO codeTypeContact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String valeur;

    public ContactSocieteDTO() {
    }

    public ContactSocieteDTO(int codeSociete, TypeContacteDTO codeTypeContact, String valeur) {
        this.codeSociete = codeSociete;
        this.codeTypeContact = codeTypeContact;
        this.valeur = valeur;
    }  

    public int getCodeSociete() {
        return codeSociete;
    }

    public void setCodeSociete(int codeSociete) {
        this.codeSociete = codeSociete;
    }

    public TypeContacteDTO getCodeTypeContact() {
        return codeTypeContact;
    }

    public void setCodeTypeContact(TypeContacteDTO codeTypeContact) {
        this.codeTypeContact = codeTypeContact;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

}
