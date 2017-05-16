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

import com.csys.parametrage.domain.SousFamillePrestation;
import com.csys.parametrage.dto.PrestationDTO;
import com.csys.parametrage.dto.SousFamillePrestationDTO;
import com.csys.parametrage.service.SousFamillePrestationService;
import com.csys.parametrage.service.PrestationService;
import com.csys.parametrage.repository.SousFamillePrestationRepository;
import java.util.ArrayList;
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
public class SousFamillePrestationServiceTest {

    @Mock
    private SousFamillePrestationRepository sousFamillePrestationRepository;

    private SousFamillePrestationService sousFamillePrestationService;

    @Mock
    private PrestationService prestationService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.sousFamillePrestationService = new SousFamillePrestationService(this.sousFamillePrestationRepository, prestationService);
    }

    @Test
    public void updateSousFamillePrestationWhenSousFamillePrestationNotExistsShouldThrowExeption() {
        SousFamillePrestationDTO famillePrestationdto = new SousFamillePrestationDTO();
        famillePrestationdto.setCode(12);
        famillePrestationdto.setDesignationAr("SCANNER");
        given(this.sousFamillePrestationRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        sousFamillePrestationService.update(famillePrestationdto);
    }

//    @Test
//    public void updateSousFamillePrestationWhenSousFamillePrestationExistsShouldReturnTrue() {
//        SousFamillePrestation sousfamillePrestation = new SousFamillePrestation();
//        sousfamillePrestation.setCode(12);
//        sousfamillePrestation.setDesignationAr("SCANNER");
//
//        SousFamillePrestationDTO sousfamillePrestationdto = new SousFamillePrestationDTO();
//        sousfamillePrestationdto.setCode(12);
//        sousfamillePrestationdto.setDesignationAr("IRM");
//
//        given(this.sousFamillePrestationRepository.findOne(anyInt())).willReturn(sousfamillePrestation);
//        Boolean upd = sousFamillePrestationService.update(sousfamillePrestationdto);
//        assertThat(upd).isEqualTo(true);
//
//    }

    @Test
    public void deleteSousFamillePrestationWhenSousFamillePrestationNotExistsShouldThrowExeption() {
        given(this.sousFamillePrestationRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        sousFamillePrestationService.delete(12);

    }
    
//    @Test
//    public void deleteSousFamillePrestationWhenSousFamillePrestationMouvmenteShouldThrowExeption() {
//        List<PrestationDTO> prestation = new ArrayList<>();
//        PrestationDTO prest=new PrestationDTO();
//        prest.setCode(1);
//        prestation.add(prest);
//        given(this.sousFamillePrestationRepository.exists(anyInt())).willReturn(true);
//        given(this.prestationService.findByCodeSousFamilleCode(12)).willReturn(prestation);
//        this.thrown.expect(IllegalArgumentException.class);
//        this.thrown.expectMessage("error.ressourceMouvmente");
//        sousFamillePrestationService.delete(12);
//
//    }
    @Test
    public void deleteSousFamillePrestationWhenSousFamillePrestationExistsShouldReturnTrue() {
        given(this.sousFamillePrestationRepository.exists(anyInt())).willReturn(true);
        sousFamillePrestationService.delete(12);

    }
}
