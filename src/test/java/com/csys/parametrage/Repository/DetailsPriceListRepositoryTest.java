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
package com.csys.parametrage.Repository;

import com.csys.parametrage.repository.DetailsPriceListRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.csys.parametrage.domain.DetailsPriceList;
import com.csys.parametrage.domain.DetailsCouverture;
import com.csys.parametrage.domain.DetailsCouverturePK;
import com.csys.parametrage.domain.DetailsPriceListPK;
import com.csys.parametrage.dto.PrixDTO;
import java.math.BigDecimal;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests for {@link DetailsPriceListRepository}.
 *
 * @author Hamdi Ghorbel
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
public class DetailsPriceListRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DetailsPriceListRepository detailsPriceListRepository;

    @Test
    public void calculPrixShouldReturnPrixDTO() throws Exception {
        DetailsCouverture detailsCouverture = new DetailsCouverture(new DetailsCouverturePK(1, 244), new BigDecimal(70), false, false);
        DetailsPriceList detailsPriceList = new DetailsPriceList(new DetailsPriceListPK(244, "Clin", "001", 1), "Clin", new BigDecimal(15), false, false, new BigDecimal(15),"a");
        this.entityManager.persist(detailsCouverture);
        this.entityManager.persist(detailsPriceList);
        List<PrixDTO> prixdto = this.detailsPriceListRepository.calculPrix(244,1,1,"001");
        assertThat(prixdto.get(0).getPrix().stripTrailingZeros()).isEqualTo(new BigDecimal(15).stripTrailingZeros());
        assertThat(prixdto.get(0).getTauxCouverture().stripTrailingZeros()).isEqualTo(new BigDecimal(70).stripTrailingZeros());
        assertThat(prixdto.get(0).getCodeTypeIntervenant()).isEqualTo("Clin");
    }
}
