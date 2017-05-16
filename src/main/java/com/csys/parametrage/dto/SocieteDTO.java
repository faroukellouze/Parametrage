/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.dto;

import java.math.BigDecimal;
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
public class SocieteDTO {

    @Basic(optional = false)
    private Integer code;
    @Size(max = 20)
    private String codeSaisie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String designation;
    @Basic(optional = false)
    @NotNull
    private BigDecimal seuilCredit;
    @Basic(optional = false)
    @NotNull
    private BigDecimal seuilCreditAlerte;
    @Basic(optional = false)
    @NotNull
    private boolean timbre;
    @Basic(optional = false)
    @NotNull
    private int delaisFacturation;
    @Basic(optional = false)
    @NotNull
    private int delaisReglement;
    @Basic(optional = false)
    @NotNull
    private boolean actif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String rib;
    @Basic(optional = false)
    @NotNull
    private String niveauBordereau;
    @Basic(optional = false)
    @NotNull
    private String calculDifferencePrix;
    private String userCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    private BanqueDTO codeBanque;
    private ModeReglementDTO codeModeReglement;
    private SecteurActiviteDTO codeSecteurActivite;
    private Collection<PieceJointeBordereauSocieteDTO> pieceJointeBordereauSocieteCollection;
    private Collection<ContactSocieteDTO> contactSocieteCollection;
    private Collection<ResponsableSocieteDTO> responsableSocieteCollection;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String observation;

    public SocieteDTO() {
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public BigDecimal getSeuilCredit() {
        return seuilCredit;
    }

    public void setSeuilCredit(BigDecimal seuilCredit) {
        this.seuilCredit = seuilCredit;
    }

    public BigDecimal getSeuilCreditAlerte() {
        return seuilCreditAlerte;
    }

    public void setSeuilCreditAlerte(BigDecimal seuilCreditAlerte) {
        this.seuilCreditAlerte = seuilCreditAlerte;
    }

    public boolean isTimbre() {
        return timbre;
    }

    public void setTimbre(boolean timbre) {
        this.timbre = timbre;
    }

    public int getDelaisFacturation() {
        return delaisFacturation;
    }

    public void setDelaisFacturation(int delaisFacturation) {
        this.delaisFacturation = delaisFacturation;
    }

    public int getDelaisReglement() {
        return delaisReglement;
    }

    public void setDelaisReglement(int delaisReglement) {
        this.delaisReglement = delaisReglement;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getNiveauBordereau() {
        return niveauBordereau;
    }

    public void setNiveauBordereau(String niveauBordereau) {
        this.niveauBordereau = niveauBordereau;
    }

    public String getCalculDifferencePrix() {
        return calculDifferencePrix;
    }

    public void setCalculDifferencePrix(String calculDifferencePrix) {
        this.calculDifferencePrix = calculDifferencePrix;
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

    public Collection<ContactSocieteDTO> getContactSocieteCollection() {
        return contactSocieteCollection;
    }

    public void setContactSocieteCollection(Collection<ContactSocieteDTO> contactSocieteCollection) {
        this.contactSocieteCollection = contactSocieteCollection;
    }

    public BanqueDTO getCodeBanque() {
        return codeBanque;
    }

    public void setCodeBanque(BanqueDTO codeBanque) {
        this.codeBanque = codeBanque;
    }

    public ModeReglementDTO getCodeModeReglement() {
        return codeModeReglement;
    }

    public void setCodeModeReglement(ModeReglementDTO codeModeReglement) {
        this.codeModeReglement = codeModeReglement;
    }

    public SecteurActiviteDTO getCodeSecteurActivite() {
        return codeSecteurActivite;
    }

    public void setCodeSecteurActivite(SecteurActiviteDTO codeSecteurActivite) {
        this.codeSecteurActivite = codeSecteurActivite;
    }

    public Collection<PieceJointeBordereauSocieteDTO> getPieceJointeBordereauSocieteCollection() {
        return pieceJointeBordereauSocieteCollection;
    }

    public void setPieceJointeBordereauSocieteCollection(Collection<PieceJointeBordereauSocieteDTO> pieceJointeBordereauSocieteCollection) {
        this.pieceJointeBordereauSocieteCollection = pieceJointeBordereauSocieteCollection;
    }

    public Collection<ResponsableSocieteDTO> getResponsableSocieteCollection() {
        return responsableSocieteCollection;
    }

    public void setResponsableSocieteCollection(Collection<ResponsableSocieteDTO> responsableSocieteCollection) {
        this.responsableSocieteCollection = responsableSocieteCollection;
    }

}
