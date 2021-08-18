package com.tourcoreservice.activity.response;

import java.util.List;

import com.tourcoreservice.activity.pojo.ActivityPojo;

public class ActivityListResponse {

	List<ActivityPojo> activityPojo;

	public List<ActivityPojo> getActivityPojo() {
		return activityPojo;
	}

	public void setActivityPojo(List<ActivityPojo> activityPojo) {
		this.activityPojo = activityPojo;
	}

}
