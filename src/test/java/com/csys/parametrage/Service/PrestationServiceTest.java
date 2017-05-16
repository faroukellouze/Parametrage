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

import com.csys.parametrage.domain.Prestation;
import com.csys.parametrage.dto.ChambreDTO;
import com.csys.parametrage.dto.PrestationDTO;
import com.csys.parametrage.service.ParamService;
import com.csys.parametrage.service.FamillePrestationService;
import com.csys.parametrage.service.PrestationService;
import com.csys.parametrage.repository.PrestationRepository;
import java.util.ArrayList;
import java.util.Collection;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class PrestationServiceTest {

    @Mock
    private PrestationRepository prestationRepository;

    private PrestationService prestationService;

    @Mock
    private FamillePrestationService famillePrestationService;
    
    @Mock
    private ParamService paramService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.prestationService = new PrestationService(this.prestationRepository,famillePrestationService,paramService);
    }

    @Test
    public void updatePrestationWhenPrestationNotExistsShouldThrowExeption() {
        PrestationDTO prestationdto = new PrestationDTO();
        prestationdto.setCode(12);
        prestationdto.setDesignationAr("SEJOUR");
        given(this.prestationRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        prestationService.update(prestationdto);
    }

    @Test
    public void updatePrestationWhenPrestationExistsShouldReturnTrue() {
        Prestation prestation = new Prestation();
        prestation.setCode(12);
        prestation.setDesignationAr("SEJOUR");

        PrestationDTO prestationdto = new PrestationDTO();
        prestationdto.setCode(12);
        prestationdto.setDesignationAr("ACCOMPAGNAT");

        given(this.prestationRepository.findOne(anyInt())).willReturn(prestation);
        Boolean upd = prestationService.update(prestationdto);
        assertThat(upd).isEqualTo(true);

    }

    @Test
    public void deletePrestationWhenPrestationNotExistsShouldThrowExeption() {
        given(this.prestationRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        prestationService.delete(12);

    }
    
    @Test
    public void deletePrestationWhenPrestationExistsShouldReturnTrue() {
        given(this.prestationRepository.exists(anyInt())).willReturn(true);
        prestationService.delete(12);

    }

}
