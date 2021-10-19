package com.lucaslevi.citiesapi.states.Repository;

import com.lucaslevi.citiesapi.states.Entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}