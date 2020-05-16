package com.altimetrik.covidtrackerapi.service;

import com.altimetrik.covidtrackerapi.vo.TrackerVO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CovidTrackerServiceTest {

    @Autowired
    private CovidTrackerService covidTrackerService;

    @Test
    @Disabled
    void getResultsByState() {
        assertEquals("", new TrackerVO());
    }

    @Test
    @Disabled
    void getUSResults() {
    }
}