/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.factory;

import com.csys.parametrage.domain.ContactSociete;
import com.csys.parametrage.domain.ContactSocietePK;
import com.csys.parametrage.domain.Societe;
import com.csys.parametrage.dto.ContactSocieteDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class ContactSocieteFactory {

    public static Collection<ContactSociete> listContactSocieteDTOToListContactSociete(Collection<ContactSocieteDTO> listContactSocietDTO, Societe societe) {
        List<ContactSociete> listContactSociete = new ArrayList<>();
        for (ContactSocieteDTO contactSocieteDTO : listContactSocietDTO) {
            ContactSociete contactSociete = new ContactSociete();
            ContactSocietePK contactSocietePK = new ContactSocietePK();
//            contactSocietePK.setCodeSociete(societe.getCode());
            contactSocietePK.setCodeTypeContact(contactSocieteDTO.getCodeTypeContact().getCode());
            contactSocietePK.setValeur(contactSocieteDTO.getValeur());
            contactSociete.setContactSocietePK(contactSocietePK);
            contactSociete.setSociete(societe);
            listContactSociete.add(contactSociete);
        }
        return listContactSociete;
    }
    
    public static Collection<ContactSociete> listContactSocieteDTOToListContactSocieteUpdate(Collection<ContactSocieteDTO> listContactSocietDTO, Societe societe) {
        List<ContactSociete> listContactSociete = new ArrayList<>();
        for (ContactSocieteDTO contactSocieteDTO : listContactSocietDTO) {
            ContactSociete contactSociete = new ContactSociete();
            ContactSocietePK contactSocietePK = new ContactSocietePK();
            contactSocietePK.setCodeSociete(societe.getCode());
            contactSocietePK.setCodeTypeContact(contactSocieteDTO.getCodeTypeContact().getCode());
            contactSocietePK.setValeur(contactSocieteDTO.getValeur());
            contactSociete.setContactSocietePK(contactSocietePK);
            contactSociete.setSociete(societe);
            listContactSociete.add(contactSociete);
        }
        return listContactSociete;
    }
    
    public static Collection<ContactSocieteDTO> listContactSocieteToListContactSocieteDTO(Collection<ContactSociete> listContactSociet) {
        List<ContactSocieteDTO> listContactSocieteDTO = new ArrayList<>();
        for (ContactSociete contactSociete : listContactSociet) {
            ContactSocieteDTO contactSocieteDTO = new ContactSocieteDTO();
            contactSocieteDTO.setCodeSociete(contactSociete.getContactSocietePK().getCodeSociete());
            contactSocieteDTO.setCodeTypeContact(TypeContacteFactory.typeContacteToTypeContacteDTO(contactSociete.getTypeContacte()));
            contactSocieteDTO.setValeur(contactSociete.getContactSocietePK().getValeur());
            listContactSocieteDTO.add(contactSocieteDTO);
        }
        return listContactSocieteDTO;
    }

}
