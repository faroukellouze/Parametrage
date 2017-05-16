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

import com.csys.parametrage.domain.Banque;
import com.csys.parametrage.dto.BanqueDTO;
import com.csys.parametrage.service.SocieteService;
import com.csys.parametrage.service.BanqueService;
import com.csys.parametrage.repository.BanqueRepository;
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
 * Tests for {@link BanqueService}.
 *
 * @author Phillip Webb
 */
public class BanqueServiceTest {

    @Mock
    private BanqueRepository repository;

    private BanqueService banqueService;

    @Mock
    private SocieteService societeService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.banqueService = new BanqueService(this.repository, this.societeService);
    }

    @Test
    public void updateBanqueWhenBanqueNotExistsShouldThrowExeption() {
        given(this.repository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        BanqueDTO banquedto = new BanqueDTO();
        banquedto.setCode(12);
        banqueService.update(banquedto);
    }

    @Test
    public void updateBanqueWhenBanqueExistsShouldReturnBanque() {
        Banque banque = new Banque();
        banque.setCode(12);
        banque.setDesignation("Amen");
        BanqueDTO banquedto = new BanqueDTO();
        banquedto.setCode(12);
        banquedto.setDesignation("Biat");
        given(this.repository.exists(anyInt())).willReturn(true);
        given(this.repository.save((Banque) anyObject())).willReturn(banque);
        Banque ban = banqueService.update(banquedto);
        assertThat(ban.getDesignation()).isEqualTo("Amen");
    }

    @Test
    public void deleteBanqueWhenBanqueNotExistsShouldThrowExeption() {
        given(this.repository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        banqueService.delete(12);
    }

    @Test
    public void deleteBanqueWhenBanqueExistsShouldReturnTrue() {
        given(this.repository.exists(anyInt())).willReturn(true);
        banqueService.delete(12);
    }

}
