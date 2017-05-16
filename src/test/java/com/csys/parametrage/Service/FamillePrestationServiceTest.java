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

import com.csys.parametrage.domain.FamillePrestation;
import com.csys.parametrage.dto.FamillePrestationDTO;
import com.csys.parametrage.dto.SousFamillePrestationDTO;
import com.csys.parametrage.service.SousFamillePrestationService;
import com.csys.parametrage.service.FamillePrestationService;
import com.csys.parametrage.repository.FamillePrestationRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Tests for {@link FamillePrestationService}.
 *
 * @author Phillip Webb
 */
public class FamillePrestationServiceTest {

    @Mock
    private FamillePrestationRepository famillePrestationRepository;

    private FamillePrestationService famillePrestationService;

    @Mock
    private SousFamillePrestationService sousFamillePrestationService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.famillePrestationService = new FamillePrestationService(this.famillePrestationRepository, sousFamillePrestationService);
    }

    @Test
    public void updateFamillePrestationWhenFamillePrestationNotExistsShouldThrowExeption() {
        FamillePrestationDTO famillePrestationdto = new FamillePrestationDTO();
        famillePrestationdto.setCode(12);
        famillePrestationdto.setDesignationAr("LABORATOIRE");
        given(this.famillePrestationRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        famillePrestationService.update(famillePrestationdto);
    }

    @Test
    public void updateFamillePrestationWhenFamillePrestationExistsShouldReturnTrue() {
        FamillePrestation famillePrestation = new FamillePrestation();
        famillePrestation.setCode(12);
        famillePrestation.setDesignationAr("LABORATOIRE");

        FamillePrestationDTO famillePrestationdto = new FamillePrestationDTO();
        famillePrestationdto.setCode(12);
        famillePrestationdto.setDesignationAr("RADIOLOGIE");

        given(this.famillePrestationRepository.findOne(anyInt())).willReturn(famillePrestation);
        Boolean upd = famillePrestationService.update(famillePrestationdto);
        assertThat(upd).isEqualTo(true);

    }

    @Test
    public void deleteFamillePrestationWhenFamillePrestationNotExistsShouldThrowExeption() {
        given(this.famillePrestationRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        famillePrestationService.delete(12);

    }
    
    @Test
    public void deleteFamillePrestationWhenFamillePrestationMouvmenteShouldThrowExeption() {
        List<SousFamillePrestationDTO> sousFamille = new ArrayList<>();
        SousFamillePrestationDTO souFm=new SousFamillePrestationDTO();
        souFm.setCode(1);
        sousFamille.add(souFm);
        given(this.famillePrestationRepository.exists(anyInt())).willReturn(true);
        given(this.sousFamillePrestationService.findByCodeFamilleCode(12)).willReturn(sousFamille);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceMouvmente");
        famillePrestationService.delete(12);

    }
    @Test
    public void deleteFamillePrestationWhenFamillePrestationExistsShouldReturnTrue() {
        given(this.famillePrestationRepository.exists(anyInt())).willReturn(true);
        famillePrestationService.delete(12);

    }

}
