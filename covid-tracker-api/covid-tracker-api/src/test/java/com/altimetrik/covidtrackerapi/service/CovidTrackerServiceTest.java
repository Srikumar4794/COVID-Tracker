package com.altimetrik.covidtrackerapi.service;

import com.altimetrik.covidtrackerapi.vo.TrackerVO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CovidTrackerServiceTest {

    @Autowired
    private CovidTrackerService covidTrackerService;

    @Test
    void getResultsByState() {
       assertThrows(HttpClientErrorException.class, () -> covidTrackerService.getResultsByState("ZZ"));
    }

    @Test
    @Disabled
    void getUSResults() {
    }
}