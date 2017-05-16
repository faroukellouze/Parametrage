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

import com.csys.parametrage.domain.TypePieceJointeBordereau;
import com.csys.parametrage.dto.TypePieceJointeBordereauDTO;
import com.csys.parametrage.service.TypePieceJointeBordereauService;
import com.csys.parametrage.service.PieceJointBordereauService;
import com.csys.parametrage.repository.TypePieceJointeBordereauRepository;
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
 * Tests for {@link TypePieceJointeBordereauService}.
 *
 * @author Phillip Webb
 */
public class TypePieceJointeBordereauServiceTest {

    @Mock
    private TypePieceJointeBordereauRepository typePieceJointeBordereauRepository;

    private TypePieceJointeBordereauService typePieceJointeBordereauService;
    
    private  PieceJointBordereauService pieceJointBordereauService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.typePieceJointeBordereauService = new TypePieceJointeBordereauService(this.typePieceJointeBordereauRepository,pieceJointBordereauService);
    }

    @Test
    public void updatTypePieceJointeBordereauRepositoryWhenNotExistsShouldThrowExeption() throws IllegalArgumentException {
        given(this.typePieceJointeBordereauRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        TypePieceJointeBordereauDTO modeReglementdto = new TypePieceJointeBordereauDTO();
        modeReglementdto.setCode(12);
        typePieceJointeBordereauService.update(modeReglementdto);
    }

    @Test
    public void updateTypePieceJointeBordereauRepositoryWhenExistsShouldReturnModeReglement() {
        TypePieceJointeBordereau type = new TypePieceJointeBordereau();
        type.setCode(12);
        type.setDesignation("CIN");

        TypePieceJointeBordereauDTO typedto = new TypePieceJointeBordereauDTO();
        typedto.setCode(12);
        typedto.setDesignation("CARTE PEC");

        given(this.typePieceJointeBordereauRepository.exists(anyInt())).willReturn(true);
        given(this.typePieceJointeBordereauRepository.save((TypePieceJointeBordereau) anyObject())).willReturn(type);
        TypePieceJointeBordereau typePiece = typePieceJointeBordereauService.update(typedto);
        assertThat(typePiece.getDesignation()).isEqualTo("CIN");

    }

    @Test
    public void deleteTypePieceJointeBordereauRepositoryWhenNotExistsShouldThrowExeption() throws IllegalArgumentException {
        given(this.typePieceJointeBordereauRepository.exists(anyInt())).willReturn(false);
        this.thrown.expect(IllegalArgumentException.class);
        this.thrown.expectMessage("error.ressourceNotFound");
        typePieceJointeBordereauService.delete(12);
    }

//    @Test
//    public void deleteTypePieceJointeBordereauRepositoryWhenExistsShouldReturnTrue() {
//        given(this.typePieceJointeBordereauRepository.exists(anyInt())).willReturn(true);
//        typePieceJointeBordereauService.delete(12);
//
//    }

}
