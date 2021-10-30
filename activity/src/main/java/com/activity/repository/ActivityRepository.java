package com.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Activity;
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
