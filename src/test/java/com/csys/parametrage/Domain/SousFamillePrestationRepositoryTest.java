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

import com.csys.parametrage.domain.TypePrestation;
import com.csys.parametrage.domain.SousFamillePrestation;
import com.csys.parametrage.domain.FamillePrestation;
import com.csys.parametrage.repository.BanqueRepository;
import com.csys.parametrage.repository.SousFamillePrestationRepository;
import java.util.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Before;

/**
 * Tests for {@link BanqueRepository}.
 *
 * @author Phillip Webb
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
public class SousFamillePrestationRepositoryTest {

   @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SousFamillePrestationRepository sousfamillePrestationRepository;
    private TypePrestation typePrestation;
    private FamillePrestation famillePrestation;
    private SousFamillePrestation sousFamillePrestation;

    @Before
    public void setup() {

        this.typePrestation = new com.csys.parametrage.domain.TypePrestation();
        this.typePrestation.setDesignation("TEST");
        this.typePrestation.setDateCreation(new Date());
        this.typePrestation.setUserCreation("ADMIN");
        this.typePrestation.setActif(true);

        this.famillePrestation = new com.csys.parametrage.domain.FamillePrestation();
        this.famillePrestation.setActif(true);
        this.famillePrestation.setDateCreation(new Date());
        this.famillePrestation.setDesignationAr("TEST");
        this.famillePrestation.setDesignationEn("TEST");
        this.famillePrestation.setDesignationFr("TEST");
        this.famillePrestation.setPrefixe("P");
        this.famillePrestation.setSuffixe(1);
        this.famillePrestation.setUserCreation("ADMIN");
        this.famillePrestation.setCodeTypePrestation(typePrestation);
        
        this.sousFamillePrestation = new SousFamillePrestation();
        this.sousFamillePrestation.setDesignation("TEST");
        this.sousFamillePrestation.setDesignationAr("TEST");
        this.sousFamillePrestation.setActif(true);
        this.sousFamillePrestation.setDateCreation(new Date());
        this.sousFamillePrestation.setUserCreation("ADMIN");
        sousFamillePrestation.setCodeFamille(famillePrestation);
       
    }

    @Test
    public void saveSousFamillePrestationShouldReturnTrue() {
        entityManager.persist(this.typePrestation);
        entityManager.persist(this.famillePrestation);
        sousfamillePrestationRepository.save(this.sousFamillePrestation);
        assertThat(this.sousFamillePrestation.getDesignationAr()).isEqualTo("TEST");
        assertThat(this.sousFamillePrestation.getCodeFamille().getDesignationAr()).isEqualTo("TEST");
    }

}
