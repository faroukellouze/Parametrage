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

import com.csys.parametrage.repository.PrestationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.csys.parametrage.domain.Prestation;
import com.csys.parametrage.domain.FamilleFacturation;
import com.csys.parametrage.domain.SousFamillePrestation;
import com.csys.parametrage.domain.Tva;
import com.csys.parametrage.domain.TypePrestation;
import com.csys.parametrage.domain.FamillePrestation;
import java.util.Date;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
public class PrestaionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PrestationRepository prestationRepository;
    private Prestation prestation;
    private FamilleFacturation familleFacturation;
    private SousFamillePrestation sousFamillePrestation;
    private Tva tva;
    private TypePrestation typePrestation;
    private FamillePrestation famillePrestation;

    @Before
    public void setup() {

        this.familleFacturation = new FamilleFacturation();
        this.familleFacturation.setDesignationAr("familleFacturation");
        this.familleFacturation.setActif(true);
        this.familleFacturation.setDateCreation(new Date());
        this.familleFacturation.setDesignationFr("familleFacturation");
        this.familleFacturation.setDesignationEn("familleFacturation");
        this.familleFacturation.setMemo("familleFacturation");
        this.familleFacturation.setUserCreation("ADMIN");
        this.familleFacturation.setCodeFamilleSaisie("0001");

        this.tva = new Tva();
        this.tva.setTva("6");
        this.tva.setDateCreation(new Date());
        this.tva.setUserCreation("ADMIN");
        this.tva.setActif(true);
        this.tva.setNumCompteComptable("123456");

        this.typePrestation = new TypePrestation();
        this.typePrestation.setDesignation("TEST");
        typePrestation.setDateCreation(new Date());
        typePrestation.setUserCreation("ADMIN");
        typePrestation.setActif(true);

        this.famillePrestation = new FamillePrestation();
        famillePrestation.setActif(true);
        famillePrestation.setDateCreation(new Date());
        famillePrestation.setDesignationAr("TEST");
        famillePrestation.setDesignationEn("TEST");
        famillePrestation.setDesignationFr("TEST");
        famillePrestation.setPrefixe("P");
        famillePrestation.setSuffixe(1);
        famillePrestation.setUserCreation("ADMIN");
        famillePrestation.setCodeTypePrestation(typePrestation);

        this.sousFamillePrestation = new SousFamillePrestation();
        this.sousFamillePrestation.setDesignation("TEST");
        this.sousFamillePrestation.setDesignationAr("TEST");
        this.sousFamillePrestation.setActif(true);
        this.sousFamillePrestation.setDateCreation(new Date());
        this.sousFamillePrestation.setUserCreation("ADMIN");
        sousFamillePrestation.setCodeFamille(famillePrestation);

        this.prestation = new Prestation();
        this.prestation.setActif(true);
        this.prestation.setAutorisModifierPrix(true);
        this.prestation.setCodeBeneficiere(0);
        this.prestation.setCodeFamilleFacturation(familleFacturation);
        this.prestation.setCodeSaisie("0001");
        this.prestation.setCodeSousFamille(sousFamillePrestation);
        this.prestation.setCodeTypePrestation(typePrestation);
        this.prestation.setCompteRendu(true);
        this.prestation.setDateCreate(new Date());
        this.prestation.setDemandeObligatoire(true);
        this.prestation.setDesignationAr("TEST");
        this.prestation.setDesignationEn("TEST");
        this.prestation.setDesignationFr("TEST");
        this.prestation.setEtage(true);
        this.prestation.setFacturation(true);
        this.prestation.setSousTraitance(true);
        this.prestation.setTva(tva);
        this.prestation.setUserCreate("ADMIN");

    }

    @Test
    public void savePrestationShouldReturnTrue() {
        entityManager.persist(familleFacturation);
        entityManager.persist(tva);
        entityManager.persist(typePrestation);
        entityManager.persist(famillePrestation);
        entityManager.persist(sousFamillePrestation);
        prestationRepository.save(prestation);
        assertThat(prestation.getDesignationAr()).isEqualTo("TEST");
        assertThat(prestation.getCodeSousFamille().getDesignation()).isEqualTo("TEST");
    }

}
