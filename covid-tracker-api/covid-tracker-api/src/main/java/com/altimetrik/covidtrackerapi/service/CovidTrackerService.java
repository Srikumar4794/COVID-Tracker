package com.altimetrik.covidtrackerapi.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.altimetrik.covidtrackerapi.vo.TrackerVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Data
public class CovidTrackerService {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    private static final String COUNTRY_URL  = "https://covidtracking.com/api/v1/us/current.json";
    private static final String STATE_URL = "https://covidtracking.com/api/v1/states/";

    private RestTemplate getRestTemplate(){
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }

    public TrackerVO getResultsByState(String stateCode){
        RestTemplate restTemplate = getRestTemplate();
        return restTemplate.getForObject(STATE_URL + stateCode + "/current.json", TrackerVO.class);
    }

    public TrackerVO getUSResults(){
        RestTemplate restTemplate = getRestTemplate();
        return restTemplate.getForEntity(COUNTRY_URL, TrackerVO[].class).getBody()[0];
    }


}
