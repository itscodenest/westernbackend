package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tour.repository.TravelBlogRepository;
import com.tourcoreservice.entity.TravelBlog;

@Service
public class TravelBlogService {
	@Autowired
	private TravelBlogRepository travelBlogRepository;
	

	public TravelBlog create(TravelBlog travelBlog) {
		return travelBlogRepository.save(travelBlog);
	}

	public TravelBlog update(TravelBlog travelBlog, long id) {
		travelBlog.setId(id);
		return travelBlogRepository.save(travelBlog);
	}

	public void Delete(long id) {
		travelBlogRepository.deleteById(id);
	}

	public TravelBlog Getdatabyid(long id) {

		return travelBlogRepository.findById(id).get();

	}

	public List<TravelBlog> getallblogs() {
		return travelBlogRepository.findAll();
	}

	public List<TravelBlog> getallblogsactive() {
		return travelBlogRepository.findAllactive();
	}

	public List<TravelBlog> getallactiveStories() {
		return travelBlogRepository.findAllactiveStories();
	}

	

}
