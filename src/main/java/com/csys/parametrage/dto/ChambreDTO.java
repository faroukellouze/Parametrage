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


public class ChambreDTO {

    private Integer code;
    @Basic(optional = false)
    @NotNull
    private String numeroChambre;
    @Basic(optional = false)
    @NotNull
    private boolean autorisAccompagant;
    @Basic(optional = false)
    @NotNull
    private boolean virtuelle;
    @NotNull
    private boolean actif;
    @Size(min = 1, max = 30)
    private String userCreate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    private CathegorieDTO codeCathegorie;
    private EtageDTO codeEtage;
    private EtatChambreDTO etatChambre;
    private ServiceDTO codeService;
    private Collection<LitDTO> litCollection;
    @Basic(optional = false)
    @NotNull
    private Integer nbrLit;
    
    public ChambreDTO() {
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

    public CathegorieDTO getCodeCathegorie() {
        return codeCathegorie;
    }

    public void setCodeCathegorie(CathegorieDTO codeCathegorie) {
        this.codeCathegorie = codeCathegorie;
    }

    public EtageDTO getCodeEtage() {
        return codeEtage;
    }

    public void setCodeEtage(EtageDTO codeEtage) {
        this.codeEtage = codeEtage;
    }

    public EtatChambreDTO getEtatChambre() {
        return etatChambre;
    }

    public void setEtatChambre(EtatChambreDTO etatChambre) {
        this.etatChambre = etatChambre;
    }

    public ServiceDTO getCodeService() {
        return codeService;
    }

    public void setCodeService(ServiceDTO codeService) {
        this.codeService = codeService;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public Collection<LitDTO> getLitCollection() {
        return litCollection;
    }

    public void setLitCollection(Collection<LitDTO> litCollection) {
        this.litCollection = litCollection;
    }

    public Integer getNbrLit() {
        return nbrLit;
    }

    public void setNbrLit(Integer nbrLit) {
        this.nbrLit = nbrLit;
    }
}
