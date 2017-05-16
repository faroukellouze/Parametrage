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

import com.csys.parametrage.domain.ModeReglement;
import com.csys.parametrage.dto.ModeReglementDTO;
import com.csys.parametrage.service.ModeReglementService;
import com.csys.parametrage.service.SocieteService;
import com.csys.parametrage.repository.ModeReglementRepository;
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
 * Tests for {@link ModeReglementService}.
 *
 * @author Phillip Webb
 */
public class ModeReglementServiceTest {

    @Mock
    private ModeReglementRepository modeReglementRepository;

    private ModeReglementService modeReglementService;

    @Mock
    private SocieteService societeService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.modeReglementService = new ModeReglementService(this.modeReglementRepository, societeService);
    }

    @Test
    public void updatModeReglementWhenModeReglementNotExistsShouldThrowExeption() throws IllegalArgumentException {
        given(this.modeReglementRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        ModeReglementDTO modeReglementdto = new ModeReglementDTO();
        modeReglementdto.setCode(12);
        modeReglementService.update(modeReglementdto);

    }

    @Test
    public void updateModeReglementWhenModeReglementeExistsShouldReturnModeReglement() {
        ModeReglement modReg = new ModeReglement();
        modReg.setCode(12);
        modReg.setDesignation("chèque");

        ModeReglementDTO modRegdto = new ModeReglementDTO();
        modRegdto.setCode(12);
        modRegdto.setDesignation("espèce");

        given(this.modeReglementRepository.exists(anyInt())).willReturn(true);
        given(this.modeReglementRepository.save((ModeReglement) anyObject())).willReturn(modReg);
        ModeReglement modRegUpdated = modeReglementService.update(modRegdto);
        assertThat(modRegUpdated.getDesignation()).isEqualTo("chèque");

    }
    
    @Test
    public void deleteModeReglementWhenModeReglementNotExistsShouldThrowExeption() throws IllegalArgumentException {
        given(this.modeReglementRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        modeReglementService.delete(12);
    }

    @Test
    public void deleteModeReglementWhenModeReglementExistsShouldReturnTrue() {
        given(this.modeReglementRepository.exists(anyInt())).willReturn(true);
        modeReglementService.delete(12);

    }

}
