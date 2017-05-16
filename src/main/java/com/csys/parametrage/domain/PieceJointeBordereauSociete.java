/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "Piece_Jointe_Bordereau_Societe")
@NamedQueries({
    @NamedQuery(name = "PieceJointeBordereauSociete.findAll", query = "SELECT p FROM PieceJointeBordereauSociete p")})
public class PieceJointeBordereauSociete implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PieceJointeBordereauSocietePK pieceJointeBordereauSocietePK;
    @Column(name = "Nombre")
    private Integer nombre;
    
    @MapsId(value = "codeSociete")
    @ManyToOne
    @JoinColumn(name = "Code_Societe", referencedColumnName = "Code")
    @JsonBackReference
    private Societe societe;
    @JoinColumn(name = "Code_Type_Piece_Jointe", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne
    @JsonManagedReference
    private TypePieceJointeBordereau typePieceJointeBordereau;

    public PieceJointeBordereauSociete() {
    }

    public PieceJointeBordereauSocietePK getPieceJointeBordereauSocietePK() {
        return pieceJointeBordereauSocietePK;
    }

    public void setPieceJointeBordereauSocietePK(PieceJointeBordereauSocietePK pieceJointeBordereauSocietePK) {
        this.pieceJointeBordereauSocietePK = pieceJointeBordereauSocietePK;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public TypePieceJointeBordereau getTypePieceJointeBordereau() {
        return typePieceJointeBordereau;
    }

    public void setTypePieceJointeBordereau(TypePieceJointeBordereau typePieceJointeBordereau) {
        this.typePieceJointeBordereau = typePieceJointeBordereau;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pieceJointeBordereauSocietePK != null ? pieceJointeBordereauSocietePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PieceJointeBordereauSociete)) {
            return false;
        }
        PieceJointeBordereauSociete other = (PieceJointeBordereauSociete) object;
        if ((this.pieceJointeBordereauSocietePK == null && other.pieceJointeBordereauSocietePK != null) || (this.pieceJointeBordereauSocietePK != null && !this.pieceJointeBordereauSocietePK.equals(other.pieceJointeBordereauSocietePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.PieceJointeBordereauSociete[ pieceJointeBordereauSocietePK=" + pieceJointeBordereauSocietePK + " ]";
    }
    
}
