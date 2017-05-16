/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
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
@Table(name = "Chambre")
@NamedQueries({
    @NamedQuery(name = "Chambre.findAll", query = "SELECT c FROM Chambre c", hints = {
        @QueryHint(name = "toplink.cache-usage", value = "DoNotCheckCache")})
})
@NamedEntityGraph(name = "Chambre.code",
        attributeNodes = @NamedAttributeNode("code"))

public class Chambre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private Integer code;
    @Size(max = 20)
    @Column(name = "NumeroChambre")
    private String numeroChambre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AutorisAccompagant")
    private boolean autorisAccompagant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Virtuelle")
    private boolean virtuelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Actif")
    private boolean actif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "UserCreate")
    private String userCreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateCreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @JoinColumn(name = "CodeCathegorie", referencedColumnName = "Code")
    @ManyToOne
    private Cathegorie codeCathegorie;
    @JoinColumn(name = "CodeEtage", referencedColumnName = "Code")
    @ManyToOne
    private Etage codeEtage;
    @JoinColumn(name = "EtatChambre", referencedColumnName = "Code")
    @ManyToOne
    private EtatChambre etatChambre;
    @JoinColumn(name = "CodeService", referencedColumnName = "Code")
    @ManyToOne
    private Service codeService;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numChambre", orphanRemoval = true)
    @JsonManagedReference
    private Collection<Lit> litCollection;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NbrLit")
    private Integer nbrLit;

    public Chambre() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(String numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public boolean getAutorisAccompagant() {
        return autorisAccompagant;
    }

    public void setAutorisAccompagant(boolean autorisAccompagant) {
        this.autorisAccompagant = autorisAccompagant;
    }

    public boolean getVirtuelle() {
        return virtuelle;
    }

    public void setVirtuelle(boolean virtuelle) {
        this.virtuelle = virtuelle;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Cathegorie getCodeCathegorie() {
        return codeCathegorie;
    }

    public void setCodeCathegorie(Cathegorie codeCathegorie) {
        this.codeCathegorie = codeCathegorie;
    }

    public Etage getCodeEtage() {
        return codeEtage;
    }

    public void setCodeEtage(Etage codeEtage) {
        this.codeEtage = codeEtage;
    }

    public EtatChambre getEtatChambre() {
        return etatChambre;
    }

    public void setEtatChambre(EtatChambre etatChambre) {
        this.etatChambre = etatChambre;
    }

    public Service getCodeService() {
        return codeService;
    }

    public void setCodeService(Service codeService) {
        this.codeService = codeService;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public Collection<Lit> getLitCollection() {
        return litCollection;
    }

    public void setLitCollection(Collection<Lit> litCollection) {
        this.litCollection = litCollection;
    }

    public Integer getNbrLit() {
        return nbrLit;
    }

    public void setNbrLit(Integer nbrLit) {
        this.nbrLit = nbrLit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Chambre)) {
            return false;
        }
        Chambre other = (Chambre) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.Chambre[ code=" + code + " ]";
    }

}
