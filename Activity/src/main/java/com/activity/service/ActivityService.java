package com.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity.repository.ActivityRepository;
import com.activity.repository.FacilityRepository;
import com.activity.repository.PriceRepository;
import com.tourcoreservice.entity.Activity;

@Service
public class ActivityService {

	@Autowired
	private ActivityRepository activityRepository;
	@Autowired
	private PriceRepository priceRepository;
	@Autowired
	private FacilityRepository facilityRepository;

	public List<Activity> listAllActivity() {
		return activityRepository.findAll();
	}

	public Activity getActivityById(long id) {
		return activityRepository.findById(id).get();
	}

	public Activity saveActivity(Activity activity) {
		return activityRepository.save(activity);
	}

	public void deleteActivity(Activity existingactivity) {
		activityRepository.delete(existingactivity);

	}

}
