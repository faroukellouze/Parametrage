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
package com.csys.parametrage.Service;

import com.csys.parametrage.domain.SecteurActivite;
import com.csys.parametrage.dto.SecteurActiviteDTO;
import com.csys.parametrage.service.SocieteService;
import com.csys.parametrage.service.SecteurActiviteService;
import com.csys.parametrage.repository.SecteurActiviteRepository;
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
 * Tests for {@link SecteurActiviteService}.
 *
 * @author Phillip Webb
 */
public class SecteurActiviteServiceTest {

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    private SecteurActiviteService secteurActiviteService;

    @Mock
    private SocieteService societeService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.secteurActiviteService = new SecteurActiviteService(this.secteurActiviteRepository, societeService);
    }

    @Test
    public void updateSecteurActiviteWhenSecteurActiviteNotExistsShouldThrowExeption() {
        SecteurActiviteDTO secteurdto = new SecteurActiviteDTO();
        secteurdto.setCode(12);
        secteurdto.setDesignation("COMMERCIAL");
        given(this.secteurActiviteRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        secteurActiviteService.update(secteurdto);
    }

    @Test
    public void updateSecteurActiviteWhenSecteurActiviteExistsShouldReturnSecteurActivite() {
        SecteurActivite secteur = new SecteurActivite();
        secteur.setCode(12);
        secteur.setDesignation("CLINIQUE");

        SecteurActiviteDTO secteurdto = new SecteurActiviteDTO();
        secteurdto.setCode(12);
        secteurdto.setDesignation("COMMERCIAL");

        given(this.secteurActiviteRepository.exists(anyInt())).willReturn(true);
        given(this.secteurActiviteRepository.save((SecteurActivite) anyObject())).willReturn(secteur);
        SecteurActivite sec = secteurActiviteService.update(secteurdto);

        assertThat(sec.getDesignation()).isEqualTo("CLINIQUE");

    }

    @Test
    public void deleteSecteurActiviteWhenSecteurActiviteNotExistsShouldThrowExeption(){
        given(this.secteurActiviteRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        secteurActiviteService.delete(12);

    }

    @Test
    public void deleteSecteurActiviteWhenSecteurActiviteExistsShouldReturnTrue() {
        given(this.secteurActiviteRepository.exists(anyInt())).willReturn(true);
        secteurActiviteService.delete(12);

    }

}
