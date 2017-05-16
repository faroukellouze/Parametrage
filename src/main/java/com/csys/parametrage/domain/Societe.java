/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "Societe")
@NamedQueries({
    @NamedQuery(name = "Societe.findAll", query = "SELECT s FROM Societe s")})
/**
 * @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
 *
 */
public class Societe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private Integer code;
    @Size(max = 20)
    @Column(name = "CodeSaisie")
    private String codeSaisie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Designation")
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SeuilCredit")
    private BigDecimal seuilCredit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SeuilCreditAlerte")
    private BigDecimal seuilCreditAlerte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Timbre")
    private boolean timbre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DelaisFacturation")
    private int delaisFacturation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DelaisReglement")
    private int delaisReglement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Actif")
    private boolean actif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RIB")
    private String rib;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NiveauBordereau")
    @Size(min = 1, max = 1)
    private String niveauBordereau;
    @Basic(optional = false)
    /* @NotNull*/
    @Column(name = "CalculDifferencePrix", columnDefinition = "nvarchar(1) default 'C'")
    @Size(min = 1, max = 1)
    private String calculDifferencePrix;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "UserCreation")
    private String userCreation;
    @Column(name = "DateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "societe", orphanRemoval = true)
    @JsonManagedReference
    private Collection<ContactSociete> contactSocieteCollection;
    @JoinColumn(name = "CodeBanque", referencedColumnName = "Code")
    @ManyToOne
    @JsonManagedReference
    private Banque codeBanque;
    @JoinColumn(name = "CodeModeReglement", referencedColumnName = "Code")
    @ManyToOne
    @JsonManagedReference
    private ModeReglement codeModeReglement;
    @JoinColumn(name = "CodeSecteurActivite", referencedColumnName = "Code")
    @ManyToOne
    @JsonManagedReference
    private SecteurActivite codeSecteurActivite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "societe", orphanRemoval = true)
    @JsonManagedReference
    private Collection<PieceJointeBordereauSociete> pieceJointeBordereauSocieteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "societe", orphanRemoval = true)
    @JsonManagedReference
    private Collection<ResponsableSociete> responsableSocieteCollection;
    @Basic(optional = false)
    /*    @NotNull*/
    @Size(min = 1, max = 200)
    @Column(name = "Observation", columnDefinition = "nvarchar(200) default ''")
    private String observation;

    public Societe() {
        this.actif = true;
        this.calculDifferencePrix = "C";
        this.codeSaisie = "";
        this.dateCreation = new Date();
        this.delaisFacturation = 0;
        this.delaisReglement = 0;
        this.designation = "";
        this.niveauBordereau = "C";
        this.rib = "";
        this.seuilCredit = BigDecimal.ZERO;
        this.seuilCreditAlerte = BigDecimal.ZERO;
        this.timbre = true;
        this.userCreation = "";

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

    public boolean getTimbre() {
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

    public boolean getActif() {
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

    public Collection<ContactSociete> getContactSocieteCollection() {
        return contactSocieteCollection;
    }

    public void setContactSocieteCollection(Collection<ContactSociete> contactSocieteCollection) {
        this.contactSocieteCollection = contactSocieteCollection;
    }

    public Banque getCodeBanque() {
        return codeBanque;
    }

    public void setCodeBanque(Banque codeBanque) {
        this.codeBanque = codeBanque;
    }

    public ModeReglement getCodeModeReglement() {
        return codeModeReglement;
    }

    public void setCodeModeReglement(ModeReglement codeModeReglement) {
        this.codeModeReglement = codeModeReglement;
    }

    public SecteurActivite getCodeSecteurActivite() {
        return codeSecteurActivite;
    }

    public void setCodeSecteurActivite(SecteurActivite codeSecteurActivite) {
        this.codeSecteurActivite = codeSecteurActivite;
    }

    public Collection<PieceJointeBordereauSociete> getPieceJointeBordereauSocieteCollection() {
        return pieceJointeBordereauSocieteCollection;
    }

    public void setPieceJointeBordereauSocieteCollection(Collection<PieceJointeBordereauSociete> pieceJointeBordereauSocieteCollection) {
        this.pieceJointeBordereauSocieteCollection = pieceJointeBordereauSocieteCollection;
    }

    public Collection<ResponsableSociete> getResponsableSocieteCollection() {
        return responsableSocieteCollection;
    }

    public void setResponsableSocieteCollection(Collection<ResponsableSociete> responsableSocieteCollection) {
        this.responsableSocieteCollection = responsableSocieteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.code;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Societe)) {
            return false;
        }
        Societe other = (Societe) object;
        if (this.code != other.code) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.Societe[ code=" + code + " ]";
    }

}
