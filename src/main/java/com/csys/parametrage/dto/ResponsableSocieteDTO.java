/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.dto;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
public class ResponsableSocieteDTO {

    private int code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String nomResponsable;
    private FonctionResponsableSocieteDTO codeFonctionResponsableSociete;

    private int codeSociete;

    private Collection<ResponsaleContacteDTO> codeTypeContact;
    
    @NotNull
    private boolean actif;
    private String userCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    public ResponsableSocieteDTO() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNomResponsable() {
        return nomResponsable;
    }

    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public FonctionResponsableSocieteDTO getCodeFonctionResponsableSociete() {
        return codeFonctionResponsableSociete;
    }

    public void setCodeFonctionResponsableSociete(FonctionResponsableSocieteDTO codeFonctionResponsableSociete) {
        this.codeFonctionResponsableSociete = codeFonctionResponsableSociete;
    }

    public int getCodeSociete() {
        return codeSociete;
    }

    public void setCodeSociete(int codeSociete) {
        this.codeSociete = codeSociete;
    }

    public Collection<ResponsaleContacteDTO> getCodeTypeContact() {
        return codeTypeContact;
    }

    public void setCodeTypeContact(Collection<ResponsaleContacteDTO> codeTypeContact) {
        this.codeTypeContact = codeTypeContact;
    }

    public String getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

   

}
