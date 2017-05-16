/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrage.Service;

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
import com.csys.parametrage.repository.SocieteRepository;
import com.csys.parametrage.service.SocieteService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Administrateur
 */
public class SocieteServiceTest {

    @Mock
    private SocieteRepository societeRepository;
    private SocieteService societeService;
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private BanqueDTO banquedto;
    private ModeReglementDTO modRegdto;
    private SecteurActiviteDTO secteurdto;
    private TypePieceJointeBordereauDTO typePiece;
    private TypeContacteDTO typeContacte;
    private FonctionResponsableSocieteDTO fcnt;
    private PieceJointeBordereauSocieteDTO piece;
    private ResponsaleContacteDTO resp;
    private ResponsableSocieteDTO respSoc;
    private ContactSocieteDTO contacteSoc;
    private Collection<PieceJointeBordereauSocieteDTO> pieceJointeBordereauSocieteCollection = new ArrayList<>();
    private Collection<ContactSocieteDTO> contactSocieteCollection = new ArrayList<>();
    private Collection<ResponsableSocieteDTO> responsableSocieteCollection = new ArrayList<>();
    private SocieteDTO societeDto;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.societeService = new SocieteService(this.societeRepository);

//        this.banquedto = new BanqueDTO();
//        this.banquedto.setCode(12);
//        this.banquedto.setDesignation("Biat");
//        this.modRegdto = new ModeReglementDTO();
//        this.modRegdto.setCode(12);
//        this.modRegdto.setDesignation("chèque");
//        this.secteurdto = new SecteurActiviteDTO();
//        this.secteurdto.setCode(12);
//        this.secteurdto.setDesignation("COMMERCIAL");
//        this.typePiece = new TypePieceJointeBordereauDTO();
//        this.typePiece.setCode(12);
//        this.typePiece.setDesignation("CIN");
//        this.typeContacte = new TypeContacteDTO();
//        this.typeContacte.setCode(1);
//        this.typeContacte.setDesignation("TEL");
//        this.fcnt = new FonctionResponsableSocieteDTO();
//        this.fcnt.setCode(1);
//        this.fcnt.setDesignation("MANEGER");
//        this.resp = new ResponsaleContacteDTO();
//        this.resp.setCode(1);
//        this.resp.setActif(true);
//        this.resp.setCodeFonctionResponsableSociete(fcnt);
//        this.resp.setNomResponsable("FOULEN");
//        this.piece = new PieceJointeBordereauSocieteDTO();
//        this.piece.setCodeTypePieceJointe(typePiece);
//        this.piece.setNombre(3);
//        this.respSoc = new ResponsableSocieteDTO();
//        this.respSoc.setCodeResponsable(resp);
//        this.respSoc.setCodeTypeContact(typeContacte);
//        this.respSoc.setValeur("123");
//        this.contacteSoc = new ContactSocieteDTO();
//        this.contacteSoc.setCodeTypeContact(typeContacte);
//        this.contacteSoc.setValeur("456");
//        this.pieceJointeBordereauSocieteCollection.add(piece);
//        this.contactSocieteCollection.add(contacteSoc);
//        this.responsableSocieteCollection.add(respSoc);
//        this.societeDto = new SocieteDTO();
//        this.societeDto.setActif(true);
//        this.societeDto.setCalculDifferencePrix("C");
//        this.societeDto.setCodeBanque(banquedto);
//        this.societeDto.setCodeModeReglement(modRegdto);
//        this.societeDto.setCodeSaisie("0001");
//        this.societeDto.setCodeSecteurActivite(secteurdto);
//        this.societeDto.setContactSocieteCollection(contactSocieteCollection);
//        this.societeDto.setDateCreation(new Date());
//        this.societeDto.setDelaisFacturation(0);
//        this.societeDto.setDelaisReglement(0);
//        this.societeDto.setDesignation("SOCIETE");
//        this.societeDto.setNiveauBordereau("C");
//        this.societeDto.setPieceJointeBordereauSocieteCollection(pieceJointeBordereauSocieteCollection);
//        this.societeDto.setResponsableSocieteCollection(responsableSocieteCollection);
//        this.societeDto.setRib("12345678");
//        this.societeDto.setSeuilCredit(BigDecimal.ZERO);
//        this.societeDto.setSeuilCreditAlerte(BigDecimal.ZERO);
//        this.societeDto.setTimbre(true);
//        this.societeDto.setUserCreation("ADMIN");
    }

    @Test
    public void findOneShouldThrowExeptionWhenSocieteInexistant() {
        given(this.societeRepository.findOne(anyInt())).willReturn(null);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        societeService.findOne(1);
    }

//    @Test
//    public void saveSocieteShouldReturnSociete() {
//        Societe soc = societeService.save(this.societeDto, "Admin");
//         assertThat(soc.getCodeBanque().getDesignation()).isEqualTo("Biat");
//    }

}
