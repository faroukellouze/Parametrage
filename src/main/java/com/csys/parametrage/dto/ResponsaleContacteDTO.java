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
public class ResponsaleContacteDTO {

    @Basic(optional = false)
    @NotNull
    private int codeResponsable;
    @Basic(optional = false)
    @NotNull
    private TypeContacteDTO codeTypeContact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String valeur;
    

    public ResponsaleContacteDTO() {
    }

    public int getCodeResponsable() {
        return codeResponsable;
    }

    public void setCodeResponsable(int codeResponsable) {
        this.codeResponsable = codeResponsable;
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
