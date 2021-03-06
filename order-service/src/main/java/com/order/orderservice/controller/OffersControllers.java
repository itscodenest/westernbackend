package com.order.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.orderservice.facade.OffersFascade;
import com.tourcoreservice.pojo.orders.OffersPojo;
import com.tourcoreservice.pojo.orders.OffersThemePojo;

@RestController
@RequestMapping("/Offers")
public class OffersControllers {

	@Autowired
	OffersFascade offersFascade;

	@GetMapping("/{travelid}")
	public OffersPojo getthemes(@PathVariable long travelid) {
		return offersFascade.get(travelid);
	}

	@DeleteMapping("/{travelid}")
	public void deletetheme(@PathVariable long travelid) {
		 offersFascade.delete(travelid);
	}

	@PutMapping("/{travelid}")
	public OffersPojo update(@RequestBody OffersPojo offersPojo, @PathVariable long travelid) {
		return offersFascade.update(offersPojo, travelid);
	}

	@PostMapping()
	public OffersPojo save(@RequestBody OffersPojo offersPojo) {
		return offersFascade.save(offersPojo);
	}

	@GetMapping("/getall")
	public List<OffersPojo> getalldetails() {
		return offersFascade.getall();
	}
	
	@GetMapping("/themename/{themename}")
	public List<OffersPojo> getbyname(@PathVariable String themename) {
		return offersFascade.getbyname(themename);
	}

}
