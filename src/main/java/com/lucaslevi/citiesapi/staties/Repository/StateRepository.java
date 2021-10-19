package com.lucaslevi.citiesapi.staties.Repository;

import com.lucaslevi.citiesapi.staties.Entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}