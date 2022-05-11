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

import com.order.orderservice.facade.OffersthemeFacade;
import com.tourcoreservice.pojo.orders.OffersThemePojo;

@RestController
@RequestMapping("/offerstheme")
public class Offersthemecontroller {
	@Autowired
	OffersthemeFacade themefascade;

	@DeleteMapping("/{themeid}")
	public void deletetheme(@PathVariable long themeid) {
		themefascade.delete(themeid);

	}

	@PutMapping("{themeid}")
	public OffersThemePojo update(@RequestBody OffersThemePojo pojoofferstheme, @PathVariable long themeid) {
		return themefascade.update(pojoofferstheme, themeid);
	}

	@PostMapping
	public OffersThemePojo save(@RequestBody OffersThemePojo pojoofferstheme) {
		return themefascade.save(pojoofferstheme);
	}

	
	@GetMapping("/{themeid}")
	public OffersThemePojo getid(@PathVariable long themeid) {
		return themefascade.getbyid(themeid);
	}
	
	@GetMapping("/themename/{themename}")
	public OffersThemePojo getid(@PathVariable String themename) {
		return themefascade.getbyname(themename);
	}
	
	@GetMapping("/getall")
	public List<OffersThemePojo> getid() {
		return themefascade.getall();
	}

}

