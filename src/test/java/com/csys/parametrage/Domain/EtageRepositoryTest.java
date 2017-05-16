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

import com.csys.parametrage.domain.Etage;
import com.csys.parametrage.repository.EtageRepository;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link BanqueRepository}.
 *
 * @author Phillip Webb
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
public class EtageRepositoryTest {

    @Autowired
    private EtageRepository etageRepository;

    @Test
    public void saveEtageShouldReturnTrue() {
        Etage etage = new Etage();
        etage.setDesignation("MATRNITE");
        etage.setDesignationAr("MATRNITE");
        etage.setActif(true);
        etage.setUserCreation("ADMIN");
        etage.setDateCreation(new Date());
        
        this.etageRepository.save(etage);
        Etage etageMater = this.etageRepository.findAll().get(0);
        assertThat(etageMater.getDesignation()).isEqualTo("MATRNITE");

    }

}
