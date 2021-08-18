package com.activity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activity.facade.ActivityFacade;
import com.tourcoreservice.activity.pojo.ActivityPojo;
import com.tourcoreservice.activity.pojo.ActivityUpdatePojo;
import com.tourcoreservice.activity.response.ActivityIdResponse;
import com.tourcoreservice.activity.response.ActivityListResponse;
import com.tourcoreservice.activity.response.ActivityResponse;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/activity")
public class ActivityController {
	@Autowired
	ActivityFacade activityFacade;

	@GetMapping
	public ActivityListResponse allActivity() {
		return activityFacade.listallActivity();
	}

	@GetMapping("/{id}")
	public ActivityResponse getactivity(@PathVariable long id) {
		return activityFacade.getActivity(id);

	}

	@PostMapping
	public ActivityIdResponse create(@RequestBody ActivityPojo activityPojo) {
		return activityFacade.saveActivityMainDetails(activityPojo);
	}

	@PutMapping("/{id}")
	public ActivityResponse update(@RequestBody ActivityUpdatePojo activityUpdatePojo, @PathVariable long id) {
		activityUpdatePojo.setId(id);
		return activityFacade.updateActivity(activityUpdatePojo);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		activityFacade.deletePackage(id);
	}

}
