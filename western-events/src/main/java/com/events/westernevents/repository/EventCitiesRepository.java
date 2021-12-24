package com.events.westernevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.events.EventCities;

@Repository
public interface EventCitiesRepository  extends JpaRepository<EventCities, Long>{

}
