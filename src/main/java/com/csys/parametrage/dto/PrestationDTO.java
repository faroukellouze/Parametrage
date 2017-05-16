/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.dto;

import com.csys.parametrage.domain.FamilleFacturation;
import com.csys.parametrage.domain.SousFamillePrestation;
import com.csys.parametrage.domain.Tva;
import com.csys.parametrage.domain.TypePrestation;
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
public class PrestationDTO {

    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String codeSaisie;
    @Size( max = 200)
    private String designationEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String designationAr;
    @Size(max = 200)
    private String designationFr;
    @Basic(optional = false)
    @NotNull
    private int codeBeneficiere;
    @Basic(optional = false)
    @NotNull
    private boolean autorisModifierPrix;
    @Basic(optional = false)
    @NotNull
    private boolean demandeObligatoire;
    @Basic(optional = false)
    @NotNull
    private boolean compteRendu;
    @Basic(optional = false)
    @NotNull
    private boolean etage;
    @Basic(optional = false)
    @NotNull
    private boolean facturation;
    @Basic(optional = false)
    @NotNull
    private boolean sousTraitance;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 20)
    private String userCreate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Basic(optional = false)
    @NotNull
    private boolean actif;
    private FamilleFacturationDTO codeFamilleFacturation;
    private SousFamillePrestationDTO codeSousFamille;
    private TvaDTO tva;
    private TypePrestationDTO codeTypePrestation;

    public PrestationDTO() {
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

    public int getCodeBeneficiere() {
        return codeBeneficiere;
    }

    public void setCodeBeneficiere(int codeBeneficiere) {
        this.codeBeneficiere = codeBeneficiere;
    }

    public boolean isAutorisModifierPrix() {
        return autorisModifierPrix;
    }

    public void setAutorisModifierPrix(boolean autorisModifierPrix) {
        this.autorisModifierPrix = autorisModifierPrix;
    }

    public boolean isDemandeObligatoire() {
        return demandeObligatoire;
    }

    public void setDemandeObligatoire(boolean demandeObligatoire) {
        this.demandeObligatoire = demandeObligatoire;
    }

    public boolean isCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(boolean compteRendu) {
        this.compteRendu = compteRendu;
    }

    public boolean isEtage() {
        return etage;
    }

    public void setEtage(boolean etage) {
        this.etage = etage;
    }

    public boolean isFacturation() {
        return facturation;
    }

    public void setFacturation(boolean facturation) {
        this.facturation = facturation;
    }

    public boolean isSousTraitance() {
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

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public FamilleFacturationDTO getCodeFamilleFacturation() {
        return codeFamilleFacturation;
    }

    public void setCodeFamilleFacturation(FamilleFacturationDTO codeFamilleFacturation) {
        this.codeFamilleFacturation = codeFamilleFacturation;
    }

    public SousFamillePrestationDTO getCodeSousFamille() {
        return codeSousFamille;
    }

    public void setCodeSousFamille(SousFamillePrestationDTO codeSousFamille) {
        this.codeSousFamille = codeSousFamille;
    }

    public TvaDTO getTva() {
        return tva;
    }

    public void setTva(TvaDTO tva) {
        this.tva = tva;
    }

    public TypePrestationDTO getCodeTypePrestation() {
        return codeTypePrestation;
    }

    public void setCodeTypePrestation(TypePrestationDTO codeTypePrestation) {
        this.codeTypePrestation = codeTypePrestation;
    }

    
    
}
