package com.tourcoreservice.pojo.tourpackage;

import java.sql.Date;

public class TravelBlogPartialpojo {

	private String AuthorName;
	private String Coverpageheading;
	private String Coverpagedesc;
	private String CoverimageUrlforblog;
	private Date CreatedOrUpdated;
	private boolean isenable;
	private long id;
	private boolean istravelstories;

	private String facebooklink;

	public String getAuthorName() {
		return AuthorName;
	}

	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}

	public String getCoverpageheading() {
		return Coverpageheading;
	}

	public void setCoverpageheading(String coverpageheading) {
		Coverpageheading = coverpageheading;
	}

	public String getCoverpagedesc() {
		return Coverpagedesc;
	}

	public void setCoverpagedesc(String coverpagedesc) {
		Coverpagedesc = coverpagedesc;
	}

	public String getCoverimageUrlforblog() {
		return CoverimageUrlforblog;
	}

	public void setCoverimageUrlforblog(String coverimageUrlforblog) {
		CoverimageUrlforblog = coverimageUrlforblog;
	}

	public Date getCreatedOrUpdated() {
		return CreatedOrUpdated;
	}

	public void setCreatedOrUpdated(Date createdOrUpdated) {
		CreatedOrUpdated = createdOrUpdated;
	}

	public boolean isIsenable() {
		return isenable;
	}

	public void setIsenable(boolean isenable) {
		this.isenable = isenable;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
