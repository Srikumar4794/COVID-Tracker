package com.altimetrik.covidtrackerapi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackerVO {
    private Long totalTestResults;
    private Long positive;
    private Long negative;
    private Long death;
}
