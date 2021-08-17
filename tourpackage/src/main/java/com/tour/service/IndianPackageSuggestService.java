package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.entity.IndianPackageSuggest;
import com.tour.repository.IndianPackageSuggestRepository;

@Service
public class IndianPackageSuggestService {

	@Autowired
	IndianPackageSuggestRepository indianPackageSuggestRepository;

	public IndianPackageSuggest create(IndianPackageSuggest packageSuggest) {
		return indianPackageSuggestRepository.save(packageSuggest);
	}

	public List<IndianPackageSuggest> getAll() {
		
		return indianPackageSuggestRepository.findAll();
	}

	public void delete(long id) {
		indianPackageSuggestRepository.deleteById(id);
	}

	public IndianPackageSuggest Update(IndianPackageSuggest indianPackageSuggest) {
		return indianPackageSuggestRepository.save(indianPackageSuggest);
	}
}
