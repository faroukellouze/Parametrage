/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrateur
 */
@Embeddable
public class PieceJointeBordereauSocietePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Code_Type_Piece_Jointe")
    private int codeTypePieceJointe;
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "Code_Societe")
    private int codeSociete;

    public PieceJointeBordereauSocietePK() {
    }

    public PieceJointeBordereauSocietePK(int codeTypePieceJointe, int codeSociete) {
        this.codeTypePieceJointe = codeTypePieceJointe;
        this.codeSociete = codeSociete;
    }

    public int getCodeTypePieceJointe() {
        return codeTypePieceJointe;
    }

    public void setCodeTypePieceJointe(int codeTypePieceJointe) {
        this.codeTypePieceJointe = codeTypePieceJointe;
    }

    public int getCodeSociete() {
        return codeSociete;
    }

    public void setCodeSociete(int codeSociete) {
        this.codeSociete = codeSociete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codeTypePieceJointe;
        hash += (int) codeSociete;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PieceJointeBordereauSocietePK)) {
            return false;
        }
        PieceJointeBordereauSocietePK other = (PieceJointeBordereauSocietePK) object;
        if (this.codeTypePieceJointe != other.codeTypePieceJointe) {
            return false;
        }
        if (this.codeSociete != other.codeSociete) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrage.domain.PieceJointeBordereauSocietePK[ codeTypePieceJointe=" + codeTypePieceJointe + ", codeSociete=" + codeSociete + " ]";
    }
    
}
