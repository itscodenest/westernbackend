package com.activity.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.activity.service.ActivityService;
import com.tourcoreservice.activity.pojo.ActivityPojo;
import com.tourcoreservice.activity.pojo.ActivityUpdatePojo;
import com.tourcoreservice.activity.response.ActivityIdResponse;
import com.tourcoreservice.activity.response.ActivityListResponse;
import com.tourcoreservice.activity.response.ActivityResponse;
import com.tourcoreservice.entity.Activity;
import com.tourcoreservice.entity.Facility;
import com.tourcoreservice.entity.Place;
import com.tourcoreservice.entity.Price;
import com.tourcoreservice.entity.Theme;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class ActivityFacade {

	@Autowired
	ActivityService activityService;

	public ActivityListResponse listallActivity() {
		ActivityListResponse activityListResponse = new ActivityListResponse();
		List<Activity> activity = activityService.listAllActivity();
		List<ActivityPojo> activityPojo = ObjectMapperUtils.mapAll(activity, ActivityPojo.class);
		activityListResponse.setActivityPojo(activityPojo);
		return activityListResponse;
	}

	public ActivityResponse getActivity(long id) {
		ActivityResponse activityResponse = new ActivityResponse();
		Activity activity = activityService.getActivityById(id);
		ActivityPojo activityPojo = ObjectMapperUtils.map(activity, ActivityPojo.class);
		activityResponse.setActivityPojo(activityPojo);
		return activityResponse;

	}

	public ActivityIdResponse saveActivityMainDetails(ActivityPojo activityPojo) {
		ActivityIdResponse activityIdResponse = new ActivityIdResponse();
		Activity activity = ObjectMapperUtils.map(activityPojo, Activity.class);
		activity = activityService.saveActivity(activity);
		activityPojo = ObjectMapperUtils.map(activity, ActivityPojo.class);
		activityIdResponse.setActivityId(activityPojo.getId());
		return activityIdResponse;
	}

	public ActivityResponse updateActivity(ActivityUpdatePojo activityUpdatePojo) {
		ActivityResponse activityResponse = new ActivityResponse();
		Activity existingactivity = activityService.getActivityById(activityUpdatePojo.getId());
		Facility facility = existingactivity.getFacility();
		Theme theme = existingactivity.getTheme();
		ifTheameExists(existingactivity, theme);
		Place place = existingactivity.getPlace();
		ifPlaceExist(existingactivity, place);
		Price price = existingactivity.getPrice();
		existingactivity.setPrice(price);
		existingactivity.setFacility(facility);
		ObjectMapperUtils.map(activityUpdatePojo, existingactivity);
		Activity activity = activityService.saveActivity(existingactivity);
		ActivityPojo activityPojo = ObjectMapperUtils.map(activity, ActivityPojo.class);
		activityResponse.setActivityPojo(activityPojo);
		return activityResponse;
	}

	private void ifPlaceExist(Activity existingactivity, Place place) {
		if (!ObjectUtils.isEmpty(place)) {
			place = null;
			existingactivity.setPlace(place);
			activityService.saveActivity(existingactivity);
		}

	}

	private void ifTheameExists(Activity existingactivity, Theme theme) {
		if (!ObjectUtils.isEmpty(theme)) {
			theme = null;
			existingactivity.setTheme(theme);
			activityService.saveActivity(existingactivity);
		}

	}

	public void deletePackage(long id) {
		Activity existingactivity = activityService.getActivityById(id);
		activityService.deleteActivity(existingactivity);

	}

}
