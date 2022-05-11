package com.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tour.facade.TravelBlogfascade;
import com.tourcoreservice.pojo.tourpackage.TravelBlogsPojo;
import com.tourcoreservice.response.tourpackage.Blogpojoresponse;

@RestController
@RequestMapping("/Blogs")
public class TravelBlogscontroller {
	@Autowired
	TravelBlogfascade travelBlogfascade;

	@PostMapping
	public Blogpojoresponse creatingblogs(@RequestBody TravelBlogsPojo travelBlogsPojo) {
		return travelBlogfascade.create(travelBlogsPojo);

	}

	@GetMapping("/{id}")
	public Blogpojoresponse getsingledata(@PathVariable long id) {
		return travelBlogfascade.Getonedata(id);
	}

	@PutMapping("/{id}")
	public Blogpojoresponse updating(@RequestBody TravelBlogsPojo travelBlogsPojo, @PathVariable long id) {
		return travelBlogfascade.update(travelBlogsPojo, id);
	}

	@DeleteMapping("/{id}")
	public Blogpojoresponse deleting(@PathVariable long id) {
		return travelBlogfascade.delete(id);
	}
	
	@GetMapping("/getall")
	public Blogpojoresponse getallBlogs() {
		return travelBlogfascade.Getalldata();
	}
	@PutMapping("/{id}/{isenable}")
	public Blogpojoresponse Activechanges(@PathVariable boolean isenable ,@PathVariable long id) {
		return travelBlogfascade.changestatus(isenable,id);
	}
	@PutMapping("/{id}/storyupdate/{istravelstories}")
	public Blogpojoresponse ActiveStorychanges(@PathVariable boolean istravelstories ,@PathVariable long id) {
		return travelBlogfascade.changestorystatus(istravelstories,id);
	}
	@GetMapping("/getallactive")
	public Blogpojoresponse getallBlogsactive() {
		return travelBlogfascade.Getalldataactive();
	}
	@GetMapping("/getactivetravelstories")
	public Blogpojoresponse getallactivetravelstories() {
		return travelBlogfascade.Getallactivestories();
	}
}

