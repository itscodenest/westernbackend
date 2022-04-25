package com.tourcoreservice.pojo.orders;

import java.util.Set;

import com.tourcoreservice.entity.Offers;

public class OffersThemePojo {
	
		private long themeid;
		
		private String themename;
		
		private Set<Offers> offers;

	
		public long getThemeid() {
			return themeid;
		}

		public void setThemeid(long themeid) {
			this.themeid = themeid;
		}

		public String getThemename() {
			return themename;
		}

		public void setThemename(String themename) {
			this.themename = themename;
		}

		public Set<Offers> getOffers() {
			return offers;
		}

		public void setOffers(Set<Offers> offers) {
			this.offers = offers;
		}
		
		

	}


