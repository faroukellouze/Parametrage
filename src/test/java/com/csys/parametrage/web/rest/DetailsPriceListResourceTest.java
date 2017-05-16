package com.csys.parametrage.web.rest;

import com.csys.parametrage.dto.PrixDTO;
import com.csys.parametrage.service.DetailsPriceListService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * tests for DetailsPriceListResource.
 *
 * @author Hamdi Ghorbel
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DetailsPriceListResource.class)
public class DetailsPriceListResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DetailsPriceListService prixService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getCalculShouldReturnListPrixDTO() throws Exception   {
        List<PrixDTO> prixdto = new ArrayList<>();
        prixdto.add(new PrixDTO(new BigDecimal(10), new BigDecimal(70), "Clin"));
        given(this.prixService.calculPrix(anyInt(),anyInt(),anyInt(),anyString())).willReturn(prixdto);
        this.mvc.perform(get("/api/prix").param("CodePrestation","244").param("CodeListeCouverture","1").param("CodePriceList","1").param("CodeNatureAdmission","001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].prix").value(new BigDecimal(10)))
                .andExpect(jsonPath("$[0].tauxCouverture").value(new BigDecimal(70)))
                .andExpect(jsonPath("$[0].codeTypeIntervenant").value("Clin"));
    }

}
