/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.dto;

import javax.persistence.Basic;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrateur
 */
public class ParamDTO {

    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    private String valeur;
    @Size(max = 500)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String nature;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String module;

    public ParamDTO() {
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
    
    

}
