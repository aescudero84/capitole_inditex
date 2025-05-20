package com.aescudero.capitole_inditex.adapter.in.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @CsvSource({
            "2020-06-14T10:00, 35.50",
            "2020-06-14T16:00, 25.45",
            "2020-06-14T21:00, 35.50",
            "2020-06-15T10:00, 30.50",
            "2020-06-16T21:00, 38.95"
    })
    void testCases1to5(String applicationDateStr, String expectedPrice) throws Exception {
        String brandId = "1";
        String productId = "35455";
        String applicationDate = LocalDateTime.parse(applicationDateStr).toString();

        mockMvc.perform(get("/api/prices/find")
                        .param("brandId", brandId)
                        .param("productId", productId)
                        .param("applicationDate", applicationDate)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(expectedPrice));
    }

    @Test
    void shouldReturn404WhenPriceNotFound() throws Exception {
        mockMvc.perform(get("/api/prices/find")
                        .param("brandId", "999")
                        .param("productId", "999")
                        .param("applicationDate", LocalDateTime.now().toString()))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturn400WhenNoBrandIdInRequest() throws Exception {
        mockMvc.perform(get("/api/prices/find")
                        .param("productId", "1")
                        .param("applicationDate", LocalDateTime.now().toString()))
                .andExpect(status().isBadRequest());
    }
}
