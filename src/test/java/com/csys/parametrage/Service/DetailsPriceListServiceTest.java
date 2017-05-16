package com.csys.parametrage.Service;

import com.csys.parametrage.dto.PrixDTO;
import com.csys.parametrage.repository.DetailsPriceListRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.csys.parametrage.service.DetailsPriceListService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Tests for {@link DetailsPriceListService}.
 *
 * @author Hamdi Ghorbel
 */
public class DetailsPriceListServiceTest {

    @Mock
    private DetailsPriceListRepository detailsPriceListRepository;
    
    private DetailsPriceListService prixService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.prixService = new DetailsPriceListService(this.detailsPriceListRepository);
    }

    @Test
    public void getPrixWhenPrixExistsShouldReturnPrix() {
        PrixDTO prixdto = new PrixDTO();
        prixdto.setCodeTypeIntervenant("Clin");
        prixdto.setPrix(new BigDecimal(10));
        prixdto.setTauxCouverture(new BigDecimal(70));
        List<PrixDTO> listPrixdto = new ArrayList<>();
        listPrixdto.add(prixdto);
        given(this.detailsPriceListRepository.calculPrix(244, 1, 1, "001")).willReturn(listPrixdto);
        List<PrixDTO> listPrixdtoNew = prixService.calculPrix(244, 1, 1, "001");
        assertThat(listPrixdtoNew.get(0).getCodeTypeIntervenant()).isEqualTo("Clin");
        assertThat(listPrixdtoNew.get(0).getPrix()).isEqualTo(new BigDecimal(10));
        assertThat(listPrixdtoNew.get(0).getTauxCouverture()).isEqualTo(new BigDecimal(70));
    }
}
