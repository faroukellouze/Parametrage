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

import com.csys.parametrage.domain.TypeContacte;
import com.csys.parametrage.dto.TypeContacteDTO;
import com.csys.parametrage.repository.TypeContacteRepository;
import com.csys.parametrage.service.TypeContacteService;
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
 * Tests for {@link TypeContacteService}.
 *
 * @author Phillip Webb
 */
public class TypeContacteServiceTest {

    @Mock
    private TypeContacteRepository typeContacteRepository;

    private TypeContacteService typeContacteService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.typeContacteService = new TypeContacteService(this.typeContacteRepository);
    }

    @Test
    public void updatTypeContacteWhenTypeContacteNotExistsShouldThrowExeption() {
        given(this.typeContacteRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        TypeContacteDTO typeContacteDTO = new TypeContacteDTO();
        typeContacteDTO.setCode(12);
        typeContacteService.update(typeContacteDTO);

    }

    @Test
    public void updateTypeContacteWhenTypeContacteExistsShouldReturnTypeContacte() {
       TypeContacte type = new TypeContacte();
        type.setCode(12);
        type.setDesignation("Tel");

        TypeContacteDTO typedto = new TypeContacteDTO();
        typedto.setCode(12);
        typedto.setDesignation("Fax");

        given(this.typeContacteRepository.exists(anyInt())).willReturn(true);
        given(this.typeContacteRepository.save((TypeContacte) anyObject())).willReturn(type);
        TypeContacte typeupdated = typeContacteService.update(typedto);
        assertThat(typeupdated.getDesignation()).isEqualTo("Tel");

    }

    @Test
    public void deleteTypeContacteWhenTypeContacteNotExistsShouldThrowExeption() {
        given(this.typeContacteRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        typeContacteService.delete(12);
    }

    @Test
    public void deleteTypeContacteWhenTypeContacteExistsShouldReturnTrue() {
        given(this.typeContacteRepository.exists(anyInt())).willReturn(true);
        typeContacteService.delete(12);

    }

}
