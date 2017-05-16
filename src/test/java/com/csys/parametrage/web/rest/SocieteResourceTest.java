/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.csys.parametrage.web.rest;


import com.csys.parametrage.domain.Societe;
import com.csys.parametrage.dto.BanqueDTO;
import com.csys.parametrage.dto.ContactSocieteDTO;
import com.csys.parametrage.dto.FonctionResponsableSocieteDTO;
import com.csys.parametrage.dto.ModeReglementDTO;
import com.csys.parametrage.dto.PieceJointeBordereauSocieteDTO;
import com.csys.parametrage.dto.ResponsaleContacteDTO;
import com.csys.parametrage.dto.ResponsableSocieteDTO;
import com.csys.parametrage.dto.SecteurActiviteDTO;
import com.csys.parametrage.dto.SocieteDTO;
import com.csys.parametrage.dto.TypeContacteDTO;
import com.csys.parametrage.dto.TypePieceJointeBordereauDTO;
import com.csys.parametrage.service.SocieteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * {@code @SpringBootTest} based tests for {@link UserVehicleController}.
 *
 * @author Phillip Webb
 */
//@RunWith(SpringRunner.class)
//@WebMvcTest(SocieteResource.class)
public class SocieteResourceTest {

//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private SocieteService societeService;
//
//    @Autowired
//    ObjectMapper objectMapper;

//    @Test
//    public void saveSocieteShouldReturnSociete() throws Exception {
//        BanqueDTO banquedto = new BanqueDTO();
//        banquedto.setCode(12);
//        banquedto.setDesignation("Biat");
//
//        ModeReglementDTO modRegdto = new ModeReglementDTO();
//        modRegdto.setCode(12);
//        modRegdto.setDesignation("chèque");
//
//        SecteurActiviteDTO secteurdto = new SecteurActiviteDTO();
//        secteurdto.setCode(12);
//        secteurdto.setDesignation("COMMERCIAL");
//
//        TypePieceJointeBordereauDTO typePiece = new TypePieceJointeBordereauDTO();
//        typePiece.setCode(12);
//        typePiece.setDesignation("CIN");
//
//        TypeContacteDTO typeContacte = new TypeContacteDTO();
//        typeContacte.setCode(1);
//        typeContacte.setDesignation("TEL");
//
//        FonctionResponsableSocieteDTO fcnt = new FonctionResponsableSocieteDTO();
//        fcnt.setCode(1);
//        fcnt.setDesignation("MANEGER");
//
//        ResponsaleContacteDTO resp = new ResponsaleContacteDTO();
//        resp.setCode(1);
//        resp.setActif(true);
//        resp.setCodeFonctionResponsableSociete(fcnt);
//        resp.setNomResponsable("FOULEN");
//
//        PieceJointeBordereauSocieteDTO piece = new PieceJointeBordereauSocieteDTO();
//        piece.setCodeTypePieceJointe(typePiece);
//        piece.setNombre(3);
//
//        ResponsableSocieteDTO respSoc = new ResponsableSocieteDTO();
//        respSoc.setCodeResponsable(resp);
//        respSoc.setCodeTypeContact(typeContacte);
//        respSoc.setValeur("123");
//
//        ContactSocieteDTO contacteSoc = new ContactSocieteDTO();
//        contacteSoc.setCodeTypeContact(typeContacte);
//        contacteSoc.setValeur("456");
//
//        Collection<PieceJointeBordereauSocieteDTO> pieceJointeBordereauSocieteCollection = new ArrayList<>();
//        Collection<ContactSocieteDTO> contactSocieteCollection = new ArrayList<>();
//        Collection<ResponsableSocieteDTO> responsableSocieteCollection = new ArrayList<>();
//
//        pieceJointeBordereauSocieteCollection.add(piece);
//        contactSocieteCollection.add(contacteSoc);
//        responsableSocieteCollection.add(respSoc);
//
//        SocieteDTO societeDto = new SocieteDTO();
//        societeDto.setActif(true);
//        societeDto.setCalculDifferencePrix("C");
//        societeDto.setCodeBanque(banquedto);
//        societeDto.setCodeModeReglement(modRegdto);
//        societeDto.setCodeSaisie("0001");
//        societeDto.setCodeSecteurActivite(secteurdto);
//        societeDto.setContactSocieteCollection(contactSocieteCollection);
//        societeDto.setDateCreation(new Date());
//        societeDto.setDelaisFacturation(0);
//        societeDto.setDelaisReglement(0);
//        societeDto.setDesignation("SOCIETE");
//        societeDto.setNiveauBordereau("C");
//        societeDto.setPieceJointeBordereauSocieteCollection(pieceJointeBordereauSocieteCollection);
//        societeDto.setResponsableSocieteCollection(responsableSocieteCollection);
//        societeDto.setRib("12345678");
//        societeDto.setSeuilCredit(BigDecimal.ZERO);
//        societeDto.setSeuilCreditAlerte(BigDecimal.ZERO);
//        societeDto.setTimbre(true);
//        societeDto.setUserCreation("ADMIN");
//        
//        Societe societe =new Societe();
//        societe.setCode(1);
//        societe.setDesignation("SOCIETE");
//        
//        
//
//        given(this.societeService.save((SocieteDTO) anyObject(),anyString()))
//                .willReturn(societe);
//        this.mvc.perform(post("/api/societes")
//                .content(TestUtil.convertObjectToJsonBytes(societeDto))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.designation").value("SOCIETE"));
//    }

}
