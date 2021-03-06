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

import com.csys.parametrage.domain.Banque;
import com.csys.parametrage.dto.BanqueDTO;
import com.csys.parametrage.service.BanqueService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * {@code @SpringBootTest} based tests for {@link UserVehicleController}.
 *
 * @author Phillip Webb
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BanqueResource.class)
public class BanqueResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BanqueService banqueService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void saveBanqueShouldReturnBanque() throws Exception   {
        Banque banque = new Banque();
        banque.setCode(12);
        banque.setDesignation("Biat");
        
        BanqueDTO banquedto = new BanqueDTO();
        banquedto.setDesignation("Biat");
        
        given(this.banqueService.save((BanqueDTO) anyObject()))
                .willReturn(banque);
        this.mvc.perform(post("/api/banques")
                .content(TestUtil.convertObjectToJsonBytes(banquedto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.designation").value("Biat"));
    }

}
