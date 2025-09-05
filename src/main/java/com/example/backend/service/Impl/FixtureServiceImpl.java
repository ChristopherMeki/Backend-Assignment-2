package com.example.backend.service.Impl;

import com.example.backend.model.Fixture;
import com.example.backend.repository.FixtureRepository;
import com.example.backend.service.FixtureService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FixtureServiceImpl implements FixtureService {

    private final FixtureRepository fixtureRepository;
    private final RestTemplate restTemplate;

    public FixtureServiceImpl(FixtureRepository fixtureRepository, RestTemplate restTemplate) {
        this.fixtureRepository = fixtureRepository;
        this.restTemplate = restTemplate;
    }


    @Override
    public String callFixturesApi() {
        String url = "https://fantasy.premierleague.com/api/fixtures";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody(); // return raw JSON string
    }

    @Override
    public List<Fixture> saveAugustFixtures() {
        try {

            String json = callFixturesApi();


            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule()); // handle ZonedDateTime
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            List<Fixture> fixtures = Arrays.asList(
                    mapper.readValue(json, Fixture[].class)
            );


            return fixtures.stream()
                    .filter(f -> f.getKickoffTime() != null && f.getKickoffTime().getMonthValue() == 8)
                    .map(f -> new Fixture(null, f.getCode(), f.getKickoffTime()))
                    .map(fixtureRepository::save)
                    .toList();

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse fixtures JSON", e);
        }
    }



}