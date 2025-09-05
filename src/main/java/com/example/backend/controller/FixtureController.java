package com.example.backend.controller;


import com.example.backend.model.Fixture;
import com.example.backend.service.FixtureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fixtures")
public class FixtureController {

    private final FixtureService fixtureService;

    public FixtureController(FixtureService fixtureService) {
        this.fixtureService = fixtureService;
    }


    @GetMapping("/")
    public ResponseEntity<String> fixture() {

        var fixtures = fixtureService.callFixturesApi();
        return ResponseEntity.ok(fixtures.toString());
    }

    @GetMapping("/save-august")
    public List<Fixture> addFixtures() {

        return fixtureService.saveAugustFixtures();
    }

}


