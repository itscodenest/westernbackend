package com.order.orderservice.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.OffersService;
import com.order.orderservice.service.Offersthemeservice;
import com.tourcoreservice.entity.Offers;
import com.tourcoreservice.entity.Offerstheme;
import com.tourcoreservice.pojo.orders.OffersPojo;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class OffersFascade {

	@Autowired
	OffersService offersService;

	@Autowired
	Offersthemeservice offersthemeservice;

	public OffersPojo save(OffersPojo offersPojo, long themeid) {
		try {

			Offerstheme offerstheme = offersthemeservice.getbyid(themeid);
			offersPojo.setOfferstheme(offerstheme);
			Offers offers = ObjectMapperUtils.map(offersPojo, Offers.class);
			offers = offersService.save(offers);
			offersPojo = ObjectMapperUtils.map(offers, OffersPojo.class);
			return offersPojo;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public OffersPojo update(OffersPojo offersPojo, long travelid) {
		Offers offers = ObjectMapperUtils.map(offersPojo, Offers.class);
		offers = offersService.update(offers, travelid);
		offersPojo = ObjectMapperUtils.map(offers, OffersPojo.class);
		return offersPojo;
	}

	public void delete(long travelid) {
		try {
			offersService.delete(travelid);;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public OffersPojo get(long travelid) {
		Offers offers = offersService.gettraveldetails(travelid);
		OffersPojo pojoOffers = ObjectMapperUtils.map(offers, OffersPojo.class);
		return pojoOffers;
	}

	public List<OffersPojo> getall() {

		List<Offers> offers = offersService.getall();
		List<OffersPojo> pojoOffers = ObjectMapperUtils.mapAll(offers, OffersPojo.class);
		return pojoOffers;
	}

}
