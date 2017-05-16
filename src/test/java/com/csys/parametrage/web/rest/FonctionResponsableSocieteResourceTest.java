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
package com.csys.parametrage.web.rest;

import com.csys.parametrage.domain.FonctionResponsableSociete;
import com.csys.parametrage.dto.FonctionResponsableSocieteDTO;
import com.csys.parametrage.service.FonctionResponsableSocieteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyObject;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * {@code @SpringBootTest} based tests for {@link FonctionResponsableSocieteResource}.
 *
 * @author Phillip Webb
 */
@RunWith(SpringRunner.class)
@WebMvcTest(FonctionResponsableSocieteResource.class)
public class FonctionResponsableSocieteResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FonctionResponsableSocieteService fonctionResponsableSocieteService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void updateFonctionResponsableSocieteShouldReturnFonctionResponsableSociete() throws Exception {
        FonctionResponsableSociete fnct = new FonctionResponsableSociete();
        fnct.setCode(12);
        fnct.setDesignation("MANEGER");

        FonctionResponsableSocieteDTO fnctdto = new FonctionResponsableSocieteDTO();
        fnctdto.setCode(12);
        fnctdto.setDesignation("CHEF GRH");
        
        given(this.fonctionResponsableSocieteService.update((FonctionResponsableSocieteDTO) anyObject()))
                .willReturn(fnct);
        this.mvc.perform(put("/api/fonction-responsable-societes")
                .content(TestUtil.convertObjectToJsonBytes(fnctdto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.designation").value("MANEGER"));
    }

}
