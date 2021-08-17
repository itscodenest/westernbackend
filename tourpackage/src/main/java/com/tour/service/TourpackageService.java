package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.entity.Facility;
import com.tour.entity.Price;
import com.tour.entity.Tourpackage;
import com.tour.repository.FacilityRepository;
import com.tour.repository.Packagerepository;
import com.tour.repository.PriceRepository;


@Service
public class TourpackageService {
	
	
	@Autowired
	private Packagerepository packagerepo;
	@Autowired
	private PriceRepository priceRepository;
	@Autowired
	private FacilityRepository facilityRepository;
	
	public List<Tourpackage> listAllPackage() {
        return packagerepo.findAll();
    }
	
	public Tourpackage savePackage(Tourpackage pack) {
		return packagerepo.save(pack);
    }
	
	public Tourpackage UpdatePackage(Tourpackage pack) {
		return packagerepo.save(pack);
	}
	
	public Tourpackage getPackageById(long id) {
        return packagerepo.findById(id).get();
    }
	
	public void deletePackage(long id) {
		 packagerepo.deleteById(id);
    }

	//price
	public Price savePrice(Price price) {
		return priceRepository.save(price);
		
	}

	public Facility saveFacity(Facility facility) {
		
		return facilityRepository.save(facility);
	}

	public void deletePackage(Tourpackage existingtourpackage) {
		packagerepo.delete(existingtourpackage);
		
	}

	
}
