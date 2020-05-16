package com.altimetrik.covidtrackerapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CovidTrackerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getResultsByState() throws Exception {
        this.mockMvc.perform(get("/api/v1/state/MI"))
                .andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.positive").exists())
                .andExpect(jsonPath("$.negative").exists())
                .andExpect(jsonPath("$.death").exists())
                .andExpect(jsonPath("$.totalTestResults").exists());

        this.mockMvc.perform(get("/api/v1/state/M"))
                .andExpect(status().isBadRequest());
    }
}