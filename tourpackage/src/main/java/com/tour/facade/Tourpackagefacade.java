package com.tour.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tour.entity.Asset;
import com.tour.entity.Facility;
import com.tour.entity.Iternery;
import com.tour.entity.Place;
import com.tour.entity.Price;
import com.tour.entity.Theme;
import com.tour.entity.Tourpackage;
import com.tour.pojo.FacilityPojo;
import com.tour.pojo.InclusionPojo;
import com.tour.pojo.IterneryPojo;
import com.tour.pojo.PricePojo;
import com.tour.pojo.TourPackageIterneryPojo;
import com.tour.pojo.TourPackagePartialPojo;
import com.tour.pojo.TourPackageUpdatePojo;
import com.tour.pojo.TourpackagePojo;
import com.tour.response.PackageIdResponse;
import com.tour.response.TourPackageDetailedListResponse;
import com.tour.response.TourpackageListResponse;
import com.tour.response.TourpackageResponse;
import com.tour.service.AssetService;
import com.tour.service.IterneryService;
import com.tour.service.TourpackageService;
import com.tour.util.ObjectMapperUtils;

@Component
public class Tourpackagefacade {

	@Autowired
	TourpackageService tourPackageService;

	@Autowired
	AssetService assetService;

	@Autowired
	IterneryService iterneryService;

	public TourpackageListResponse listAllPackage() {
		TourpackageListResponse tourpackageListResponse = new TourpackageListResponse();
		List<Tourpackage> tourpackageEntity = tourPackageService.listAllPackage();
		List<TourPackagePartialPojo> tourPackagePojo = ObjectMapperUtils.mapAll(tourpackageEntity,
				TourPackagePartialPojo.class);
		tourpackageListResponse.setTourpackagePojo(tourPackagePojo);
		return tourpackageListResponse;
	}

	public TourpackageResponse getPackage(long id) {
		TourpackageResponse tourpackageResponse = new TourpackageResponse();
		Tourpackage tourpackageEntity = tourPackageService.getPackageById(id);
		TourpackagePojo tourpackagePojo = ObjectMapperUtils.map(tourpackageEntity, TourpackagePojo.class);
		tourpackageResponse.setTourpackagePojo(tourpackagePojo);
		return tourpackageResponse;

	}

	public PackageIdResponse savePackageMainDetails(TourpackagePojo tourPackagePojo) {
		PackageIdResponse packageIdResponse = new PackageIdResponse();
		Tourpackage tourpackage = ObjectMapperUtils.map(tourPackagePojo, Tourpackage.class);
		Tourpackage tourpackageEntity = tourPackageService.savePackage(tourpackage);
		TourpackagePojo tourpackagePojo = ObjectMapperUtils.map(tourpackageEntity, TourpackagePojo.class);
		packageIdResponse.setTourpackagePojo(tourpackagePojo.getId());
		return packageIdResponse;
	}

	public TourpackageResponse updatePakage(TourPackageUpdatePojo pack) {
		TourpackageResponse tourpackageResponse = new TourpackageResponse();
		Tourpackage existingtourpackage = tourPackageService.getPackageById(pack.getId());
		Facility facility = existingtourpackage.getFacility();
		Theme theme = existingtourpackage.getTheme();
		ifTheameExists(existingtourpackage, theme);
		Place place = existingtourpackage.getPlace();
		ifPlaceExist(existingtourpackage, place);
		Price price = existingtourpackage.getPrice();
		existingtourpackage.setPrice(price);
		existingtourpackage.setFacility(facility);
		ObjectMapperUtils.map(pack, existingtourpackage);
		Tourpackage tourpackageEntity = tourPackageService.savePackage(existingtourpackage);
		TourpackagePojo tourpackagePojo = ObjectMapperUtils.map(tourpackageEntity, TourpackagePojo.class);
		tourpackageResponse.setTourpackagePojo(tourpackagePojo);
		return tourpackageResponse;
	}

	private void ifPlaceExist(Tourpackage existingtourpackage, Place place) {
		if (!ObjectUtils.isEmpty(place)) {
			place = null;
			existingtourpackage.setPlace(place);
			tourPackageService.savePackage(existingtourpackage);
		}

	}

	private void ifTheameExists(Tourpackage existingtourpackage, Theme theme) {
		if (!ObjectUtils.isEmpty(theme)) {
			theme = null;
			existingtourpackage.setTheme(theme);
			tourPackageService.savePackage(existingtourpackage);
		}

	}

	@Transactional
	public void deletePackage(long id) {
		Tourpackage existingtourpackage = tourPackageService.getPackageById(id);
		List<Iternery> existingIternery = iterneryService.getIterneries();
		deleteExistingIterneries(existingIternery, id);
		Set<Asset> exstingAssets = existingtourpackage.getImages();
		Set<Asset> assetsSet = new HashSet<>();
		assetsSet.addAll(exstingAssets);
		existingtourpackage.getImages().removeAll(exstingAssets);

		for (Asset asset : assetsSet) {
			assetService.deleteAsset(asset);
		}

		tourPackageService.deletePackage(existingtourpackage);

	}

	private void deleteExistingIterneries(List<Iternery> existingIternery, long id) {
		for (Iternery iternery : existingIternery) {
			if (iternery.getTourpackage().getId() == id) {
				iterneryService.delete(iternery);
			}
		}

	}

	// price
	public PackageIdResponse createPrice(long id, PricePojo pricePojo) {
		PackageIdResponse packageIdResponse = new PackageIdResponse();
		Tourpackage tourpackage = tourPackageService.getPackageById(id);
		Price price = ObjectMapperUtils.map(pricePojo, Price.class);
		price = tourPackageService.savePrice(price);
		tourpackage.setPrice(price);
		tourpackage = tourPackageService.UpdatePackage(tourpackage);
		packageIdResponse.setTourpackagePojo(tourpackage.getId());
		return packageIdResponse;

	}

	public PackageIdResponse createFacility(long id, FacilityPojo facilityPojo) {
		PackageIdResponse packageIdResponse = new PackageIdResponse();
		Tourpackage tourpackage = tourPackageService.getPackageById(id);
		Facility facility = ObjectMapperUtils.map(facilityPojo, Facility.class);
		facility = tourPackageService.saveFacity(facility);
		tourpackage.setFacility(facility);
		tourpackage = tourPackageService.UpdatePackage(tourpackage);
		packageIdResponse.setTourpackagePojo(tourpackage.getId());
		return packageIdResponse;
	}

	public PackageIdResponse createInclusion(long id, InclusionPojo inclusionPojo) {
		PackageIdResponse packageIdResponse = new PackageIdResponse();
		Tourpackage tourpackage = tourPackageService.getPackageById(id);
		// Inclusion inclusion = ObjectMapperUtils.map(inclusionPojo, Inclusion.class);
		tourpackage.setInclusion(inclusionPojo.getInclusion());
		tourpackage.setExclusion(inclusionPojo.getExclusion());
		tourpackage.setAdditionalinfo(inclusionPojo.getAdditionalinfo());
		tourpackage = tourPackageService.UpdatePackage(tourpackage);
		packageIdResponse.setTourpackagePojo(tourpackage.getId());
		return packageIdResponse;
	}

	public PackageIdResponse createImage(long id, MultipartFile file) throws IOException {
		PackageIdResponse packageIdResponse = new PackageIdResponse();
		Tourpackage tourpackage = tourPackageService.getPackageById(id);
		Asset asset = new Asset();
		asset.setFiletype(file.getContentType());
		asset.setFilesize(String.valueOf(file.getSize()));
		asset.setImagename(file.getName());
		byte[] fileContent = Base64.getEncoder().encode(file.getBytes());
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
		asset.setBase64(encodedString);
		Set<Asset> assetset = new HashSet<Asset>();
		assetset.add(asset);
		tourpackage.setImages(assetset);
		tourpackage = tourPackageService.UpdatePackage(tourpackage);
		packageIdResponse.setTourpackagePojo(tourpackage.getId());
		return packageIdResponse;
	}

	public Set<Asset> getPackImage(long id) {
		Tourpackage tourpackage = tourPackageService.getPackageById(id);
		Set<Asset> asset = tourpackage.getImages();

		return asset;
	}

	public List<IterneryPojo> getIterneries(long packageId) {
		List<IterneryPojo> iterneriesPojoList = new ArrayList<>();
		List<Iternery> iterneryList = iterneryService.getIterneries();
		List<Iternery> iterneriesList = new ArrayList<Iternery>();
		for (Iternery iternery : iterneryList) {
			if (iternery.getTourpackage().getId() == packageId) {
				iterneriesList.add(iternery);
			}
		}
		iterneriesPojoList = ObjectMapperUtils.mapAll(iterneriesList, IterneryPojo.class);
		return iterneriesPojoList;
	}

	public TourPackageDetailedListResponse listAllDetailedPackages() {
		TourPackageDetailedListResponse tourpackageListResponse = new TourPackageDetailedListResponse();
		List<Tourpackage> tourpackageEntity = tourPackageService.listAllPackage();
		List<TourpackagePojo> tourPackagePojo = ObjectMapperUtils.mapAll(tourpackageEntity,
				TourpackagePojo.class);
		tourpackageListResponse.setTourpackagePojo(tourPackagePojo);
		return tourpackageListResponse;
	}
}
