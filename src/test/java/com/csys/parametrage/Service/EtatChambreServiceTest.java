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
import com.csys.parametrage.domain.EtatChambre;
import com.csys.parametrage.dto.ChambreDTO;
import com.csys.parametrage.dto.EtatChambreDTO;
import com.csys.parametrage.service.ChambreService;
import com.csys.parametrage.service.EtatChambreService;
import com.csys.parametrage.repository.EtatChambreRepository;
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
 * Tests for {@link EtatChambreService}.
 *
 * @author Phillip Webb
 */
public class EtatChambreServiceTest {

    @Mock
    private EtatChambreRepository etatChambreRepository;

    private EtatChambreService etatChambreService;

    @Mock
    private ChambreService chambreService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.etatChambreService = new EtatChambreService(this.etatChambreRepository, chambreService);
    }

    @Test
    public void updateEtatChambreWhenEtatChambreNotExistsShouldThrowExeption() {
        EtatChambreDTO etatChambredto = new EtatChambreDTO();
        etatChambredto.setCode(12);
        etatChambredto.setDesignation("LIBRE");
        given(this.etatChambreRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        etatChambreService.update(etatChambredto);
    }

    @Test
    public void updateEtatChambreWhenEtatChambreExistsShouldReturnTrue() {
        EtatChambre etatChambre = new EtatChambre();
        etatChambre.setCode(12);
        etatChambre.setDesignation("LIBRE");

        EtatChambreDTO etatChambredto = new EtatChambreDTO();
        etatChambredto.setCode(12);
        etatChambredto.setDesignation("OCCUPEE");

        given(this.etatChambreRepository.findOne(anyInt())).willReturn(etatChambre);
        Boolean upd = etatChambreService.update(etatChambredto);
        assertThat(upd).isEqualTo(true);

    }

    @Test
    public void deleteEtatChambreWhenEtatChambreNotExistsShouldThrowExeption() {
        given(this.etatChambreRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        etatChambreService.delete(12);

    }
    
    @Test
    public void deleteEtatChambreWhenEtatChambreMouvmenteShouldThrowExeption() {
        Collection<ChambreDTO> chambre = new ArrayList<>();
        ChambreDTO cha=new ChambreDTO();
        cha.setCode(1);
        chambre.add(cha);
        given(this.etatChambreRepository.exists(anyInt())).willReturn(true);
        given(this.chambreService.findByEtatChambreCode(12)).willReturn(chambre);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceMouvmente");
        etatChambreService.delete(12);

    }
    @Test
    public void deleteEtatChambreWhenEtatChambreExistsShouldReturnTrue() {
        given(this.etatChambreRepository.exists(anyInt())).willReturn(true);
        etatChambreService.delete(12);

    }

}
