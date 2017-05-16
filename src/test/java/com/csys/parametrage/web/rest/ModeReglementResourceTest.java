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

import com.csys.parametrage.domain.ModeReglement;

import com.csys.parametrage.dto.ModeReglementDTO;
import com.csys.parametrage.service.ModeReglementService;
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
 * {@code @SpringBootTest} based tests for {@link ModeReglementResource}.
 *
 * @author Phillip Webb
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ModeReglementResource.class)
public class ModeReglementResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ModeReglementService modeReglemntService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void updateModeReglementShouldReturnModeReglement() throws Exception {
        
        ModeReglement modReg = new ModeReglement();
        modReg.setCode(12);
        modReg.setDesignation("chèque");

        ModeReglementDTO modRegdto = new ModeReglementDTO();
        modRegdto.setCode(12);
        modRegdto.setDesignation("espèce");
        
        given(this.modeReglemntService.update((ModeReglementDTO) anyObject()))
                .willReturn(modReg);
        this.mvc.perform(put("/api/mode-reglements")
                .content(TestUtil.convertObjectToJsonBytes(modRegdto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.designation").value("chèque"));
    }

}
