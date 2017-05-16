/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "Prestation")
@NamedQueries({
    @NamedQuery(name = "Prestation.findAll", query = "SELECT p FROM Prestation p")})
public class Prestation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Code_Saisie")
    private String codeSaisie;
    @Size( max = 200)
    @Column(name = "Designation_En")
    private String designationEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Designation_Ar")
    private String designationAr;
    @Size( max = 200)
    @Column(name = "Designation_Fr")
    private String designationFr;
    @Column(name = "Code_Panier")
    private Integer codePanier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Code_Beneficiere")
    private int codeBeneficiere;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Autoris_Modifier_Prix")
    private boolean autorisModifierPrix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Demande_Obligatoire")
    private boolean demandeObligatoire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Compte_Rendu")
    private boolean compteRendu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Etage")
    private boolean etage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Facturation")
    private boolean facturation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sous_Traitance")
    private boolean sousTraitance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "User_Create")
    private String userCreate;
    @Column(name = "Date_Create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Actif")
    private boolean actif;
    @JoinColumn(name = "Code_Famille_Facturation", referencedColumnName = "Code")
    @ManyToOne(optional = false)
    private FamilleFacturation codeFamilleFacturation;
    @JoinColumn(name = "Code_Sous_Famille", referencedColumnName = "Code")
    @ManyToOne(optional = false)
    private SousFamillePrestation codeSousFamille;
    @JoinColumn(name = "TVA", referencedColumnName = "TVA")
    @ManyToOne
    private Tva tva;
    @JoinColumn(name = "Code_Type_Prestation", referencedColumnName = "Code")
    @ManyToOne(optional = false)
    private TypePrestation codeTypePrestation;

    public Prestation() {
        this.designationFr=""; 
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeSaisie() {
        return codeSaisie;
    }

    public void setCodeSaisie(String codeSaisie) {
        this.codeSaisie = codeSaisie;
    }

    public String getDesignationEn() {
        return designationEn;
    }

    public void setDesignationEn(String designationEn) {
        this.designationEn = designationEn;
    }

    public String getDesignationAr() {
        return designationAr;
    }

    public void setDesignationAr(String designationAr) {
        this.designationAr = designationAr;
    }

    public String getDesignationFr() {
        return designationFr;
    }

    public void setDesignationFr(String designationFr) {
        this.designationFr = designationFr;
    }

    public Integer getCodePanier() {
        return codePanier;
    }

    public void setCodePanier(Integer codePanier) {
        this.codePanier = codePanier;
    }

    public int getCodeBeneficiere() {
        return codeBeneficiere;
    }

    public void setCodeBeneficiere(int codeBeneficiere) {
        this.codeBeneficiere = codeBeneficiere;
    }

    public boolean getAutorisModifierPrix() {
        return autorisModifierPrix;
    }

    public void setAutorisModifierPrix(boolean autorisModifierPrix) {
        this.autorisModifierPrix = autorisModifierPrix;
    }

    public boolean getDemandeObligatoire() {
        return demandeObligatoire;
    }

    public void setDemandeObligatoire(boolean demandeObligatoire) {
        this.demandeObligatoire = demandeObligatoire;
    }

    public boolean getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(boolean compteRendu) {
        this.compteRendu = compteRendu;
    }

    public boolean getEtage() {
        return etage;
    }

    public void setEtage(boolean etage) {
        this.etage = etage;
    }

    public boolean getFacturation() {
        return facturation;
    }

    public void setFacturation(boolean facturation) {
        this.facturation = facturation;
    }

    public boolean getSousTraitance() {
        return sousTraitance;
    }

    public void setSousTraitance(boolean sousTraitance) {
        this.sousTraitance = sousTraitance;
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

    public boolean getActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public FamilleFacturation getCodeFamilleFacturation() {
        return codeFamilleFacturation;
    }

    public void setCodeFamilleFacturation(FamilleFacturation codeFamilleFacturation) {
        this.codeFamilleFacturation = codeFamilleFacturation;
    }

    public SousFamillePrestation getCodeSousFamille() {
        return codeSousFamille;
    }

    public void setCodeSousFamille(SousFamillePrestation codeSousFamille) {
        this.codeSousFamille = codeSousFamille;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }

    public TypePrestation getCodeTypePrestation() {
        return codeTypePrestation;
    }

    public void setCodeTypePrestation(TypePrestation codeTypePrestation) {
        this.codeTypePrestation = codeTypePrestation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Prestation)) {
            return false;
        }
        Prestation other = (Prestation) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.Prestation[ code=" + code + " ]";
    }
    
}
