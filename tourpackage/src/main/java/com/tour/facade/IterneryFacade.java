package com.tour.facade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.tour.entity.Asset;
import com.tour.entity.Hotel;
import com.tour.entity.Iternery;
import com.tour.entity.Tourpackage;
import com.tour.exception.DataAlreadyExistsException;
import com.tour.pojo.AssetPojo;
import com.tour.pojo.IterneryPojo;
import com.tour.response.IterneryPojoListResponse;
import com.tour.response.IterneryPojoResponse;
import com.tour.response.ResponseMessagePojo;
import com.tour.service.AssetService;
import com.tour.service.IterneryService;
import com.tour.service.TourpackageService;
import com.tour.util.ObjectMapperUtils;

@Component
public class IterneryFacade {

	@Autowired
	IterneryService iterneryService;
	
	@Autowired
	AssetService assetService;
	
	@Autowired
	TourpackageService tourPackageService;

	public IterneryPojoResponse create(IterneryPojo iterneryPojo) {
		ifIterneryExists(iterneryPojo.getDay(),iterneryPojo.getTourpackage().getId());
		Iternery iternery = ObjectMapperUtils.map(iterneryPojo, Iternery.class);
		List<Asset> asset=ObjectMapperUtils.mapAll(iterneryPojo.getImages(), Asset.class);
		Asset savedAsset=new Asset();
		for (Asset eachAsset : asset) {
			savedAsset=	assetService.saveAsset(eachAsset);
		}
		if (!ObjectUtils.isEmpty(savedAsset)) {
			Set<Asset> assetSet=new HashSet<Asset>();
			assetSet.add(savedAsset);
			iternery.setImages(assetSet);
		}
		iternery = iterneryService.create(iternery);
		iterneryPojo = ObjectMapperUtils.map(iternery, IterneryPojo.class);
		return CreateDeleteUpdateResponse(iterneryPojo, "createdSuccessfully");
	}

	private void ifIterneryExists(long day, long id) {
		Tourpackage tourPackage= tourPackageService.getPackageById(id);
		List<Iternery> iterneryList=iterneryService.getIterneries();

		for (Iternery iternery : iterneryList) {
			if (iternery.getTourpackage().getId()==id) {
				if (iternery.getDay()==day) {
					throw new DataAlreadyExistsException();
				}
			}
		}
	}

	private IterneryPojoResponse CreateDeleteUpdateResponse(IterneryPojo iterneryPojo, String message) {
		IterneryPojoResponse iterneryPojoResponse = new IterneryPojoResponse();
		List<ResponseMessagePojo> successMessaages = new ArrayList<ResponseMessagePojo>();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		responseMessagePojo.setStatus(HttpStatus.OK);
		responseMessagePojo.setSuccessMessage(message);
		successMessaages.add(responseMessagePojo);
		iterneryPojoResponse.setSuccessMessaages(successMessaages);
		return iterneryPojoResponse;
	}

	public IterneryPojoListResponse getAll() {
		IterneryPojoListResponse iterneryPojoListResponse = new IterneryPojoListResponse();
		List<Iternery> iterneryList = iterneryService.getAll();
		List<IterneryPojo> iterneryPojoList = ObjectMapperUtils.mapAll(iterneryList, IterneryPojo.class);
		iterneryPojoListResponse.setIterneryListPojo(iterneryPojoList);
		return iterneryPojoListResponse;
	}

	public IterneryPojoResponse update(IterneryPojo iterneryPojo) {
		Iternery iternery = iterneryService.findIterneryById(iterneryPojo.getId());
		Set<Asset> existImage = iternery.getImages();
		Set<Hotel> hotel = iternery.getHotels();
		ifHotelExists(iternery,hotel);
		Tourpackage tourpackage = iternery.getTourpackage();
		ifPackageExists(iternery,tourpackage);
		ObjectMapperUtils.map(iterneryPojo, iternery);
		iternery.setImages(existImage);
		iternery = iterneryService.update(iternery);
		iterneryPojo=ObjectMapperUtils.map(iternery,IterneryPojo.class);
		return CreateDeleteUpdateResponse(iterneryPojo,"Updated Successfully");
	}

	private void ifPackageExists(Iternery existingIternery, Tourpackage tourpackage) {
		if (!ObjectUtils.isEmpty(tourpackage)) {
			tourpackage = null;
			existingIternery.setTourpackage(tourpackage);
			iterneryService.create(existingIternery);
		}
		
	}

	private void ifHotelExists(Iternery existingIternery, Set<Hotel> hotels) {
		if (!ObjectUtils.isEmpty(hotels)) {
			hotels.clear();
			existingIternery.setHotels(hotels);
			iterneryService.create(existingIternery);
		}
		
	}
	public IterneryPojoResponse delete(long id) {
		Iternery iternery=iterneryService.findIterneryById(id);
		iterneryService.delete(iternery);
		return CreateDeleteUpdateResponse(null,"Deleted Successfully");
	}

	public IterneryPojoResponse deleteAsset(long id, long iterneryid) {
		Iternery iternery=iterneryService.findIterneryById(iterneryid);
		Asset asset = assetService.getAssetById(id);
		iternery.getImages().remove(asset);
		iterneryService.update(iternery);
		assetService.deleteAssetById(id);
		return CreateDeleteUpdateResponse(null, "Deleted Asset successfully");
		
	}

	public IterneryPojoResponse addIternryImage(long id, AssetPojo assetPojo) {
		Iternery iternery=iterneryService.findIterneryById(id);
		Asset asset2 = ObjectMapperUtils.map(assetPojo, Asset.class);
    	Asset savedAsset = assetService.saveAsset(asset2);
//		hotel.setImages(savedasset);
		Set<Asset> Existingassets= iternery.getImages();
		Existingassets.add(savedAsset);
		iternery.setImages(Existingassets);
		iterneryService.update(iternery);
		return CreateDeleteUpdateResponse(null, "updated Image successfully");
		
	}
}