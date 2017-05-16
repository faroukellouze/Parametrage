/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "Responsable_Societe")
@NamedQueries({
    @NamedQuery(name = "ResponsableSociete.findAll", query = "SELECT r FROM ResponsableSociete r")})
public class ResponsableSociete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private int code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NomResponsable")
    private String nomResponsable;
    @JoinColumn(name = "Code_Fonction_Responsable_Societe", referencedColumnName = "Code")
    @ManyToOne
    private FonctionResponsableSociete codeFonctionResponsableSociete;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_Societe", referencedColumnName = "Code")
    @JsonBackReference
    private Societe societe;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsableSociete")
    @JsonManagedReference
    private Collection<ResponsaleContacte> responsableContacteCollection;

    @Basic(optional = false)
    @NotNull
    @Column(name = "Actif")
    private boolean actif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "UserCreation")
    private String userCreation;
    @Column(name = "DateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    
    
    public ResponsableSociete() {
         this.nomResponsable="";
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

    public FonctionResponsableSociete getCodeFonctionResponsableSociete() {
        return codeFonctionResponsableSociete;
    }

    public void setCodeFonctionResponsableSociete(FonctionResponsableSociete codeFonctionResponsableSociete) {
        this.codeFonctionResponsableSociete = codeFonctionResponsableSociete;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public Collection<ResponsaleContacte> getResponsableContacteCollection() {
        return responsableContacteCollection;
    }

    public void setResponsableContacteCollection(Collection<ResponsaleContacte> responsableContacteCollection) {
        this.responsableContacteCollection = responsableContacteCollection;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.code;
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
        final ResponsableSociete other = (ResponsableSociete) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.ResponsableSociete[ code=" + code + " ]";
    }

}
