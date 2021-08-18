package com.tourcoreservice.tourpackage.response;

import java.util.List;

import com.tourcoreservice.generic.pojo.AbstractPojoResponse;
import com.tourcoreservice.tourpackage.pojo.AssetPojo;

public class AssetListResponse extends AbstractPojoResponse{

	List<AssetPojo>  assetpojo;

	public List<AssetPojo> getAssetpojo() {
		return assetpojo;
	}

	public void setAssetpojo(List<AssetPojo> assetpojo) {
		this.assetpojo = assetpojo;
	}
}
