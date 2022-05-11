package com.tour.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tour.service.TravelBlogService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.TravelBlog;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.tourpackage.TravelBlogPartialpojo;
import com.tourcoreservice.pojo.tourpackage.TravelBlogsPojo;
import com.tourcoreservice.response.tourpackage.Blogpojoresponse;



@Component
public class TravelBlogfascade {

	@Autowired
	private TravelBlogService travelBlogService;

	public Blogpojoresponse create(TravelBlogsPojo travelBlogsPojo) {
		Blogpojoresponse blogpojoresponse = new Blogpojoresponse();
		ResponseMessagePojo responseMessagePojos = new ResponseMessagePojo();
		try {

			TravelBlog travelBlog = ObjectMapperUtils.map(travelBlogsPojo, TravelBlog.class);
			travelBlog = travelBlogService.create(travelBlog);
			travelBlogsPojo = ObjectMapperUtils.map(travelBlog, TravelBlogsPojo.class);
			responseMessagePojos.setSuccessMessage("Blogs created succesfully");
			blogpojoresponse.setTravelBlogsPojo(travelBlogsPojo);
			return blogpojoresponse;
		} catch (Exception e) {
			responseMessagePojos.setErrorMessage(e.toString());
			return blogpojoresponse;
		}
	}

	public Blogpojoresponse update(TravelBlogsPojo travelBlogsPojo, long id) {
		Blogpojoresponse blogpojoresponse = new Blogpojoresponse();
		ResponseMessagePojo responseMessagePojos = new ResponseMessagePojo();
		try {
			TravelBlog travelBlog = ObjectMapperUtils.map(travelBlogsPojo, TravelBlog.class);
			travelBlog = travelBlogService.update(travelBlog, id);
			travelBlogsPojo = ObjectMapperUtils.map(travelBlog, TravelBlogsPojo.class);
			responseMessagePojos.setSuccessMessage("Blogs updated succesfully");
			blogpojoresponse.setTravelBlogsPojo(travelBlogsPojo);

			return blogpojoresponse;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return blogpojoresponse;
		}
	}

	public Blogpojoresponse delete(long id) {
		Blogpojoresponse blogpojoresponse = new Blogpojoresponse();
		ResponseMessagePojo messagePojo = new ResponseMessagePojo();
		try {
			travelBlogService.Delete(id);
			messagePojo.setSuccessMessage("Deleted succesfully");
			
			return blogpojoresponse;
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			return blogpojoresponse;
		}
	}

	public Blogpojoresponse Getonedata(long id) {
		Blogpojoresponse blogpojoresponse = new Blogpojoresponse();
		ResponseMessagePojo messagePojo = new ResponseMessagePojo();
		try {
			TravelBlog travelBlog = travelBlogService.Getdatabyid(id);
			TravelBlogsPojo travelBlogsPojo = ObjectMapperUtils.map(travelBlog, TravelBlogsPojo.class);
			messagePojo.setSuccessMessage("Data fetched perfectly succesfully");
			blogpojoresponse.setTravelBlogsPojo(travelBlogsPojo);
			return blogpojoresponse;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return blogpojoresponse;

		}

	}

	public Blogpojoresponse Getalldata() {
		Blogpojoresponse blogpojoresponse = new Blogpojoresponse();
		ResponseMessagePojo messagePojo = new ResponseMessagePojo();
		try {
			List<TravelBlog> travelBlog = travelBlogService.getallblogs();
			List<TravelBlogPartialpojo> partialpojos = ObjectMapperUtils.mapAll(travelBlog,
					TravelBlogPartialpojo.class);
			messagePojo.setSuccessMessage("List of Data fetched succesfully");
			blogpojoresponse.setPartialPojoBlogs(partialpojos);
			return blogpojoresponse;

		} catch (Exception e) {
			messagePojo.setErrorMessage("Data unable to fetch");
			return blogpojoresponse;
		}
	}

	public Blogpojoresponse changestatus(boolean isenable, long id) {
		Blogpojoresponse blogpojoresponse = new Blogpojoresponse();
		ResponseMessagePojo messagePojo = new ResponseMessagePojo();
		TravelBlog travelBlog = travelBlogService.Getdatabyid(id);
		travelBlog.setIsenable(isenable);
		travelBlog = travelBlogService.update(travelBlog, id);
		TravelBlogsPojo travelBlogsPojo = ObjectMapperUtils.map(travelBlog, TravelBlogsPojo.class);
		messagePojo.setSuccessMessage("Blogs updated succesfully");
		blogpojoresponse.setTravelBlogsPojo(travelBlogsPojo);
		return blogpojoresponse;

	}

	public Blogpojoresponse Getalldataactive() {
		Blogpojoresponse blogpojoresponse = new Blogpojoresponse();
		ResponseMessagePojo messagePojo = new ResponseMessagePojo();
		try {
			List<TravelBlog> travelBlog = travelBlogService.getallblogsactive();
			List<TravelBlogPartialpojo> partialpojos = ObjectMapperUtils.mapAll(travelBlog,TravelBlogPartialpojo.class);
			messagePojo.setSuccessMessage("List of Data fetched succesfully");
			blogpojoresponse.setPartialPojoBlogs(partialpojos);
			return blogpojoresponse;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return blogpojoresponse;
		}
	}
	
	public Blogpojoresponse Getallactivestories() {
		Blogpojoresponse blogpojoresponse = new Blogpojoresponse();
		ResponseMessagePojo messagePojo = new ResponseMessagePojo();
		try {
			List<TravelBlog> travelBlog = travelBlogService.getallactiveStories();
			List<TravelBlogPartialpojo> partialpojos = ObjectMapperUtils.mapAll(travelBlog,TravelBlogPartialpojo.class );
			messagePojo.setSuccessMessage("List of Data fetched succesfully");
			
			blogpojoresponse.setPartialPojoBlogs(partialpojos);
			return blogpojoresponse;

		} catch (Exception e) {
			messagePojo.setErrorMessage("Data unable to fetch");
			return blogpojoresponse;
		}
	}
	
	public Blogpojoresponse changestorystatus(boolean istravelstories, long id) {
		Blogpojoresponse blogpojoresponse = new Blogpojoresponse();
		ResponseMessagePojo messagePojo = new ResponseMessagePojo();
		TravelBlog travelBlog = travelBlogService.Getdatabyid(id);
		travelBlog.setIstravelstories(istravelstories);
		travelBlog = travelBlogService.update(travelBlog, id);
		TravelBlogsPojo travelBlogsPojo = ObjectMapperUtils.map(travelBlog,TravelBlogsPojo.class);
		messagePojo.setSuccessMessage("Blogs updated succesfully");
		blogpojoresponse.setTravelBlogsPojo(travelBlogsPojo);
		return blogpojoresponse;
	}

}
