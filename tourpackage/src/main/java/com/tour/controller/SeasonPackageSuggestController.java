package com.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tour.facade.SeasonPackageSuggestFacade;
import com.tour.pojo.SeasonPackageSuggestPojo;
import com.tour.response.SeasonPackageSuggestListResponse;
import com.tour.response.SeasonPackageSuggestResponse;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/seasonPackageSuggest")
public class SeasonPackageSuggestController {

	@Autowired
	SeasonPackageSuggestFacade seasonFacade;

	@PostMapping
	public SeasonPackageSuggestResponse create(@RequestBody SeasonPackageSuggestPojo seasonPojo) {
		return seasonFacade.create(seasonPojo);
	}

	@GetMapping("/{id}")
	public SeasonPackageSuggestResponse get(@PathVariable long id) {
		return seasonFacade.get(id);
	}

	@GetMapping
	public SeasonPackageSuggestListResponse getAll() {
		return seasonFacade.listAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		seasonFacade.delete(id);
	}

	@PutMapping("/{id}")
	public SeasonPackageSuggestResponse update(@RequestBody SeasonPackageSuggestPojo seasonPojo, @PathVariable("id") long id) {
		seasonPojo.setId(id);
		return seasonFacade.update(seasonPojo);
	}

}
