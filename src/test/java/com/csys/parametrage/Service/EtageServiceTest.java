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

import com.csys.parametrage.domain.Chambre;
import com.csys.parametrage.domain.Etage;
import com.csys.parametrage.dto.ChambreDTO;
import com.csys.parametrage.dto.EtageDTO;
import com.csys.parametrage.service.ChambreService;
import com.csys.parametrage.service.EtageService;
import com.csys.parametrage.repository.EtageRepository;
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

/**
 * Tests for {@link EtageService}.
 *
 * @author Phillip Webb
 */
public class EtageServiceTest {

    @Mock
    private EtageRepository etageRepository;

    private EtageService etageService;

    @Mock
    private ChambreService chambreService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.etageService = new EtageService(this.etageRepository, chambreService);
    }

    @Test
    public void updateEtageWhenEtageNotExistsShouldThrowExeption() {
        EtageDTO etagedto = new EtageDTO();
        etagedto.setCode(12);
        etagedto.setDesignation("MATRNITE");
        given(this.etageRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        etageService.update(etagedto);
    }

    @Test
    public void updateEtageWhenEtageExistsShouldReturnTrue() {
        Etage etage = new Etage();
        etage.setCode(12);
        etage.setDesignation("MATRNITE");

        EtageDTO etagedto = new EtageDTO();
        etagedto.setCode(12);
        etagedto.setDesignation("URGENCE");

        given(this.etageRepository.findOne(anyInt())).willReturn(etage);
        Boolean upd = etageService.update(etagedto);
        assertThat(upd).isEqualTo(true);

    }

    @Test
    public void deleteEtageWhenEtageNotExistsShouldThrowExeption() {
        given(this.etageRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        etageService.delete(12);

    }
    
    @Test
    public void deleteEtageWhenEtageMouvmenteShouldThrowExeption() {
        Collection<ChambreDTO> chambre = new ArrayList<>();
        ChambreDTO cha=new ChambreDTO();
        cha.setCode(1);
        chambre.add(cha);
        given(this.etageRepository.exists(anyInt())).willReturn(true);
        given(this.chambreService.findByCodeEtageCode(12)).willReturn(chambre);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceMouvmente");
        etageService.delete(12);

    }
    @Test
    public void deleteEtageWhenEtageExistsShouldReturnTrue() {
        given(this.etageRepository.exists(anyInt())).willReturn(true);
        etageService.delete(12);

    }

}
