package com.order.orderservice.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.Offersthemeservice;
import com.tourcoreservice.entity.Offerstheme;
import com.tourcoreservice.pojo.orders.OffersThemePojo;
import com.tourcoreservice.util.ObjectMapperUtils;
@Component
public class OffersthemeFacade {
	
	@Autowired
	private Offersthemeservice offersthemeservice;

	public OffersThemePojo save(OffersThemePojo OffersThemePojo) {
		Offerstheme offerstheme = ObjectMapperUtils.map(OffersThemePojo, Offerstheme.class);
		offerstheme = offersthemeservice.save(offerstheme);
		OffersThemePojo = ObjectMapperUtils.map(offerstheme, OffersThemePojo.class);
		return OffersThemePojo;
	}

	public OffersThemePojo update(OffersThemePojo OffersThemePojo, long themeid) {
		Offerstheme offerstheme = ObjectMapperUtils.map(OffersThemePojo, Offerstheme.class);
		offerstheme = offersthemeservice.update(offerstheme, themeid);
		OffersThemePojo = ObjectMapperUtils.map(offerstheme, OffersThemePojo.class);
		return OffersThemePojo;
	}

	public OffersThemePojo delete(long themeid) {

		offersthemeservice.delete(themeid);
		return null;
	}

	public OffersThemePojo getbyid(long themeid) {
		Offerstheme offerstheme=offersthemeservice.getbyid(themeid);
		OffersThemePojo OffersThemePojo=ObjectMapperUtils.map(offerstheme, OffersThemePojo.class);
		return OffersThemePojo;
	}
	
	public List<OffersThemePojo> getall() {
		List<Offerstheme> offerstheme=offersthemeservice.getall();
		List<OffersThemePojo> OffersThemePojo=ObjectMapperUtils.mapAll(offerstheme, OffersThemePojo.class);
		return OffersThemePojo;
	}

	public OffersThemePojo getbyname(String themename) {
		Offerstheme offerstheme=offersthemeservice.getbyname(themename);
		OffersThemePojo OffersThemePojo=ObjectMapperUtils.map(offerstheme, OffersThemePojo.class);
		return OffersThemePojo;
	}

}
