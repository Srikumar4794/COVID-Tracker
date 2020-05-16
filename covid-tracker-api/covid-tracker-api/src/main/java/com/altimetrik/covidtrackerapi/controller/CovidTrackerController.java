package com.altimetrik.covidtrackerapi.controller;

import com.altimetrik.covidtrackerapi.vo.TrackerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.altimetrik.covidtrackerapi.service.CovidTrackerService;

@RestController
public class CovidTrackerController {
    @Autowired
    private CovidTrackerService covidTrackerService;

    @GetMapping(value = "/api/v1/us")
    public ResponseEntity<TrackerVO> getResultsForUS(){
        TrackerVO usResults = covidTrackerService.getUSResults();
        return new ResponseEntity<>(usResults, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/api/v1/state/{stateCode}")
    public ResponseEntity<TrackerVO> getResultsByState(@PathVariable("stateCode") String stateCode){
        if(stateCode.length() != 2){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        TrackerVO resultsByState = covidTrackerService.getResultsByState(stateCode);

        return new ResponseEntity<>(resultsByState, HttpStatus.ACCEPTED);
    }


}
