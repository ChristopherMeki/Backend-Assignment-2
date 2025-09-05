package com.example.backend.service;

import com.example.backend.model.Fixture;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface FixtureService {


    List<Fixture> saveAugustFixtures();
    // New method
    Object callFixturesApi();
}

