/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.dto;

import javax.persistence.Basic;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrateur
 */
public class PieceJointeBordereauSocieteDTO {

    @Basic(optional = false)
    private TypePieceJointeBordereauDTO codeTypePieceJointe;
    @Basic(optional = false)
    @NotNull
    private int codeSociete;
    private Integer nombre;

    public PieceJointeBordereauSocieteDTO() {
    }

    public PieceJointeBordereauSocieteDTO(TypePieceJointeBordereauDTO codeTypePieceJointe, int codeSociete, Integer nombre) {
        this.codeTypePieceJointe = codeTypePieceJointe;
        this.codeSociete = codeSociete;
        this.nombre = nombre;
    }

    
    
    public TypePieceJointeBordereauDTO getCodeTypePieceJointe() {
        return codeTypePieceJointe;
    }

    public void setCodeTypePieceJointe(TypePieceJointeBordereauDTO codeTypePieceJointe) {
        this.codeTypePieceJointe = codeTypePieceJointe;
    }

    public int getCodeSociete() {
        return codeSociete;
    }

    public void setCodeSociete(int codeSociete) {
        this.codeSociete = codeSociete;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }
    
    
}
