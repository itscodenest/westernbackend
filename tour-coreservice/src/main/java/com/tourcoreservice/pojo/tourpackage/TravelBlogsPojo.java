package com.tourcoreservice.pojo.tourpackage;

import java.util.Date;
import java.util.List;

import com.tourcoreservice.entity.Place;
import com.tourcoreservice.entity.Tourpackage;


public class TravelBlogsPojo {

	private long id;
	private String Coverpageheading;
	private String AuthorName;

	private String CoverimageUrlforblog;
	private String ImageAltname;

	private String Coverpagedesc;
	private String BlogHeading;


	private Place place;
	private long Startingdays;
	private long StartingpricewithFli;
	private long StartingpricewithoutFli;
	private long Hotelupto;
	private String Categories;
	private String Packageheading;


	private Date CreatedOrUpdated;

	private String UpdatedBy;


	private String Blogdesc;

	private List<Tourpackage> tourpackage;


	private boolean isenable=true;
	

	private boolean istravelstories;

	private String facebooklink;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCoverpageheading() {
		return Coverpageheading;
	}

	public void setCoverpageheading(String coverpageheading) {
		Coverpageheading = coverpageheading;
	}

	public String getAuthorName() {
		return AuthorName;
	}

	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}

	public String getCoverimageUrlforblog() {
		return CoverimageUrlforblog;
	}

	public void setCoverimageUrlforblog(String coverimageUrlforblog) {
		CoverimageUrlforblog = coverimageUrlforblog;
	}

	public String getImageAltname() {
		return ImageAltname;
	}

	public void setImageAltname(String imageAltname) {
		ImageAltname = imageAltname;
	}

	public String getCoverpagedesc() {
		return Coverpagedesc;
	}

	public void setCoverpagedesc(String coverpagedesc) {
		Coverpagedesc = coverpagedesc;
	}

	public String getBlogHeading() {
		return BlogHeading;
	}

	public void setBlogHeading(String blogHeading) {
		BlogHeading = blogHeading;
	}

	public String getBlogdesc() {
		return Blogdesc;
	}

	public void setBlogdesc(String blogdesc) {
		Blogdesc = blogdesc;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public long getStartingdays() {
		return Startingdays;
	}

	public void setStartingdays(long startingdays) {
		Startingdays = startingdays;
	}

	public long getStartingpricewithFli() {
		return StartingpricewithFli;
	}

	public void setStartingpricewithFli(long startingpricewithFli) {
		StartingpricewithFli = startingpricewithFli;
	}

	public long getStartingpricewithoutFli() {
		return StartingpricewithoutFli;
	}

	public void setStartingpricewithoutFli(long startingpricewithoutFli) {
		StartingpricewithoutFli = startingpricewithoutFli;
	}

	public long getHotelupto() {
		return Hotelupto;
	}

	public void setHotelupto(long hotelupto) {
		Hotelupto = hotelupto;
	}

	public String getCategories() {
		return Categories;
	}

	public void setCategories(String categories) {
		Categories = categories;
	}

	public List<Tourpackage> getTourpackage() {
		return tourpackage;
	}

	public void setTourpackage(List<Tourpackage> tourpackage) {
		this.tourpackage = tourpackage;
	}

	public String getPackageheading() {
		return Packageheading;
	}

	public void setPackageheading(String packageheading) {
		Packageheading = packageheading;
	}

	public Date getCreatedOrUpdated() {
		return CreatedOrUpdated;
	}

	public void setCreatedOrUpdated(Date createdOrUpdated) {
		CreatedOrUpdated = createdOrUpdated;
	}

	public String getUpdatedBy() {
		return UpdatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}

	public boolean isIsenable() {
		return isenable;
	}

	public void setIsenable(boolean isenable) {
		this.isenable = isenable;
	}

	public boolean isIstravelstories() {
		return istravelstories;
	}

	public void setIstravelstories(boolean istravelstories) {
		this.istravelstories = istravelstories;
	}

	public String getFacebooklink() {
		return facebooklink;
	}

	public void setFacebooklink(String facebooklink) {
		this.facebooklink = facebooklink;
	}



}
