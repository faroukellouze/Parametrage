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

import com.csys.parametrage.repository.ChambreRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.csys.parametrage.domain.Chambre;
import com.csys.parametrage.domain.Etage;
import com.csys.parametrage.domain.EtatChambre;
import com.csys.parametrage.domain.Lit;
import com.csys.parametrage.domain.Service;
import com.csys.parametrage.domain.Cathegorie;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
public class ChambreRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ChambreRepository chambreRepository;
    private Chambre chambre;
    private Etage etage;
    private EtatChambre etatChambre;
    private Service service;
    private Collection<Lit> litCollection;
    private Cathegorie cathegorie;
    private Lit lit;

    @Before
    public void setup() {

        this.etage = new Etage();
        this.etage.setActif(true);
        this.etage.setDateCreation(new Date());
        this.etage.setDesignation("TEST");
        this.etage.setDesignationAr("TEST");
        this.etage.setUserCreation("ADMIN");

        this.etatChambre = new EtatChambre();
        this.etatChambre.setActif(true);
        this.etatChambre.setColeur("#ff8080");
        this.etatChambre.setDateCreation(new Date());
        this.etatChambre.setDesignation("TEST");
        this.etatChambre.setDesignationAr("TEST");
        this.etatChambre.setEtat(true);
        this.etatChambre.setUserCreation("ADMIN");

        this.service = new Service();
        this.service.setActif(true);
        this.service.setDateCreation(new Date());
        this.service.setDesignation("TEST");
        this.service.setDesignationAr("TEST");
        this.service.setUserCreation("ADMIN");

        this.cathegorie = new Cathegorie();
        this.cathegorie.setActif(true);
        this.cathegorie.setDateCreation(new Date());
        this.cathegorie.setDesignation("TEST");
        this.cathegorie.setDesignationAr("TEST");
        this.cathegorie.setIsIcu(true);
        this.cathegorie.setPrestAccompagnat(null);
        this.cathegorie.setPrestSejour(null);
        this.cathegorie.setPrestSuivie(null);
        this.cathegorie.setPrestSurveillance(null);
        this.cathegorie.setUserCreation("ADMIN");

        this.lit = new Lit();
        this.lit.setActif(true);
        this.lit.setCoefficient(BigDecimal.ONE);
        this.lit.setDateCreation(new Date());
        this.lit.setNumChambre(chambre);
        this.lit.setNumLit("0001");
        this.lit.setUserCreation("ADMIN");
        this.lit.setEtatLit(etatChambre);
        this.litCollection = new ArrayList<Lit>();

        this.chambre = new Chambre();
        this.chambre.setActif(true);
        this.chambre.setAutorisAccompagant(true);
        this.chambre.setCodeCathegorie(cathegorie);
        this.chambre.setCodeEtage(etage);
        this.chambre.setCodeService(service);
        this.chambre.setDateCreate(new Date());
        this.chambre.setEtatChambre(etatChambre);
        this.chambre.setNbrLit(1);
        this.chambre.setNumeroChambre("0001");
        this.chambre.setUserCreate("ADMIN");
        this.chambre.setVirtuelle(true);

        this.lit.setNumChambre(chambre);
        this.litCollection.add(lit);
        this.chambre.setLitCollection(litCollection);

    }

    @Test
    public void saveChambreShouldReturnTrue() {
        entityManager.persist(etage);
        entityManager.persist(etatChambre);
        entityManager.persist(service);
        entityManager.persist(cathegorie);
        chambreRepository.save(chambre);
        assertThat(chambreRepository.findAll().get(0).getLitCollection().size()).isGreaterThan(0);
        assertThat(chambreRepository.findAll().get(0).getCodeCathegorie().getDesignationAr()).isEqualTo("TEST");
    }

}
