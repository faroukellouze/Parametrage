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
package com.csys.parametrage.Domain;

import com.csys.parametrage.domain.Banque;
import com.csys.parametrage.domain.ContactSociete;
import com.csys.parametrage.domain.ContactSocietePK;
import com.csys.parametrage.domain.FonctionResponsableSociete;
import com.csys.parametrage.domain.ModeReglement;
import com.csys.parametrage.domain.PieceJointeBordereauSociete;
import com.csys.parametrage.domain.PieceJointeBordereauSocietePK;
import com.csys.parametrage.domain.ResponsableSociete;
import com.csys.parametrage.domain.ResponsaleContacte;
import com.csys.parametrage.domain.ResponsaleContactePK;
import com.csys.parametrage.domain.SecteurActivite;
import com.csys.parametrage.domain.Societe;
import com.csys.parametrage.domain.TypeContacte;
import com.csys.parametrage.domain.TypePieceJointeBordereau;
import com.csys.parametrage.repository.SocieteRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
public class SocieteRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SocieteRepository societeRepository;

    private Banque banque;
    private ModeReglement modReg;
    private SecteurActivite secteur;
    private TypePieceJointeBordereau typePiece;
    private TypeContacte typeContacte;
    private FonctionResponsableSociete fcnt;
    private PieceJointeBordereauSociete piece;
    private ResponsableSociete resp;
    private ResponsaleContacte respContacte;
    private ContactSociete contacteSoc;
    private Collection<PieceJointeBordereauSociete> pieceJointeBordereauSocieteCollection = new ArrayList<>();
    private Collection<ContactSociete> contactSocieteCollection = new ArrayList<>();
    private Collection<ResponsableSociete> responsableSocieteCollection = new ArrayList<>();
    private Collection<ResponsaleContacte> responsableContacteCollection = new ArrayList<>();
    private Societe societe;

    @Before
    public void setup() {

        this.banque = new Banque();
        this.banque.setDesignation("TEST");
        this.banque.setActif(true);
        this.banque.setDesignationSec("TEST");
        this.banque.setUserCreation("ADMIN");
        this.banque.setDateCreation(new Date());

        this.modReg = new ModeReglement();
        this.modReg.setDesignation("chèque");
        this.modReg.setDesignationSec("TEST");
        this.modReg.setUserCreation("ADMIN");
        this.modReg.setDateCreation(new Date());

        this.secteur = new SecteurActivite();
        this.secteur.setDesignation("COMMERCIAL");
        this.secteur.setDesignationSec("TEST");
        this.secteur.setUserCreation("ADMIN");
        this.secteur.setDateCreation(new Date());

        this.typePiece = new TypePieceJointeBordereau();
        this.typePiece.setDesignation("CIN");
        this.typePiece.setDesignationSec("TEST");
        this.typePiece.setUserCreation("ADMIN");
        this.typePiece.setDateCreation(new Date());

        this.typeContacte = new TypeContacte();
        this.typeContacte.setDesignation("TEL");
        this.typeContacte.setDesignationSec("TEST");
        this.typeContacte.setUserCreation("ADMIN");
        this.typeContacte.setDateCreation(new Date());

        this.fcnt = new FonctionResponsableSociete();
        this.fcnt.setDesignation("MANEGER");
        this.fcnt.setDesignationSec("TEST");
        this.fcnt.setUserCreation("ADMIN");
        this.fcnt.setDateCreation(new Date());

        this.piece = new PieceJointeBordereauSociete();
        PieceJointeBordereauSocietePK piecePK = new PieceJointeBordereauSocietePK();
        piecePK.setCodeTypePieceJointe(1);
        this.piece.setPieceJointeBordereauSocietePK(piecePK);
        this.piece.setNombre(3);
        this.piece.setTypePieceJointeBordereau(typePiece);

        this.contacteSoc = new ContactSociete();
        ContactSocietePK contacteSocPK = new ContactSocietePK();
        contacteSocPK.setValeur("123");
        contacteSocPK.setCodeTypeContact(1);
        contacteSoc.setContactSocietePK(contacteSocPK);

        this.resp = new ResponsableSociete();
        resp.setCodeFonctionResponsableSociete(fcnt);
        resp.setNomResponsable("Foulen");
        resp.setActif(true);
        resp.setDateCreation(new Date());
        resp.setUserCreation("ADMIN");

        this.respContacte = new ResponsaleContacte();
        ResponsaleContactePK respContactePK = new ResponsaleContactePK();
        respContactePK.setCodeTypeContact(1);
        respContactePK.setValeur("123");
        respContacte.setResponsaleContactePK(respContactePK);
        respContacte.setResponsableSociete(resp);
        responsableContacteCollection.add(respContacte);

        this.societe = new Societe();
        this.societe.setActif(true);
        this.societe.setCalculDifferencePrix("C");
        this.societe.setCodeBanque(banque);
        this.societe.setCodeModeReglement(modReg);
        this.societe.setCodeSaisie("0001");
        this.societe.setCodeSecteurActivite(secteur);
        this.societe.setDateCreation(new Date());
        this.societe.setDelaisFacturation(0);
        this.societe.setDelaisReglement(0);
        this.societe.setDesignation("SOCIETE");
        this.societe.setNiveauBordereau("C");
        this.societe.setRib("12345678");
        this.societe.setSeuilCredit(BigDecimal.ZERO);
        this.societe.setSeuilCreditAlerte(BigDecimal.ZERO);
        this.societe.setTimbre(true);
        this.societe.setUserCreation("ADMIN");
        this.societe.setObservation("Observation");

        contacteSoc.setSociete(societe);
        this.resp.setSociete(societe);
        this.piece.setSociete(societe);

        this.pieceJointeBordereauSocieteCollection.add(piece);
        this.contactSocieteCollection.add(contacteSoc);
        this.responsableSocieteCollection.add(resp);
        this.societe.setContactSocieteCollection(contactSocieteCollection);
        this.societe.setPieceJointeBordereauSocieteCollection(pieceJointeBordereauSocieteCollection);
        this.societe.setResponsableSocieteCollection(responsableSocieteCollection);
    }

    @Test
    public void saveSocieteShouldReturnTrue() throws Exception {
        entityManager.persist(banque);
        entityManager.persist(secteur);
        entityManager.persist(modReg);
        entityManager.persist(typeContacte);
        entityManager.persist(typePiece);
        entityManager.persist(fcnt);
        societeRepository.save(societe);

        assertThat(societeRepository.findAll().get(0).getContactSocieteCollection().size()).isGreaterThan(0);
        assertThat(societeRepository.findAll().get(0).getPieceJointeBordereauSocieteCollection().size()).isGreaterThan(0);
        assertThat(societeRepository.findAll().get(0).getResponsableSocieteCollection().size()).isGreaterThan(0);
        assertThat(societeRepository.findAll().get(0).getDesignation()).isEqualTo("SOCIETE");

    }

}
