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

import com.csys.parametrage.domain.FonctionResponsableSociete;
import com.csys.parametrage.dto.FonctionResponsableSocieteDTO;
import com.csys.parametrage.service.ResponsableSocieteService;
import com.csys.parametrage.service.FonctionResponsableSocieteService;
import com.csys.parametrage.repository.FonctionResponsableSocieteRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link FonctionResponsableSocieteService}.
 *
 * @author Phillip Webb
 */
public class FonctionResponsableSocieteServiceTest {

    @Mock
    private FonctionResponsableSocieteRepository fonctionResponsableSocieteRepository;

    private FonctionResponsableSocieteService fonctionResponsableSocieteService;

    @Mock
    private  ResponsableSocieteService responsableSocieteService;
    
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.fonctionResponsableSocieteService = new FonctionResponsableSocieteService(this.fonctionResponsableSocieteRepository,responsableSocieteService);
    }

    @Test
    public void updateFonctionResponsableSocieteWhenFonctionResponsableSocieteNotExistsShouldThrowExeption() {
        given(this.fonctionResponsableSocieteRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        FonctionResponsableSocieteDTO fnctdto = new FonctionResponsableSocieteDTO();
        fnctdto.setCode(12);
        fonctionResponsableSocieteService.update(fnctdto);

    }

    @Test
    public void updateFonctionResponsableSocieteWhenFonctionResponsableSocieteExistsShouldReturnFonctionResponsableSociete() {
        FonctionResponsableSociete fnct = new FonctionResponsableSociete();
        fnct.setCode(12);
        fnct.setDesignation("MANEGER");

        FonctionResponsableSocieteDTO fnctdto = new FonctionResponsableSocieteDTO();
        fnctdto.setCode(12);
        fnctdto.setDesignation("CHEF GRH");

        given(this.fonctionResponsableSocieteRepository.exists(anyInt())).willReturn(true);
        given(this.fonctionResponsableSocieteRepository.save((FonctionResponsableSociete) anyObject())).willReturn(fnct);
        FonctionResponsableSociete fnctUpdated = fonctionResponsableSocieteService.update(fnctdto);
        assertThat(fnctUpdated.getDesignation()).isEqualTo("MANEGER");

    }

    @Test
    public void deleteFonctionResponsableSocieteWhenFonctionResponsableSocieteNotExistsShouldThrowExeption() {
        given(this.fonctionResponsableSocieteRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        fonctionResponsableSocieteService.delete(12);

    }

    @Test
    public void deleteFonctionResponsableSocieteWhenFonctionResponsableSocieteExistsShouldReturnTrue() {
        given(this.fonctionResponsableSocieteRepository.exists(anyInt())).willReturn(true);
        fonctionResponsableSocieteService.delete(12);
    }

}
