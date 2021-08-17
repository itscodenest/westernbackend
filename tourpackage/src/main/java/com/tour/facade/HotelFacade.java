package com.tour.facade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.tour.entity.Asset;
import com.tour.entity.Category;
import com.tour.entity.Hotel;
import com.tour.entity.Theme;
import com.tour.entity.Tourpackage;
import com.tour.pojo.AssetPojo;
import com.tour.pojo.HotelPartialPojo;
import com.tour.pojo.HotelPojo;
import com.tour.pojo.HotelUpdatePojo;
import com.tour.response.AssetResponse;
import com.tour.response.HotelListResponse;
import com.tour.response.HotelResponse;
import com.tour.response.ResponseMessagePojo;
import com.tour.service.AssetService;
import com.tour.service.HotelService;
import com.tour.util.ObjectMapperUtils;

@Component
public class HotelFacade {

	@Autowired
	HotelService hotelService;
	@Autowired
	AssetService assetService;
	
	public HotelListResponse listAllHotel() {
		HotelListResponse hotelListResponse = new HotelListResponse();
		List<Hotel> HotelEntity = hotelService.listAllHotel();
		List<HotelPartialPojo> hotelPojo = ObjectMapperUtils.mapAll(HotelEntity, HotelPartialPojo.class);
		hotelListResponse.setHotelPojo(hotelPojo);
		return hotelListResponse;
	}

	public HotelResponse getHotel(long id) {
		HotelResponse hotelResponse = new HotelResponse();
		Hotel hotelEntity = hotelService.getHotelById(id);
		HotelPojo hotelPojo = ObjectMapperUtils.map(hotelEntity, HotelPojo.class);
		hotelResponse.setHotelPojo(hotelPojo);
		return hotelResponse;
	}
	
	public HotelResponse saveHotel(HotelPojo hotelPojo)
	{
		Hotel hotelEntity = ObjectMapperUtils.map(hotelPojo, Hotel.class);
		Set<Asset> assetEntity=new HashSet<>();
		for (Asset asset : hotelEntity.getImages()) {
			Asset savedAsset=assetService.saveAsset(asset);
			assetEntity.add(savedAsset);
		}
		if (!CollectionUtils.isEmpty(assetEntity)) {
			hotelEntity.setImages(assetEntity);
		}
		Hotel hotelserviceEntity = hotelService.saveHotel(hotelEntity);
		HotelPojo hotelservicePojo = ObjectMapperUtils.map(hotelserviceEntity, HotelPojo.class);
		return createDeleteUpdateResponse(null,"Created successfully");
	}
	

	public  HotelResponse updateHotel(HotelUpdatePojo hotelPojo) {
		Hotel existingHotel = hotelService.getHotelById(hotelPojo.getId());
		Set<Category> category = existingHotel.getCategories();
		existingHotel=ifCategoryExists(existingHotel,category);
	    ObjectMapperUtils.map(hotelPojo, existingHotel);
		Hotel hotelserviceEntity = hotelService.UpdateHotel(existingHotel);
		HotelPojo hotelservicePojo = ObjectMapperUtils.map(hotelserviceEntity, HotelPojo.class);
		return createDeleteUpdateResponse(hotelservicePojo,"Updated successfully");
	}
	private Hotel ifCategoryExists(Hotel existingHotel, Set<Category> categories) {
		if (!CollectionUtils.isEmpty(categories)) {
			existingHotel.getCategories().removeAll(categories);
			hotelService.saveHotel(existingHotel);
		}
		return existingHotel;
		
	}
	public HotelResponse deleteHotel(long id) {
		hotelService.deleteHotel(id);
		return createDeleteUpdateResponse(null,"Deleted successfully");
		
	}
	
	private HotelResponse createDeleteUpdateResponse(HotelPojo hotelservicePojo, String message) {
		HotelResponse hotelResponce = new HotelResponse();	
		List<ResponseMessagePojo> successMessaages=new ArrayList<>();
		ResponseMessagePojo  responseMessagePojo= new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		hotelResponce.setHotelPojo(hotelservicePojo);
		hotelResponce.setSuccessMessaages(successMessaages);
		return hotelResponce;
	}

	public HotelResponse deleteAsset(long id, long hotelid) {
		Hotel hotel=hotelService.getHotelById(hotelid);
		Asset asset = assetService.getAssetById(id);
		hotel.getImages().remove(asset);
		hotelService.UpdateHotel(hotel);
		assetService.deleteAssetById(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");
		
	}

	public HotelResponse addHotelImage(long id, AssetPojo assetPojo) {
		Hotel hotel=hotelService.getHotelById(id);
		Asset asset2 = ObjectMapperUtils.map(assetPojo, Asset.class);
    	Asset savedAsset = assetService.saveAsset(asset2);
//		hotel.setImages(savedasset);
		Set<Asset> Existingassets= hotel.getImages();
		Existingassets.add(savedAsset);
		hotel.setImages(Existingassets);
		hotelService.UpdateHotel(hotel);
		return createDeleteUpdateResponse(null, "updated successfully");
	}
}
