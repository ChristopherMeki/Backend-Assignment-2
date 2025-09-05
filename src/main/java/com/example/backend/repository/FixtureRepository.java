package com.example.backend.repository;

import com.example.backend.model.Fixture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixtureRepository extends JpaRepository<Fixture, Long> {
}